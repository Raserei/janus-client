package com.geekbrains.projectjanus.Modes;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.SkyObject;

import java.util.Map;

/**
 * Created by Raserei on 28.02.2018.
 */

public interface MovementMode<T extends SkyObject> {
    void move(T object);
}
