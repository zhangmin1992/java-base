package com.my.java.base.ServiceLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIClient {
    public static void main(String args[]) {
        ServiceLoader<MyInterface> spiLoader = ServiceLoader.load(MyInterface.class);
        Iterator<MyInterface> iaIterator = spiLoader.iterator();
        while (iaIterator.hasNext()) {
            iaIterator.next().getName();
        }
//        for (MyInterface myInterface : drivers) {
//            if(myInterface instanceof Woman) {
//                ((Woman) myInterface).getName();
//            }
//            if(myInterface instanceof Man) {
//                ((Man) myInterface).getName();
//            }
//        }
    }
}
