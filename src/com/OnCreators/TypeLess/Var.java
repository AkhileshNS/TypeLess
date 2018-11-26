package com.OnCreators.TypeLess;

public class Var {

    //==================================================================================================================
    // internal class variables
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
    6  - Custom class
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
    public Var() {}
    public Var (Object value) {
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

    //==================================================================================================================
    // setters
    public void set(Object value) {
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
    // Convertors
    public String toString() {
        int Type = type;
        try {
            switch (type) {
                case 1:
                    value = String.valueOf((int) value);
                    break;
                case 2:
                    value = String.valueOf((char) value);
                    break;
                case 3:
                    value = String.valueOf((float) value);
                    break;
                case 4:
                    value = String.valueOf((double) value);
                    break;
                case 5: {
                    if ((Boolean) value) {
                        value = "true";
                    } else {
                        value = "false";
                    }
                    break;
                }
            }
            type = 0;
        } catch (Exception e) {
            type = Type;
            System.out.println(e.toString());
        }
        return "";
    }

    public void toInt() {
        int Type = type;
        try {
            switch (type) {
                case 0:
                    value = Integer.parseInt((String) value);
                    break;
                case 2:
                    value = Integer.parseInt(String.valueOf((char) value));
                    break;
                case 3:
                    value = (int) (float) value;
                    break;
                case 4:
                    value = (int) (double) value;
                    break;
                case 5: {
                    if ((Boolean) value) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    break;
                }
            }
            type = 1;
        } catch (Exception e){
            type = Type;
            System.out.println(e.toString());
        }
    }

    public void toFloat() {
        int Type = type;
        try {
            switch (type) {
                case 0:
                    value = Float.parseFloat((String) value);
                    break;
                case 1:
                    value = (float) (int) value;
                    break;
                case 2:
                    value = Float.parseFloat(String.valueOf((char) value));
                    break;
                case 4:
                    value = (float) (double) value;
                    break;
                case 5: {
                    if ((Boolean) value) {
                        value = 1.0f;
                    } else {
                        value = 0f;
                    }
                    break;
                }
            }
            type = 3;
        } catch (Exception e) {
            type = Type;
            System.out.println(e.toString());
        }
    }

    public void toDouble() {
        int Type = type;
        try {
            switch (type) {
                case 0:
                    value = Double.parseDouble((String) value);
                    break;
                case 1:
                    value = (double) (int) value;
                    break;
                case 2:
                    value = Double.parseDouble(String.valueOf((char) value));
                    break;
                case 3:
                    value = (double) (float) value;
                    break;
                case 5: {
                    if ((Boolean) value) {
                        value = 1.0;
                    } else {
                        value = 0.0;
                    }
                    break;
                }
            }
            type = 4;
        } catch (Exception e) {
            type = Type;
            System.out.println(e.toString());
        }
    }

    public void toChar() {
        int Type = type;
        try {
            switch (type) {
                case 0:
                    value = ((String) value).charAt(0);
                    break;
                case 1:
                    value = String.valueOf((int) value).charAt(0);
                    break;
                case 3:
                    value = String.valueOf((float) value).charAt(0);
                    break;
                case 4:
                    value = String.valueOf((double) value).charAt(0);
                    break;
                case 5: {
                    if ((Boolean) value) {
                        value = 't';
                    } else {
                        value = 'f';
                    }
                    break;
                }
            }
            type = 2;
        } catch (Exception e) {
            type = Type;
            System.out.println(e.toString());
        }
    }

    public void toBoolean() {
        int Type = type;
        try {
            switch (type) {
                case 0: {
                    value = value.equals("true");
                    break;
                }
                case 1: {
                    value = (((int) value) != 0);
                    break;
                }
                case 3: {
                    value = (((float) value) != 0);
                    break;
                }
                case 4: {
                    value = (((double) value) != 0);
                    break;
                }
                case 2: {
                    value = (((char) value) != 'f');
                    break;
                }
            }
            type = 5;
        } catch (Exception e) {
            type = Type;
            System.out.println(e.toString());
        }
    }

    public void convertTo(String check) {
        if (type!=-1) {
            try {
                switch (check) {
                    case "s": { String s = toString(); break; }
                    case "i": { toInt(); break; }
                    case "f": { toFloat(); break; }
                    case "d": { toDouble(); break; }
                    case "c": { toChar(); break; }
                    case "b": { toBoolean(); break; }
                    default: System.out.println(check + " is not valid. \ns - String\ni - int/Integer\nc - char/character\nf - float\nd - double\nb - Boolean"); break;
                }
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        } else {System.out.println("The variable has not been set to any value");}
    }
    //==================================================================================================================

}