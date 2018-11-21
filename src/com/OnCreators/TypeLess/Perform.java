package com.OnCreators.TypeLess;

public class Perform {

    public static final String STR = "";
    public static final int INT = -1;
    public static final float FLT = -1.0f;
    public static final double DBL = -1.0f;
    public static final char CHR = 'e';
    public static final Boolean BLN = false;

    public static void print(Var v) {
        if (v!=null) {
            System.out.println(v.get());
        } else {
            System.out.println("The passed value is empty");
        }
    }

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
        Var v = null;
        if (obj.getClass() == String.class) {
            v = new Var((String) obj);
        }
        if (obj.getClass() == Float.class) {
            v = new Var((float) obj);
        }
        if (obj.getClass() == Integer.class) {
            v = new Var((int) obj);
        }
        if (obj.getClass() == Double.class) {
            v = new Var((double) obj);
        }
        return v;
    }

    public static Var add(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            if (!isOnlyNumbers(vars) && !isOnlyText(vars)) {
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "+");
            }
            if (value==null) {return null;}
            else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        return null;
    }

    public static Var subtract(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            int type = vars[0].getType();
            if (type==5) {
                return null;
            }
            if (!isOnlyNumbers(vars)) {
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "-");
            }
            if (value==null) {return null;}
            else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        return null;
    }

    public static Var multiply(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            int type = vars[0].getType();
            if (type==5) {
                return null;
            }
            if (!isOnlyNumbers(vars)) {
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "*");
            }
            if (value==null) {return null;}
            else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
        return null;
    }

    public static Var divide(Var ...vars) {
        if (vars.length==1) {
            return vars[0];
        }
        if (vars.length>1) {
            int type = vars[0].getType();
            if (type==5) {
                return null;
            }
            if (!isOnlyNumbers(vars)) {
                return null;
            }

            Object value = null;
            for (Var v: vars) {
                if (v.getType() == 1 || v.getType() == 3){
                    v.toDouble();
                }
                value = operateAndReturn(value, v, "/");
            }
            if (value==null) {return null;}
            else {
                if (value.getClass() == Double.class && (double) value == Math.round((double) value)) {
                    value = (int) (double) value;
                }
                return createVarFromObj(value);
            }
        }
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
            return null;
        }
        for (int i=0;i<vars.length;i++) {
            if (!Operation.contains("$" + String.valueOf(i))) {
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
