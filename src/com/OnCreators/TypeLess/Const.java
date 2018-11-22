package com.OnCreators.TypeLess;

public class Const {

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
    6  - Not Defined
    7  - Tuple
    */

    // Utility Functions
    protected String getTypeString(int t) {
        switch (t) {
            case 4: return "Double";
            case 1: return "Integer";
            case 2: return "Character";
            case 3: return "Float";
            case 7: return "Tuple";
            case 5: return "Boolean";
            case 8: return Perform.getObjectType(value);
            case 0: return "String";
            case -1: return "Unset";
        }
        return "String";
    }

    // Constructors
    public Const() {}
    public Const (Object value) {
        if (Perform.getObjectClass(value)=="List" || Perform.getObjectClass(value)=="Var"){
            System.out.println("Mutable data type in Const not allowed!");
            return;
        }
        switch (Perform.getObjectClass(value)){
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
            case "Float" : {
                this.value = value;
                type = 3;
                break;
            }
            case "Character" : {
                this.value = value;
                type = 2;
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
                this.value = value;
                type = 8;
            }
        }
    }

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
