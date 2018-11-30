package com.OnCreators.TypeLess;

public class Perform {

    //==================================================================================================================
    // Error Defaults
    public static final String STR = "";
    public static final int INT = -1;
    public static final float FLT = -1.0f;
    public static final double DBL = -1.0f;
    public static final char CHR = 'e';
    public static final Boolean BLN = false;

    //==================================================================================================================
    // Basic Print Function
    public static void print(Var v) {
        if (v!=null) {
            System.out.println(v.get());
        } else {
            System.out.println("The passed value is empty");
        }
    }

    //==================================================================================================================
    // Extend Feature
    public static List extend(List list) {
        final String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        List values = new List(extendCheck);
        for (int i=0; i<list.length(); i++) {
            values.append(list.get(i));
        }
        return values;
    }
    public static List extend(Tuple tuple) {
        final String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        List values = new List(extendCheck);
        for (int i=0; i<tuple.length(); i++) {
            values.append(tuple.get(i));
        }
        return values;
    }
    public static Dictionary extend(Dictionary d) {
        return extendValues(d);
    }
    public static List extendKeys(Dictionary d) {
        final String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        return new List(extendCheck, extend(d.getKeys()));
    }
    public static Dictionary extendValues(Dictionary d) {
        final String extendCheck = "893e926f-ad86-4e26-9862-634f75c35606";
        Dictionary dict = new Dictionary();
        dict.setKeys(d.getKeys().toObjectArray());
        dict.setValues(d.getValues().toObjectArray());
        dict.set(extendCheck, null);
        return dict;
    }

    //==================================================================================================================
    // Arithmetic Operations
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
            switch (v.getType()) {
                case 0:
                    if (check.equals("+")) {
                        value = obj + v.getString();
                    }
                    break;
                case 4:
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
                case 2:
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

    // Arithmetic Operation Functions
    public static Var add(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            if (!(new List(vars).isNumbers()) && !(new List(vars).isText())) {
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
                return new Var(value);
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
            if (!(new List(vars).isNumbers())) {
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
                return new Var(value);
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
            if (!(new List(vars).isNumbers())) {
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
                return new Var(value);
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
            if (!(new List(vars).isNumbers())) {
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
                return new Var(value);
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
        if (!(new List(vars).isNumbers())) {
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
    //==================================================================================================================
}
