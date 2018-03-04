package com.geekbrains.projectjanus.Modes;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.NPCSkyObject;
import com.geekbrains.projectjanus.SkyObjects.SkyObject;

import java.util.Map;

/**
 * Created by Raserei on 28.02.2018.
 */

public class OrbitalMovementMode implements MovementMode<NPCSkyObject> {
    private static final String[] PARAMETER_LIST = new String[]{"RadiusCoefficient, "};
    private Map<String, Float> movementParameters;

    @Override
    public void move(NPCSkyObject object) {

    }
}
