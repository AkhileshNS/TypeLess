package com.OnCreators.TypeLess;

import java.util.Objects;

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

    public Boolean contains(Object obj){//should i kick you out rn?
        //No let me see all your hidden secrets in the laptop first
        //
        String argType = Perform.getObjectClass(obj);
        if (argType == "List" || argType == "Tuple"){

        }
        else{
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
        }
        return false;
    }

}