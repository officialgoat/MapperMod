package com.github.officialgoat.mappermod.mapper_app.data;

import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;

import java.util.Map;

public class Map2D {
    private Map<Coordinates, LightChunk> map;


    public LightChunk getChunk(Coordinates cord) {
        if (map.containsKey(cord)) {
            return map.get(cord);
        }
        //else
        return genAndSaveChunk();
    }

    private LightChunk genAndSaveChunk() {
        return null; //Todo
    }

    private IAreaFactory<LazyArea> genLazyArea(long seed){
        return null;
    }
}
