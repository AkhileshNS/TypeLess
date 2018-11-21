package com.OnCreators.TypeLess;

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

    public int length() {
        return length;
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

}
