package com.geekbrains.projectjanus.SkyObjects;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.types.SkyObjectType;


public abstract class SkyObject<T extends SkyObjectType>
{

    protected String type;
    protected String displayedName;
    protected int weight;
    protected int density;
    protected int gravity;
    protected float velocity;
    protected float radius;
    protected Vector2 position;
    protected Vector2 direction;


    public SkyObject(){
        position = new Vector2();
        direction = new Vector2();
    }


    public void set(T skyObjectType, Vector2 position){
        this.type = skyObjectType.getType();
        this.displayedName = skyObjectType.getDisplayedName();
        this.weight = skyObjectType.getWeight();
        this.density = skyObjectType.getDensity();
        this.gravity = skyObjectType.getGravity();
        this.velocity = skyObjectType.getVelocity();
        this.radius = skyObjectType.getRadius();
        this.position.set(position);
    }

    public abstract void update(float delta);
    public Vector2 getPosition(){
        return this.position;
    }

}
