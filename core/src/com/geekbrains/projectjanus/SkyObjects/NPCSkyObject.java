package com.geekbrains.projectjanus.SkyObjects;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.types.NPCSkyObjectType;
import com.geekbrains.projectjanus.Modes.MovementMode;

import java.util.Map;

/**
 * Created by Raserei on 02.03.2018.
 */

public class NPCSkyObject extends SkyObject<NPCSkyObjectType> {

    private MovementMode movementMode;
    private Map<String,Float> movementParameters;

    @Override
    public void set(NPCSkyObjectType npcSkyObjectType, Vector2 position) {
        super.set(npcSkyObjectType, position);
        this.movementMode = npcSkyObjectType.getMovementMode();
        this.movementParameters = npcSkyObjectType.getMovementParameters();
    }

    @Override
    public void update(float delta) {
        movementMode.move(this);
        position.mulAdd(direction,delta*velocity);
    }

    public Map<String, Float> getMovementParameters() {
        return movementParameters;
    }


    public void setDirection(float x, float y) {
        this.direction.add(x,y).nor();
    }

}
