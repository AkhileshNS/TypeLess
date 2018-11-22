package com.OnCreators.TypeLess;

import java.lang.*;

public class Main {
    public static void main(String[] args) {
//        Var obj1 = new Var("Anirban");
//        Perform.print(obj1);
//        obj1.set(4);
//        Perform.print(obj1);
//        obj1.toBoolean();
//        Perform.print(obj1);
//
//        Var o1 = new Var(1.3);
//        Var o2 = new Var(2);
//        Var o3 = new Var(3);
//        Var o4 = new Var(4);
//        Var o5 = new Var(5);
//
//        Var value = Perform.operate("$0 + ($1/$0 + ($2*$1 + $3) + $4)", o1, o2, o3, o4, o5);
//        Perform.print(value);
//
//        Dictionary d1 = new Dictionary("name", "age", "percentile", "usn");
//        d1.setValues("Akhilesh", 20, 84.8, "1BM16IS009");
//        d1.set("LOR", false);
//        d1.getValues().print();
//        System.out.println(d1.get("LOR"));
//
//        Var obj = new Var("xyz");
//        List obj2 = new List(1,2.3,"xyz",true);
//        System.out.println(obj2.contains(obj.get()));

        List obj1 = new List(1,1.1,"abc",true);
        Const obj2 = new Const(obj1);
        List obj3 = (List) obj2.get();
        obj3.print();

    }
}
