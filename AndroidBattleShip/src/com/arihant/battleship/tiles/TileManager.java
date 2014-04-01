package com.arihant.battleship.tiles;

import java.util.ArrayList;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.arihant.battleship.ResourceManager;

public class TileManager {

	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public TileManager(VertexBufferObjectManager vbom) {
		tiles.add(new Tile("Grass", 1, 0, 0, 5f, 0f, .5f, ResourceManager
				.getInstance().grass_region, vbom));
		tiles.add(new Tile("Grass Platform", 2, 0, 0, 5f, 0f, .5f,
				ResourceManager.getInstance().grass_platform_region, vbom));
	}

	public Tile getTileById(int id) {
		for (Tile t : tiles) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}
}
