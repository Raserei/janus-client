package com.geekbrains.projectjanus.Pools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.geekbrains.projectjanus.SkyObjects.SkyObject;
import com.geekbrains.projectjanus.SkyObjects.types.NPCSkyObjectType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Raserei on 02.03.2018.
 */

public abstract class Pool<T extends SkyObject> {

    protected final List<T> activeObjects = new LinkedList<>(); //active objects list
    protected final List<T> freeObjects = new ArrayList<>();   // free/waiting objects list

    protected abstract T newObject();

    //move (if any) one object from free list or add new one to active list
    public T obtain(){
        T object;
        if(freeObjects.isEmpty()){
            object = newObject();
        }
        else object = freeObjects.remove(freeObjects.size()-1);
        activeObjects.add(object);
        return object;
    }


    public void drawActiveObjects(SpriteBatch batch){
        for (T o:activeObjects) {
            //o.draw(batch);
        }
    }

    public void free(T object){
        if (!activeObjects.remove(object)){
            throw new RuntimeException("Non-existing object deletion");
        }
        freeObjects.add(object);
    }

    public void freeAllDestroyedActiveObjects (){
//        for (int i = 0; i < activeObjects.size(); i++) {
//            T obj = activeObjects.get(i);
//            if (obj.isDestroyed()){
//                free(obj);
//                i--;
//                obj.setDestroyed(false);
//            }
//        }
    }

    public void update(float delta){
        for (T o: activeObjects) {
            o.update(delta);
        }
    }

    public void dispose (){
        activeObjects.clear();
        freeObjects.clear();
    }

//    public void resize (){
////        for (T o: activeObjects){
////            o.resize(worldBounds);
////        }
//    }

    public List<T> getActiveObjects(){
        return activeObjects;
    }

    public void freeAllActiveObjects (){
        for (int i = 0; i < activeObjects.size(); i++) {
            T obj = activeObjects.get(i);
            free(obj);
            i--;
        }
    }
}
