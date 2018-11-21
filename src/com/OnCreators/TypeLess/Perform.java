package com.OnCreators.TypeLess;

public class Perform {

    // Error Defaults
    public static final String STR = "";
    public static final int INT = -1;
    public static final float FLT = -1.0f;
    public static final double DBL = -1.0f;
    public static final char CHR = 'e';
    public static final Boolean BLN = false;

    // Basic Print Function
    public static void print(Var v) {
        if (v!=null) {
            System.out.println(v.get());
        } else {
            System.out.println("The passed value is empty");
        }
    }

    public static String getObjectClass(Object obj){
        Class cls = obj.getClass();
        String longName = cls.getName();
        String result = "";
        int start = 0;
        for (int i = 0; i<longName.length(); i++){
            if (longName.charAt(i) == '.'){
                start = i;
            }
        }
        for (int i = start+1; i<longName.length(); i++){
            result = result + longName.charAt(i);
        }
        return result;
    }

    public static String getObjectType(Object obj){
        String result = getObjectClass(obj);
        switch (result){
            case "List" : {List temp = (List) obj;
                           return temp.type();
            }
            case "Tuple" : {Tuple temp = (Tuple) obj;
                            return temp.type();
                           }
            case "Var" : {Var temp = (Var) obj;
                          return temp.type();
                         }
            default : return result;
        }
    }

    // Var conversion ,operation and check functions
    private static double getDoubleFromVar(Var v) {
        if (v.getType()==1) {
            return (double) v.getInt();
        }
        if (v.getType()==3) {
            return (double) v.getFloat();
        }
        return v.getDouble();
    }

    private static Object operateAndReturn(Object obj, Var v, String check) {
        Object value = null;
        if (obj!=null) {
            switch (v.type()) {
                case "String":
                    if (check.equals("+")) {
                        value = obj + v.getString();
                    }
                    break;
                case "double":
                    switch (check) {
                        case "+":
                            value = (double) obj + v.getDouble();
                            break;
                        case "-":
                            value = (double) obj - v.getDouble();
                            break;
                        case "*":
                            value = (double) obj * v.getDouble();
                            break;
                        case "/":
                            value = (double) obj / v.getDouble();
                            break;
                    }
                    break;
                case "char":
                    if (check.equals("+")) {
                        value = obj + String.valueOf(v.getChar());
                    }
                    break;
            }
        } else {
            value = v.get();
        }
        return value;
    }

    private static Boolean isOnlyNumbers(Var[] vars) {
        for (Var v: vars) {
            if (v.getType()==0 || v.getType()==2 || v.getType()==5) {
                return false;
            }
        }
        return true;
    }

    private static Boolean isOnlyText(Var[] vars) {
        for (Var v: vars) {
            if (v.getType()==1 || v.getType()==3 || v.getType()==4 || v.getType()==5) {
                return false;
            }
        }
        return true;
    }

    public static Var createVarFromObj(Object obj) {
        if (obj.getClass() == String.class) {
            return new Var((String) obj);
        }
        if (obj.getClass() == Float.class) {
            return new Var((float) obj);
        }
        if (obj.getClass() == Integer.class) {
            return new Var((int) obj);
        }
        if (obj.getClass() == Double.class) {
            return new Var((double) obj);
        }
        if (obj.getClass() == Boolean.class) {
            return new Var((Boolean) obj);
        }
        if (obj.getClass() == Character.class) {
            return new Var((Character) obj);
        }
        System.out.println("Object passed is must be one of types : int, float, String, character, Boolean, Double");
        return null;
    }

    public static void append(List list, Var v) {
        if (list==null) {list=new List();}
        switch (v.getType()) {
            case 0: list.append(v.getString()); break;
            case 1: list.append(v.getInt()); break;
            case 2: list.append(v.getChar()); break;
            case 3: list.append(v.getFloat()); break;
            case 4: list.append(v.getDouble()); break;
            case 5: list.append(v.getBoolean()); break;
        }
    }

    // Arithmetic Operation Functions
    public static Var add(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            if (!isOnlyNumbers(vars) && !isOnlyText(vars)) {
                System.out.println("All the passed vars must contain only numbers (int,float or double) or only text (String or char).");
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "+");
            }
            if (value==null) {
                System.out.println("Error while performing operation");
                return null;
            }
            else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        System.out.println("Insufficient number of vars passed as arguments");
        return null;
    }

    public static Var subtract(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            if (!isOnlyNumbers(vars)) {
                System.out.println("All the passed vars must contain only numbers (int, float or double)");
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "-");
            }
            if (value==null) {
                System.out.println("Error while performing operation");
                return null;
            } else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        System.out.println("Insufficient number of vars passed as arguments");
        return null;
    }

    public static Var multiply(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            if (!isOnlyNumbers(vars)) {
                System.out.println("All the passed vars must contain only numbers (int, float or double)");
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "*");
            }
            if (value==null) {
                System.out.println("Error while performing operation");
                return null;
            } else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        System.out.println("Insufficient number of vars passed as arguments");
        return null;
    }

    public static Var divide(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            if (!isOnlyNumbers(vars)) {
                System.out.println("All the passed vars must contain only numbers (int, float or double)");
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "/");
            }
            if (value==null) {
                System.out.println("Error while performing operation");
                return null;
            } else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        System.out.println("Insufficient number of vars passed as arguments");
        return null;
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

    public static Var operate(String operation, Var ...vars) {
        String Operation = operation;
        if (!isOnlyNumbers(vars)) {
            System.out.println("All the passed vars must contain only numbers (int, float or double)");
            return null;
        }
        for (int i=0;i<vars.length;i++) {
            if (!Operation.contains("$" + String.valueOf(i))) {
                System.out.println("Variables in operation must be equal to the number of variables passed and their indexes must also exist in respect to the variables passed");
                return null;
            }
            double d = getDoubleFromVar(vars[i]);
            Operation = Operation.replace("$" + String.valueOf(i), String.valueOf(d));
        }
        double d = eval(Operation);
        if (d == Math.round(d)) {
            return new Var((int) d);
        }
        return new Var(d);
    }
}
