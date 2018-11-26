package com.OnCreators.TypeLess;

public class List {

    //==================================================================================================================
    // internal class Variables
    public Var[] data;
    private int size;
    private int length;

    //==================================================================================================================
    // Constructors
    public List(){
        size = 5;
        length = 0;
        data = new Var[5];
    }

    public List(Var[] vars) {
        length = vars.length;
        data = new Var[length];
        for (int i = 0; i<vars.length; i++) {
            if (vars[i]==null) {
                data[i] = null;
            } else {
                data[i] = new Var(vars[i].get());
            }
        }
    }

    public List(Const[] consts) {
        length = consts.length;
        data = new Var[length];
        for (int i = 0; i<consts.length; i++) {
            if (consts[i]==null) {
                data[i] = null;
            } else {
                data[i] = new Var(consts[i].get());
            }
        }
    }

    public List(Object ... args){
        length = args.length;
        data = new Var[length];
        for(int i = 0; i<args.length; i++){
            if (args[i] == null) {
                data[i] = null;
            } else {
                data[i] = new Var(args[i]);
            }
        }
    }
    //==================================================================================================================
    // List Operations
    public int length() {
        return length;
    }

    public void append(Object i) {

        if (length == size) {
            Var[] temp = new Var[size * 2];
            size = size * 2;
            if (length >= 0) System.arraycopy(data, 0, temp, 0, length);
            data = temp;
        }

        data[length] = new Var(i);
        length++;
    }

    public void print(){
        System.out.print("[");
        for (int i=0; i<length; i++){
            if (data[i].get().getClass().getSimpleName().equals("List")){
                List l = (List) data[i].get();
                l.print();
            }
            else if (data[i].type==0){
                System.out.print(" \""+data[i].get()+"\"");
            }
            else{
                System.out.print(" "+data[i].get());
            }
            if (i!=length-1){
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
        for (int i=0; i<length; i++) {
            if (data[i]!=null && new Var(obj).isPrimitive()) {
                if (obj.equals(data[i].get())) {return i;}
            }
        }
        return -1;
    }
    //==================================================================================================================

}
