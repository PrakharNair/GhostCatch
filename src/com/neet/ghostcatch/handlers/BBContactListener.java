package com.neet.ghostcatch.handlers;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.Array;

public class BBContactListener implements ContactListener {
	
	private int numFootContacts;
	private Array<Body> bodiesToRemove;
	private boolean playerDead;
	public boolean greenColor; 
	public boolean redColor;
	public boolean blueColor;
	
	public BBContactListener() {
		super();
		bodiesToRemove = new Array<Body>();
	}
	
	public void beginContact(Contact contact) {
		
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		if(fa == null || fb == null) return;
		
		if(fa.getUserData() != null && fa.getUserData().equals("foot")) {
			numFootContacts++;
		}
		if(fb.getUserData() != null && fb.getUserData().equals("foot")) {
			numFootContacts++;
		}
		
		if(fa.getUserData() != null && fa.getUserData().equals("greenghost")) {
			bodiesToRemove.add(fa.getBody());
			greenColor = true; 
			redColor = false;
			blueColor = false;
		}
		if(fb.getUserData() != null && fb.getUserData().equals("greenghost")) {
			bodiesToRemove.add(fb.getBody());
			greenColor = true; 
			redColor = false;
			blueColor = false;
		}
		if(fa.getUserData() != null && fa.getUserData().equals("redghost")) {
			
			bodiesToRemove.add(fa.getBody());
			redColor = true; 
			greenColor = false; 
			blueColor = false;
		}
		if(fb.getUserData() != null && fb.getUserData().equals("redghost")) {
			bodiesToRemove.add(fb.getBody());
			redColor = true; 
			greenColor = false; 
			blueColor = false;		
			
		}
		if(fa.getUserData() != null && fa.getUserData().equals("blueghost")) {
			
			bodiesToRemove.add(fa.getBody());
			redColor = false; 
			greenColor = false; 
			blueColor = true;		
			
		}
		if(fb.getUserData() != null && fb.getUserData().equals("blueghost")) {
			bodiesToRemove.add(fb.getBody());
			redColor = false; 
			greenColor = false; 
			blueColor = true;	
		}

		
		
		if(fa.getUserData() != null && fa.getUserData().equals("spike")) {
			playerDead = true;
		}
		if(fb.getUserData() != null && fb.getUserData().equals("spike")) {
			playerDead = true;
		}
		
	}
	
	public void endContact(Contact contact) {
		
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		if(fa == null || fb == null) return;
		
		if(fa.getUserData() != null && fa.getUserData().equals("foot")) {
			numFootContacts--;
		}
		if(fb.getUserData() != null && fb.getUserData().equals("foot")) {
			numFootContacts--;
		}
		
	}
	
	public boolean playerCanJump() { return numFootContacts > 0; }
	public Array<Body> getBodies() { return bodiesToRemove; }
	public boolean isPlayerDead() { return playerDead; }
	
	public void preSolve(Contact c, Manifold m) {}
	public void postSolve(Contact c, ContactImpulse ci) {}
	
}
