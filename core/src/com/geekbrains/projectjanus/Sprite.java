package com.geekbrains.projectjanus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.SkyObject;
import com.geekbrains.projectjanus.SkyObjects.types.SkyObjectType;

/**
 * Created by Raserei on 02.03.2018.
 */

public class Sprite {
    private Texture texture;
    private SkyObject skyObject;

    public Sprite(){
        this.texture = new Texture("textures/badlogic.jpg");
    }

    public void setSkyObject(SkyObject skyObject){
        this.skyObject = skyObject;
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture,skyObject.getPosition().x,skyObject.getPosition().y,40,40);
    }

    public void dispose(){
        texture.dispose();
    }
}
