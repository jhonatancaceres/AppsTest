package co.grability.test.core;

import java.util.ArrayList;

public interface JsonMapper<T,TT> {
    
    T map(TT element);
    ArrayList<T> mapAll(TT[] elements);
}
