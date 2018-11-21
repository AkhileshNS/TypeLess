package com.OnCreators.TypeLess;

import java.util.Arrays;
import java.util.HashMap;

public class Dictionary {

    HashMap<Object, Object> kv;
    List keys;

    public Dictionary(Object ...objects) {
        kv = new HashMap<>();
        keys = new List();
        for (Object o: objects) {
            Perform.append(keys,Perform.createVarFromObj(o));
            kv.put(o, null);
        }
    }

    public void setValues(Object ...objects) {
        for (int i=0; i<keys.length(); i++) {
            kv.put(keys.data[i], objects[i]);
        }
    }

    public List getValues() {
        List values = new List();
        for (int i=0; i<keys.length(); i++) {
            Perform.append(values ,Perform.createVarFromObj(kv.get(keys.data[i])));
        }
        return values;
    }

    public void set(Object key, Object value) {
        if (key!=null) {
            if (Arrays.asList(keys.data).contains(key)) {
                kv.put(key, value);
            }
        }
    }

    public Object get(Object key) {
        if (key!=null) {
            if (Arrays.asList(keys.data).contains(key)) {
                return key;
            }
        }
        return null;
    }

}
