package com.neet.ghostcatch.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.neet.ghostcatch.handlers.BBInput;
import com.neet.ghostcatch.handlers.BBInputProcessor;
import com.neet.ghostcatch.handlers.BoundedCamera;
import com.neet.ghostcatch.handlers.Content;
import com.neet.ghostcatch.handlers.GameStateManager;

public class Game implements ApplicationListener {
	
	public static final String TITLE = "Block Bunny";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 240;
	public static final int SCALE = 2;
	public static final float STEP = 1 / 60f;
	
	private SpriteBatch sb;
	private BoundedCamera cam;
	private OrthographicCamera hudCam;
	
	private GameStateManager gsm;
	
	public static Content res;
	
	public void create() {
		
		Texture.setEnforcePotImages(false);
		Gdx.input.setInputProcessor(new BBInputProcessor());
		
		res = new Content();
		res.loadTexture("res/images/menu.png");
		res.loadTexture("res/images/bgs.png");
		res.loadTexture("res/images/hud.png");
		res.loadTexture("res/images/mc.png");
		res.loadTexture("res/images/greenghost.png");
		res.loadTexture("res/images/redghost.png");
		res.loadTexture("res/images/blueghost.png");
		res.loadTexture("res/images/spikes.png");
		
		res.loadSound("res/sfx/beep.wav");
		res.loadSound("res/sfx/hit.wav");
		res.loadSound("res/sfx/Menu_Choice.wav");
		res.loadSound("res/sfx/ouch.wav");
		res.loadSound("res/sfx/collect.wav");
		
		res.loadMusic("res/music/dark fallout.ogg");
		res.getMusic("dark fallout").setLooping(true);
		res.getMusic("dark fallout").setVolume(0.5f);
		res.getMusic("dark fallout").play();
		
		cam = new BoundedCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		sb = new SpriteBatch();
		
		gsm = new GameStateManager(this);
		
	}
	
	public void render() {
		
		Gdx.graphics.setTitle(TITLE + " -- FPS: " + Gdx.graphics.getFramesPerSecond());
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
		BBInput.update();
		
	}
	
	public void dispose() {
		res.removeAll();
	}
	
	public void resize(int w, int h) {}
	
	public void pause() {}
	
	public void resume() {}
	
	public SpriteBatch getSpriteBatch() { return sb; }
	public BoundedCamera getCamera() { return cam; }
	public OrthographicCamera getHUDCamera() { return hudCam; }
	
}
