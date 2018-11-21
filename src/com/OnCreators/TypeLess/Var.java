package com.OnCreators.TypeLess;

public class Var {

    private Object value;
    private int type = -1;
    /*
    -1 - Not Used
    0  - String
    1  - Integer
    2  - Character
    3  - Float
    4  - Double
    5  - Boolean
    */

    // Utility Functions
    private String getTypeString(int t) {
        switch (t) {
            case 4: return "double";
            case 1: return "int";
            case 2: return "char";
            case 3: return "float";
            case -1: return "Unset";
        }
        return "String";
    }

    // Constructors
    public Var() {}
    public Var(String value) {
        this.value = value;
        type = 0;
    }
    public Var(int value) {
        this.value = value;
        type = 1;
    }
    public Var(char value) {
        this.value = value;
        type = 2;
    }
    public Var(float value) {
        this.value = value;
        type = 3;
    }
    public Var(double value) {
        this.value = value;
        type = 4;
    }
    public Var(Boolean value) {
        this.value = value;
        type = 5;
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

    // setters
    public void set(String value) {
        this.value = value;
        type = 0;
    }
    public void set(int value) {
        this.value = value;
        type = 1;
    }
    public void set(char value) {
        this.value = value;
        type = 2;
    }
    public void set(float value) {
        this.value = value;
        type = 3;
    }
    public void set(double value) {
        this.value = value;
        type = 4;
    }
    public void set(Boolean value) {
        this.value = value;
        type = 5;
    }

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

}
