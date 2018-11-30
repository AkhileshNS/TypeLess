package com.OnCreators.TypeLess;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    //==================================================================================================================
    // internal class Variables
    private HashMap<Object, Object> data = null;
    private ArrayList<Object> keys = null;

    //==================================================================================================================
    // Constructors
    public Dictionary(Object ...objects) {
        data = new HashMap<>();
        keys = new ArrayList<>();
        setValuesAt(objects);
    }

    //==================================================================================================================
    // Multiple Values Read and Write Operations
    public List getValues() {
        List values = new List();
        for (Object key : keys) {
            if (data.get(key)!=null) {
                values.append(data.get(key));
            }
        }
        return values;
    }

    public void setValues(Object ...objects) {
        String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        ArrayList<Object> tempKeys = new ArrayList<>();

        int i=0; // keys index
        int j=0; // objects index
        while (j<objects.length && i<keys.size()) {
            if (objects[i].getClass().getSimpleName().equals("Dictionary")) {
                Dictionary d = (Dictionary) objects[i];
                if (d.hasKey(extendCheck)) {
                    List Keys = d.getKeys();
                    for (Var v: Keys.getList()) {
                        if (!v.get().equals(extendCheck)) {
                            tempKeys.add(v.get());
                            set(v.get(), d.get(v.get()));
                            i++;
                        }
                    }
                    j++;
                }
            }
            if (!tempKeys.contains(keys.get(i)) && !objects[j].getClass().getSimpleName().equals("Dictionary")) {
                set(keys.get(i), objects[j]);
                j++;
                i++;
            }
        }
    }

    public List getKeys() {
        List Keys = new List();
        for (Object key : keys) {
            Keys.append(key);
        }
        return Keys;
    }

    public void setKeys(Object ...objects) {
        data = new HashMap<>();
        keys = new ArrayList<>();
        addKeys(objects);
    }

    public void addKeys(Object ...objects) {
        String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        for (Object o : objects) {
            boolean isExtending = false;
            if (o.getClass().getSimpleName().equals("List")) {
                List l = (List) o;
                if (l.length()>1) {
                    if (l.getType(0)==0) {
                        String s = (String) l.get(0);
                        if (s.equals(extendCheck)) {
                            isExtending = true;
                            for (int i=1; i<l.length(); i++) {
                                if (!keys.contains(l.get(i))) {
                                    keys.add(l.get(i));
                                    set(l.get(i), null);
                                }
                            }
                        }
                    }
                }
            }
            if (!isExtending && !keys.contains(o)) {
                keys.add(o);
                set(o, null);
            }
        }
    }

    public List getValuesAt(Object ...objs) {
        List Keys = new List();
        for (Object o: objs) {
            if (keys.contains(o)) {
                Keys.append(data.get(o));
            }
        }
        return Keys;
    }

    public void setValuesAt(Object ...objs) {
        String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";

        ArrayList<Object> Keys = new ArrayList<>();
        ArrayList<Object> Values = new ArrayList<>();

        for (Object o: objs) {
            if (o==null) {
                Values.add(null);
            } else if (o.getClass().getSimpleName().equals("Dictionary")) {
                if (((Dictionary) o).hasKey(extendCheck)) {
                    List tempKeys = ((Dictionary) o).getKeys();
                    List tempValues = ((Dictionary) o).getValues();
                    for (int i=0; i<tempKeys.length(); i++) {
                        if (!tempKeys.get(i).equals(extendCheck) && !Keys.contains(tempKeys.get(i)) && !Values.contains(tempValues.get(i))) {
                            Keys.add(tempKeys.get(i));
                            Values.add(tempValues.get(i));
                        }
                    }
                }
            } else {
                if (Keys.size() == Values.size()) {
                    Keys.add(o);
                } else {
                    Values.add(o);
                }
            }
        }

        for (int i=0; i<Keys.size(); i++) {
            keys.add(Keys.get(i));
            set(Keys.get(i), Values.get(i));
        }

    }

    //==================================================================================================================
    // Single Value Read and Write Operations
    public void set(Object k, Object v) {
        if (k!=null) {
            if (!keys.contains(k)) {
                keys.add(k);
            }
            data.put(k, v);
            if (v!=null) {
                if (v.getClass().getSimpleName().equals("Dictionary")) {
                    data.put(k, new Dictionary(Perform.extend((Dictionary) v)));
                }
                if (v.getClass().getSimpleName().equals("List")) {
                    data.put(k, new List(Perform.extend((List) v)));
                }
                if (v.getClass().getSimpleName().equals("Tuple")) {
                    data.put(k, new Tuple(Perform.extend((Tuple) v)));
                }
            }
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

    public void remove(Object k) {
        if (k!=null) {
            if (keys.contains(k)) {
                keys.remove(k);
                data.remove(k);
            }
        }
    }
    //==================================================================================================================
    // Utility Functions
    public Boolean hasKey(Object key) {
        return keys.contains(key);
    }

    public void print() {
        System.out.println("{");
        for (Object o: keys) {
            // Print Key
            if (o.getClass().getSimpleName().equals("String")) {
                System.out.print("\t\"" + o + "\": ");
            } else {
                System.out.print("\t" + o + ": ");
            }
            // Print Value
            if (data.get(o)==null) {
                System.out.print("null");
            } else if (data.get(o).getClass().getSimpleName().equals("List")) {
                ((List) data.get(o)).print();
            } else if (data.get(o).getClass().getSimpleName().equals("Tuple")) {
                ((Tuple) data.get(o)).print();
            } else if (data.get(o).getClass().getSimpleName().equals("Dictionary")) {
                ((Dictionary) data.get(o)).print();
            } else if(data.get(o).getClass().getSimpleName().equals("String")) {
                System.out.print("\"" + data.get(o) + "\"");
            } else {
                System.out.print(data.get(o));
            }
            System.out.print("\n");
        }
        System.out.println("}");
    }

}
