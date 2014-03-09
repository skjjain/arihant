package com.vastunidesh.sampletts;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

public class MainActivity extends Activity implements OnInitListener {
	
	TextToSpeech talker;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        talker = new TextToSpeech(this, this);
    }
    
    public void say(String text2say){
    	talker.speak(text2say, TextToSpeech.QUEUE_FLUSH, null);
    }

	@Override
	public void onInit(int status) {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		say("The Time is "+sdf.format(cal.getTime()));
		
	}
	
	@Override
	public void onDestroy() {
		if (talker != null) {
			talker.stop();
			talker.shutdown();
		}

		super.onDestroy();
	}
}
