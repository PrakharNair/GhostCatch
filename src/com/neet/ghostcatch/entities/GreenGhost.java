package com.neet.ghostcatch.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.neet.ghostcatch.main.Game;

public class GreenGhost extends B2DSprite {
	
	public GreenGhost(Body body) {
		
		super(body);
		
		Texture tex = Game.res.getTexture("greenghost");
		TextureRegion[] sprites = TextureRegion.split(tex, 25, 35)[0];
		animation.setFrames(sprites, 1 / 6f);
		
		width = sprites[0].getRegionWidth();
		height = sprites[0].getRegionHeight();
		
	}
	
}
