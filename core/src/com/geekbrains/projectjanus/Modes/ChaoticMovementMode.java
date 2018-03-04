package com.geekbrains.projectjanus.Modes;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.NPCSkyObject;
import com.geekbrains.projectjanus.utils.math.Rnd;

import java.util.Map;


public class ChaoticMovementMode implements MovementMode<NPCSkyObject> {
    private static final String[] PARAMETER_LIST = new String[]{"DirectionChangePossibilityThreshold"};
    private Map<String, Float> movementParameters;


    @Override
    public void move(NPCSkyObject object) {
        movementParameters = object.getMovementParameters();
        if(!checkParams(movementParameters)) throw new RuntimeException("Incorrect movement parameters");
        if (Rnd.nextFloat(0,1)>movementParameters.get(PARAMETER_LIST[0])){
            object.setDirection(Rnd.nextFloat(-1,1),Rnd.nextFloat(-1,1));
        }
    }

    private boolean checkParams(Map<String, Float> movementParameters){
        for (String param:PARAMETER_LIST) {
            if (!movementParameters.containsKey(param)) return false;
        }
        return true;
    }
}
