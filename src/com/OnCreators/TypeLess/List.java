package com.OnCreators.TypeLess;

import java.util.Objects;

public class List extends Var {

    public List[] data;
    private int size;
    private int length;
    public List(){
        size = 5;
        length = 0;
        data = new List[5];
        type = 6;
    }

    public List(Object ... args){
        length = args.length;
        data = new List[args.length];
        length = args.length;
        type = 6;
        for(int i = 0; i<args.length; i++){
            if (args[i] == null) {
                data[i] = null;
            }
            else {
                switch (Perform.getObjectClass(args[i])){
                    case "String" : {String str = (String) args[i];
                        data[i] = new List(str);
                        break;
                    }
                    case "Integer" : {int x = (int) args[i];
                        data[i] = new List(x);
                        break;
                    }
                    case "Character" : {char c = (char) args[i];
                        data[i] = new List(c);
                        break;
                    }
                    case "Float" : {float f = (float) args[i];
                        data[i] = new List(f);
                        break;
                    }
                    case "Double" : {double d = (double) args[i];
                        data[i] = new List(d);
                        break;
                    }
                    case "Boolean" : {boolean b = (boolean) args[i];
                        data[i] = new List(b);
                        break;
                    }
                }
            }
        }

    }

    public int length() {
        return length;
    }

    protected List(char i){
        super(i);
    }

    protected List(float i){
        super(i);
    }

    protected List(int i){
        super(i);
    }

    protected List(double i){
        super(i);
    }

    protected List(boolean i){
        super(i);
    }

    protected List(String i){
        super(i);
    }

    public void append(int i){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }
        data[length] = new List(i);
        length++;
    }

    public void append(char i){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }
        data[length] = new List(i);
        length++;
    }

    public void append(float i){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }
        data[length] = new List(i);
        length++;
    }

    public void append(double i){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }
        data[length] = new List(i);
        length++;
    }

    public void append(String i){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }
        data[length] = new List(i);
        length++;
    }

    public void append(Boolean i){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }
        data[length] = new List(i);
        length++;
    }

    public void append(List obj){
        if (length == size){
            List temp[] = new List[size*2];
            size = size*2;
            for (int j = 0; j<size; j++) {
                temp[j] = data[j];
            }
            data = temp;
        }

        data[length] = new List();

        for (int i = 0; i<obj.length();i++){
            if (obj.data[i].type==6){
                data[length].append(obj.data[i]);
            }
            else{
                switch(obj.data[i].type){
                    case 0 : {String str = (String) obj.data[i].get();
                        data[length].append(str);
                        break;
                    }
                    case 1 : {int x = (int) obj.data[i].get();
                        data[length].append(x);
                        break;
                    }
                    case 2 : {char c = (char) obj.data[i].get();
                        data[length].append(c);
                        break;
                    }
                    case 3 : {float f = (float) obj.data[i].get();
                        data[length].append(f);
                        break;
                    }
                    case 4 : {double d = (double) obj.data[i].get();
                        data[length].append(d);
                        break;
                    }
                    case 5 : {boolean b = (boolean) obj.data[i].get();
                        data[length].append(b);
                        break;
                    }

                }
            }
        }


        length++;
    }

    public void print(){
        System.out.print("[");
        for (int i=0; i<length; i++){
            if (data[i].type==6){
                data[i].print();
            }
            else if (data[i].type==0){
                System.out.print(" \""+data[i].get()+"\"");
            }
            else{
                System.out.print(" "+data[i].get());
            }
            if (i!=length-1){
                System.out.print(",");
            }
        }
        System.out.print(" ]");
    }

    public Boolean contains(Object obj){
        String argType = Perform.getObjectClass(obj);
//        if (argType == "List" || argType == "Tuple"){
//
//        }
//        else{
            for (int i = 0; i<length; i++){
                if (data[i].type()!="List"){
                    if(Objects.equals(data[i].type(), argType)){
                        switch (argType){
                            case "Double" : {return (double) data[i].value == (double) obj;}
                            case "Integer" : {return (int) data[i].value == (int) obj;}
                            case "String" : {return (String) data[i].value == (String) obj;}
                            case "Boolean" : {return (boolean) data[i].value == (boolean) obj;}
                            case "Float" : {return (float) data[i].value == (float) obj;}
                            case "Character" : {return (char) data[i].value == (char) obj;}
                            default : return false;
                        }
                    }
                }
            }
//        }
        return false;
    }

}
