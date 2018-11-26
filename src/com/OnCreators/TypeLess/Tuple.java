package com.OnCreators.TypeLess;

public class Tuple {

    //==================================================================================================================
    // internal class Variables
    public Const[] data;
    private int length;
    private final String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";

    //==================================================================================================================
    // Constructors
    public Tuple(Var[] vars) {
        length = vars.length;
        data = new Const[length];
        for (int i = 0; i<vars.length; i++) {
            if (vars[i]==null) {
                data[i] = null;
            } else {
                data[i] = new Const(vars[i]);
            }
        }
    }

    public Tuple(Const[] consts) {
        length = consts.length;
        data = new Const[length];
        for (int i = 0; i<consts.length; i++) {
            if (consts[i]==null) {
                data[i] = null;
            } else {
                data[i] = new Const(consts[i]);
            }
        }
    }

    public Tuple(Object ...args) {
        length = args.length;
        data = new Const[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                data[i] = null;
            } else {
                data[i] = new Const(args[i]);
            }
        }
    }

    //==================================================================================================================
    // Tuple Operations
    public int length() {
        return length;
    }

    public void print(){
        System.out.print("(");
        for (int i=0; i<length; i++){
            if (data[i].type==7){
                Tuple objs = (Tuple) data[i].get();
                objs.print();
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
        System.out.print(" )");
    }

    public Boolean isPrimitives() {
        for (Const v: data) {
            if (!v.isPrimitive()) {
                return false;
            }
        }
        return true;
    }

    public Boolean isNumbers() {
        for (Const v: data) {
            if (!v.isNumbers()) {
                return false;
            }
        }
        return true;
    }

    public Boolean isText() {
        for (Const v: data) {
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