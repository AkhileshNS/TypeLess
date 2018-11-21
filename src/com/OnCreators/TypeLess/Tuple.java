package com.OnCreators.TypeLess;

public class Tuple extends Const{
    public Tuple[] data;
    private int length;
    public Tuple(Object ... args){
        length = args.length;
        data = new Tuple[args.length];
        type = 7;
        for(int i = 0; i<args.length; i++){
            if (args[i] == null) {
                data[i] = null;
            }
            else {
                switch (Perform.getObjectClass(args[i])){
                    case "String" : {String str = (String) args[i];
                                     data[i] = new Tuple(str);
                                     break;
                                    }
                    case "Integer" : {int x = (int) args[i];
                                      data[i] = new Tuple(x);
                                      break;
                                     }
                    case "Character" : {char c = (char) args[i];
                                        data[i] = new Tuple(c);
                                        break;
                                       }
                    case "Float" : {float f = (float) args[i];
                                    data[i] = new Tuple(f);
                                    break;
                                   }
                    case "Double" : {double d = (double) args[i];
                                     data[i] = new Tuple(d);
                                     break;
                                    }
                    case "Boolean" : {boolean b = (boolean) args[i];
                                      data[i] = new Tuple(b);
                                      break;
                                     }
                    }
                }
            }

        }

    public int length() {
        return length;
    }

    protected Tuple(char i){
        super(i);
    }

    protected Tuple(float i){
        super(i);
    }

    protected Tuple(int i){
        super(i);
    }

    protected Tuple(double i){
        super(i);
    }

    protected Tuple(boolean i){
        super(i);
    }

    protected Tuple(String i){
        super(i);
    }


    public void print(){
        System.out.print("(");
        for (int i=0; i<length; i++){
            if (data[i].type==7){
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
        System.out.print(" )");
    }

}