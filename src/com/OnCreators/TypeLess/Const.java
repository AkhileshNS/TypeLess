package com.OnCreators.TypeLess;

public class Const {

    //==================================================================================================================
    // internal class Variables
    protected Object value;
    protected int type = -1;
    /*
    -1 - Not Used
    0  - String
    1  - Integer
    2  - Character
    3  - Float
    4  - Double
    5  - Boolean
    6  - List
    7  - Not Defined
    8  - Custom class
    */

    //==================================================================================================================
    // Utility Functions
    protected String getTypeString(int t) {
        switch (t) {
            case -1: return "Unset";
            case 0: return "String";
            case 1: return "Integer";
            case 2: return "Character";
            case 3: return "Float";
            case 4: return "Double";
            case 5: return "Boolean";
            case 6: return value.getClass().getSimpleName();
        }
        return "String";
    }

    public Boolean isPrimitive() {
        if (type==0 || type==1 || type==2 || type==3 || type==4 || type==5) {
            return true;
        }
        return false;
    }

    public Boolean isNumbers() {
        if (type==1 || type==3 || type==4) {
            return true;
        }
        return false;
    }

    public Boolean isText() {
        if (type==0 || type==2) {
            return true;
        }
        return false;
    }

    //==================================================================================================================
    // Constructors
    public Const() {}
    public Const(Var v) {
        this.value = v.get();
        this.type = v.getType();
    }
    public Const(Const c) {
        this.value = c.get();
        this.type = c.getType();
    }
    public Const (Object value) {
        switch (value.getClass().getSimpleName()){
            case "String" : {
                this.value = value;
                type = 0;
                break;
            }
            case "Integer" : {
                this.value = value;
                type = 1;
                break;
            }
            case "Character" : {
                this.value = value;
                type = 2;
                break;
            }
            case "Float" : {
                this.value = value;
                type = 3;
                break;
            }
            case "Double" : {
                this.value = value;
                type = 4;
                break;
            }
            case "Boolean" : {
                this.value = value;
                type = 5;
                break;
            }
            default: {
                if (!value.getClass().getSimpleName().equals("Var") && !value.getClass().getSimpleName().equals("Const")) {
                    this.value = value;
                    type = 6;
                } else {
                    if (value.getClass().getSimpleName().equals("Var")) {
                        Var v = (Var) value;
                        this.value = v.get();
                        type = v.getType();
                    } else {
                        Const c = (Const) value;
                        this.value = c.get();
                        type = c.getType();
                    }
                }
            }
        }
    }

    //==================================================================================================================
    // getters
    public int getType() {
        return type;
    }
    public String type() {
        return getTypeString(type);
    }
    public Object get() {
        return value;
    }
    public String getString() {
        if (type==0) {
            return (String) value;
        } else {
            System.out.print("TypeMismatchException: Contained datatype is  " + getTypeString(type));
            return Perform.STR;
        }
    }
    public int getInt() {
        if (type==1) {
            return (int) value;
        } else {
            System.out.print("TypeMismatchException: Contained datatype is  " + getTypeString(type));
            return Perform.INT;
        }
    }
    public char getChar() {
        if (type==2) {
            return (char) value;
        } else {
            System.out.print("TypeMismatchException: Contained datatype is  " + getTypeString(type));
            return Perform.CHR;
        }
    }
    public float getFloat() {
        if (type==3) {
            return (float) value;
        } else {
            System.out.print("TypeMismatchException: Contained datatype is  " + getTypeString(type));
            return Perform.FLT;
        }
    }
    public double getDouble() {
        if (type==4) {
            return (double) value;
        } else {
            System.out.print("TypeMismatchException: Contained datatype is  " + getTypeString(type));
            return Perform.DBL;
        }
    }
    public Boolean getBoolean() {
        if (type==5) {
            return (Boolean) value;
        } else {
            System.out.print("TypeMismatchException: Contained datatype is  " + getTypeString(type));
            return Perform.BLN;
        }
    }

}
