package com.arihant.firstandengineproject;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import android.app.AlertDialog;

import com.arihant.firstandengineproject.TicTacToeModel.Piece;

/**
 * (c) 2010 Nicolas Gramlich (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 11:54:51 - 03.04.2010
 */
public class GameActivity extends SimpleBaseGameActivity implements
		OnClickListener {
	// ===========================================================
	// Constants
	// ===========================================================

	final private static int CAMERA_WIDTH = 480;
	final private static int CAMERA_HEIGHT = 480;

	final private static int GRID_WIDTH = 3;
	final private static int GRID_HEIGHT = 3;
	private static final int STROKE_WIDTH = 4;

	// ===========================================================
	// Fields
	// ===========================================================

	private BuildableBitmapTextureAtlas mBitmapTextureAtlas;
	private ITextureRegion mBlankTextureRegion;
	private ITextureRegion mXTextureRegion;
	private ITextureRegion mOTextureRegion;
	private ButtonSprite[][] gridSprites = new ButtonSprite[GRID_WIDTH][GRID_HEIGHT];
	private TicTacToeModel board = new TicTacToeModel();
	private Piece currentPlayer = board.getCurrentPlayer();

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	public void onCreateResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

		this.mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(
				this.getTextureManager(), 512, 512);
		this.mBlankTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this,
						"blankIcon.png");
		this.mXTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "xIcon.png");
		this.mOTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "oIcon.png");

		try {
			this.mBitmapTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 0, 0));
			this.mBitmapTextureAtlas.load();
		} catch (TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}

	@Override
	public void onClick(final ButtonSprite pButtonSprite, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				float x = pButtonSprite.getX();
				float y = pButtonSprite.getY();
				
				int gridX = (int) Math.floor(x / CAMERA_WIDTH * GRID_WIDTH);
				int gridY = (int) Math.floor(y / CAMERA_HEIGHT * GRID_HEIGHT);
				
				if(gridSprites[gridX][gridY] == pButtonSprite && currentPlayer == board.getCurrentPlayer()){
					//Update Model
					board.setValue(gridX, gridY, currentPlayer);
					
					pButtonSprite.setEnabled(false);
					
					if(currentPlayer == Piece.X){
						pButtonSprite.setCurrentTileIndex(1);
					}else{
						pButtonSprite.setCurrentTileIndex(2);
					}
					Piece winner = board.checkWinner();
					if(winner != Piece._){
						AlertDialog.Builder Adbuider = new AlertDialog.Builder(GameActivity.this);
						Adbuider.setMessage(winner + " wins!").show();
						reset();
					}
					
					currentPlayer = board.getCurrentPlayer();
				}
				
			}
		});

	}

	protected void reset() {
		for (int i = 0; i < GRID_WIDTH; i++) {
			for (int j = 0; j < GRID_HEIGHT; j++) {
				gridSprites[i][j].setEnabled(true);
				gridSprites[i][j].setCurrentTileIndex(0);
			}

		}
		board.reset();
		
	}

	@Override
	protected Scene onCreateScene() {
		Scene scene = new Scene();
		scene.setBackground(new Background(Color.WHITE));
		final VertexBufferObjectManager vertexBufferObjectManager = this
				.getVertexBufferObjectManager();

		float lineX[] = new float[GRID_WIDTH];
		float lineY[] = new float[GRID_HEIGHT];

		float touchX[] = new float[GRID_WIDTH];
		float touchY[] = new float[GRID_HEIGHT];

		float midTouchX = CAMERA_WIDTH / GRID_WIDTH / 2;
		float midTouchY = CAMERA_HEIGHT / GRID_HEIGHT / 2;

		float halfTouchX = mBlankTextureRegion.getWidth() / 2;
		float halfTouchY = mBlankTextureRegion.getHeight() / 2;

		float paddingX = midTouchX - halfTouchX;
		float paddingY = midTouchY - halfTouchY;

		for (int i = 0; i < GRID_WIDTH; i++) {
			lineX[i] = CAMERA_WIDTH / GRID_WIDTH * i;
			touchX[i] = lineX[i] + paddingX;
		}

		for (int i = 0; i < GRID_HEIGHT; i++) {
			lineY[i] = CAMERA_HEIGHT / GRID_HEIGHT * i;
			touchY[i] = lineY[i] + paddingY;
		}

		for (int i = 0; i < GRID_WIDTH; i++) {
			final Line line = new Line(lineX[i], 0, lineX[i], CAMERA_WIDTH,
					STROKE_WIDTH, vertexBufferObjectManager);
			line.setColor(Color.BLACK);
			scene.attachChild(line);
		}

		for (int i = 0; i < GRID_HEIGHT; i++) {
			final Line line = new Line(0, lineY[i], CAMERA_HEIGHT, lineY[i],
					STROKE_WIDTH, vertexBufferObjectManager);
			line.setColor(Color.BLACK);
			scene.attachChild(line);
		}

		for (int i = 0; i < GRID_WIDTH; i++) {
			for (int j = 0; j < GRID_HEIGHT; j++) {
				final ButtonSprite button = new ButtonSprite(touchX[i],
						touchY[j], this.mBlankTextureRegion,
						this.mXTextureRegion, this.mOTextureRegion,
						this.getVertexBufferObjectManager(), this);
				scene.registerTouchArea(button);
				scene.attachChild(button);
				gridSprites[i][j] = button;
			}

		}

		scene.setTouchAreaBindingOnActionDownEnabled(true);

		return scene;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
