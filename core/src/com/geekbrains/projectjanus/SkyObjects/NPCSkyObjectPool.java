package com.geekbrains.projectjanus.SkyObjects;

import com.geekbrains.projectjanus.Pools.Pool;


/**
 * Created by Raserei on 02.03.2018.
 */

public class NPCSkyObjectPool extends Pool<NPCSkyObject> {
    @Override
    protected NPCSkyObject newObject() {
        return new NPCSkyObject();
    }
}
