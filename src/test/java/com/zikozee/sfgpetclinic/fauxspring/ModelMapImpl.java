package com.zikozee.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zikoz
 * @created : 17 Apr, 2021
 */
public class ModelMapImpl implements Model{

    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        //do nothing
    }

    @Override
    public Map<String, Object> getMap() {
        return map;
    }
}
