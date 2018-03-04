package com.geekbrains.projectjanus.Emitters;

import com.badlogic.gdx.math.Vector2;
import com.geekbrains.projectjanus.SkyObjects.NPCSkyObject;
import com.geekbrains.projectjanus.SkyObjects.NPCSkyObjectPool;
import com.geekbrains.projectjanus.SkyObjects.types.NPCSkyObjectType;
import com.geekbrains.projectjanus.utils.math.Rnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Raserei on 02.03.2018.
 */

public class NPCSkyObjectEmitter {
    private Vector2 worldBounds;
    private NPCSkyObjectPool npcSkyObjectPool;
    private ArrayList<NPCSkyObjectType> reference;

    private Map<String, Float> generateTimers;
    private float generateInterval = 4f;

    public NPCSkyObjectEmitter(Vector2 worldBounds,
                               NPCSkyObjectPool npcSkyObjectPool,
                               ArrayList<NPCSkyObjectType> reference) {
        this.worldBounds = worldBounds;
        this.npcSkyObjectPool = npcSkyObjectPool;
        this.reference = reference;
        generateTimers = new HashMap<>();
        for (NPCSkyObjectType objType: reference) {
            generateTimers.put(objType.getType(),0f);
        }
    }


    public void emitNPCSkyObject(float delta) {
        for (NPCSkyObjectType objType : reference) {
            if (npcSkyObjectPool.getActiveObjects().size()>=objType.getMaxAmount()) return;
            String type = objType.getType();
            float temp = generateTimers.get(type);
            temp+=delta;
            generateTimers.put(type,temp);
            if (temp >= Rnd.nextFloat(objType.getMinGenerateTime(),objType.getMaxGenerateTime())) {
                generateTimers.put(type,0f);
                NPCSkyObject npcSkyObject = npcSkyObjectPool.obtain();
                npcSkyObject.set(reference.get(0),
                        new Vector2(Rnd.nextFloat(0, 200), Rnd.nextFloat(0, 300)));
            }
        }
    }
}
