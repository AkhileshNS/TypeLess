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

        List obj2 = new List(1,"abc",5.5,true);
        obj2.print();
        System.out.println();

        List obj3 = new List(2,"xyz",6.5,false,3);
        obj3.print();
        System.out.println();

        System.out.println(obj3.contains("xyz"));
        System.out.println(obj3.contains("abc"));
        System.out.println(obj3.contains(6.5));
        System.out.println(obj3.contains(5.5));
        System.out.println(obj3.contains(false));
        System.out.println(obj3.contains(true));



//        List obj4 = new List();
//        obj4.append(obj2);
//        obj4.append(obj3);
//        obj4.print();
//        System.out.println();


//        Tuple t = new Tuple(1,1.1f,1.2,'a',"abc",true);
//        t.print();
//
//        System.out.println("\n"+Perform.getObjectType(obj4));
//        System.out.println(Perform.getObjectType(obj4.data[0]));
//        System.out.println(Perform.getObjectType(obj4.data[0].data[0]));


//        System.out.println(obj3.contains("abc"));
    }
}
