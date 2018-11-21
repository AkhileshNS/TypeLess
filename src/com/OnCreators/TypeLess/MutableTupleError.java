package com.OnCreators.TypeLess;

public class MutableTupleError extends Exception{
    MutableTupleError(String type){
        super("Mutable datatype "+type+" can not be passed into immutable tuple");
    }
}
