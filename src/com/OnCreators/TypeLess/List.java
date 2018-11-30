package com.OnCreators.TypeLess;

import java.util.ArrayList;

public class List {

    //==================================================================================================================
    // internal class Variables
    private ArrayList<Var> data;

    //==================================================================================================================
    // Constructors
    public List(){
        data = new ArrayList<>();
    }

    public List(Var[] vars) {
        data = new ArrayList<>();
        for (Var v :vars) {
            if (v==null) {
                data.add(null);
            } else {
                append(v.get());
            }
        }
    }

    public List(Const[] consts) {
        data = new ArrayList<>();
        for (Const c :consts) {
            if (c==null) {
                data.add(null);
            } else {
                append(c.get());
            }
        }
    }

    public List(Object ... args){
        String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        data = new ArrayList<>();
        for (Object o: args) {
            if (o==null) {
                data.add(null);
            } else {
                boolean isExtending = false;
                if (o.getClass().getSimpleName().equals("List")) {
                    List l = (List) o;
                    if (l.length()>1) {
                        if (l.getType(0)==0) {
                            String s = (String) l.get(0);
                            if (s.equals(extendCheck)) {
                                isExtending = true;
                                for (int i=1; i<l.length(); i++) {
                                    append(l.get(i));
                                }
                            }
                        }
                    }
                }
                if (!isExtending) {
                    append(o);
                }
            }
        }
    }
    //==================================================================================================================
    // List Operations
    public int length() {
        return data.size();
    }

    public void append(Object o) {
        if (o==null) {
            data.add(null);
        } else {
            if (o.getClass().getSimpleName().equals("List")) {
                data.add(new Var(new List(Perform.extend((List) o))));
            } else {
                data.add(new Var(o));
            }
        }
    }

    public Tuple getValuesAt(int ...indexes) {
        List L = new List();
        for (int i: indexes) {
            if (i<data.size()) {
                L.append(data.get(i));
            }
        }
        return new Tuple(Perform.extend(L));
    }

    public Object get(int ...i) {

        if (i.length==1 && i[0]<data.size()) {
            return data.get(i[0]).get();
        }

        List values = null;
        Tuple fixValues = null;
        int firstIndex = i[0];
        if (firstIndex<data.size() && data.get(firstIndex).type().equals("List")) {
            values = (List) data.get(firstIndex).get();
        }
        if (firstIndex<data.size() && data.get(firstIndex).type().equals("Tuple")) {
            fixValues = (Tuple) data.get(firstIndex).get();
        }
        for (int j=1; j<i.length;j++) {
            int index = i[j];
            if (values!=null) {
                if (index>=values.length()) {
                    return null;
                }
                if (values.get(index).getClass().getSimpleName().equals("List")) {
                    values = (List) values.get(index);
                    fixValues = null;
                } else if (values.get(index).getClass().getSimpleName().equals("Tuple")) {
                    fixValues = (Tuple) values.get(index);
                    values = null;
                } else {
                    return values.get(index);
                }
            }
            if (fixValues!=null) {
                if (index>=fixValues.length()) {
                    return null;
                }
                if (fixValues.get(index).getClass().getSimpleName().equals("List")) {
                    values = (List) fixValues.get(index);
                    fixValues = null;
                } else if (fixValues.get(index).getClass().getSimpleName().equals("Tuple")) {
                    fixValues = (Tuple) fixValues.get(index);
                    values = null;
                } else {
                    return fixValues.get(index);
                }
            }
        }

        return null;
    }

    public int getType(int i) {
        if (i<data.size()) {
            return data.get(i).getType();
        }
        return -1;
    }

    public ArrayList<Var> getList() {
        return data;
    }

    public void pop() {
        if (data.size()>0) {
            data.remove(data.size()-1);
        }
    }

    public void print(){
        System.out.print("[");
        for (int i=0; i<data.size(); i++){
            if (data.get(i).get().getClass().getSimpleName().equals("List")){
                List l = (List) data.get(i).get();
                l.print();
            }
            else if (data.get(i).getType()==0){
                System.out.print(" \""+data.get(i).get()+"\"");
            }
            else{
                System.out.print(" "+data.get(i).get());
            }
            if (i!=data.size()-1){
                System.out.print(",");
            }
        }
        System.out.print(" ]");
    }

    public Boolean isPrimitives() {
        for (Var v: data) {
            if (!v.isPrimitive()) {
                return false;
            }
        }
        return true;
    }

    public Boolean isNumbers() {
        for (Var v: data) {
            if (!v.isNumbers()) {
                return false;
            }
        }
        return true;
    }

    public Boolean isText() {
        for (Var v: data) {
            if (!v.isText()) {
                return false;
            }
        }
        return true;
    }

    public Boolean contains(Object obj){
        int result = indexOf(obj);
        return result != -1;
    }

    public int indexOf(Object obj) {
        for (int i=0; i<data.size(); i++) {
            if (data.get(i)!=null && new Var(obj).isPrimitive()) {
                if (obj.equals(data.get(i))) {return i;}
            }
        }
        return -1;
    }

    public void shift() {
        if (data.size()>0) {
            data.remove(0);
        }
    }

    public void unshift(Object ...objs) {
        for (int j=objs.length-1;j>=0; j--) {
            if (objs[j].getClass().getSimpleName().equals("List")) {
                data.add(0 ,new Var(new List(Perform.extend((List) objs[j]))));
            } else {
                data.add(0, new Var(objs[j]));
            }
        }
    }

    public List concat(List list) {
        return new List(Perform.extend(this), Perform.extend(list));
    }

    public void set(int i, Object o) {
        if (i<data.size()) {
            if (i<0) {
                i = data.size() - 1 + i;
            }
            if (i<data.size()) {
                if (o.getClass().getSimpleName().equals("List")) {
                    data.add(new Var(new List(Perform.extend((List) o))));
                } else {
                    data.add(new Var(o));
                }
            }
        }
    }

    public void remove(int i) {
        if (i<data.size()) {
            if (i<0) {
                i = data.size() - 1 + i;
            }
            if (i<data.size()) {
                data.remove(i);
            }
        }
    }

    public List slice(int i) {
        List list = new List();
        if (i>=data.size() || i<(-data.size())) {
            return null;
        }
        if (i>=0) {
            for (int j = i + 1; j < data.size(); j++) {
                list.append(data.get(j).get());
            }
        } else {
            for (int j = data.size() - 1 + i; j >= 0; j--) {
                list.append(data.get(j).get());
            }
        }
        return list;
    }

    public List slice(int i, int j) {
        List list = new List();
        if (i >= data.size() || i < (-data.size())) {
            return null;
        }
        if (i>=0 && j>=0) {
            for (int x = i + 1; x <= j; x++) {
                list.append(data.get(x).get());
            }
        }
        if (i>=0 && j<0) {
            return null;
        }
        if (i<0 && j>=0) {
            i = data.size() + i;
            for (int x = j; x<=i; x++) {
                list.append(data.get(x).get());
            }
        }
        if (j<0 && i<j) {
            i = data.size() + i;
            j = data.size() + j;
            for (int x = j; x<=i; x++) {
                list.append(data.get(x).get());
            }
        }
        return list;
    }

    public void reverse() {
        ArrayList<Var> tempData = new ArrayList<>();
        for (int j=data.size()-1; j>=0; j--) {
            tempData.add(data.get(j));
        }
        data = new ArrayList<>(tempData);
    }
    //==================================================================================================================

}
