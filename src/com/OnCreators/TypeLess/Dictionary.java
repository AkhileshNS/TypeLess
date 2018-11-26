package com.OnCreators.TypeLess;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    //==================================================================================================================
    // internal class Variables
    HashMap<Object, Object> data = null;
    ArrayList<Object> keys = null;

    //==================================================================================================================
    // Constructors
    public Dictionary(Object ...objects) {
        data = new HashMap<>();
        keys = new ArrayList<>();

        for (Object o : objects) {
            keys.add(o);
            data.put(o, null);
        }
    }

    //==================================================================================================================
    // Multiple Values Read and Write Operations
    public void setValues(Object ...objects) {
        if (objects.length<keys.size()+1) {
            for (int i=0; i<objects.length; i++) {
                data.put(keys.get(i), objects[i]);
            }
        }
    }

    public List getValues() {
        List values = new List();
        for (int i=0; i<keys.size(); i++) {
            values.append(data.get(keys.get(i)));
        }
        return values;
    }

    //==================================================================================================================
    // Single Value Read and Write Operations
    public void set(Object k, Object v) {
        if (k!=null) {
            if (!keys.contains(k)) {
                keys.add(k);
            }
            data.put(k, v);
        }
    }

    public Object get(Object k) {
        if (k!=null) {
            if (keys.contains(k)) {
                return data.get(keys.get(keys.indexOf(k)));
            }
        }
        return null;
    }
    //==================================================================================================================

}
