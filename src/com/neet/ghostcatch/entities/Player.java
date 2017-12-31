package com.neet.ghostcatch.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.neet.ghostcatch.main.Game;

public class Player extends B2DSprite {
	
	private int numGhost;
	private int totalGhost;
	
	public Player(Body body) {
		
		super(body);
		
		Texture tex = Game.res.getTexture("mc");
		TextureRegion[] sprites = new TextureRegion[4];
		for(int i = 0; i < sprites.length; i++) {
			sprites[i] = new TextureRegion(tex, i * 32, 0, 32, 32);
		}
		
		animation.setFrames(sprites, 1 / 12f);
		
		width = sprites[0].getRegionWidth();
		height = sprites[0].getRegionHeight();
		
	}
	
	public void collectGhost() { numGhost++; }
	public int getNumGhost() { return numGhost; }
	
	public void setTotalGhost(int i) { totalGhost = i; }
	public int getTotalCrystals() { return totalGhost; }
	
}
