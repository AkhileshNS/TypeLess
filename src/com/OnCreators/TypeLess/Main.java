package com.OnCreators.TypeLess;

import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Var obj1 = new Var("Anirban");
        Perform.print(obj1);
        obj1.set(4);
        Perform.print(obj1);
        obj1.toBoolean();
        Perform.print(obj1);

        Var o1 = new Var(1.3);
        Var o2 = new Var(2);
        Var o3 = new Var(3);
        Var o4 = new Var(4);
        Var o5 = new Var(5);

        Var value = Perform.operate("$0 + ($1/$0 + ($2*$1 + $3))", o1, o2, o3, o4, o5);
        Perform.print(value);
    }
}
