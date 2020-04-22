package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void printInfo(){
        System.out.println("printed from selfInterfaceMarkerImpl class");
    }
    public void printSecond(){
        System.out.println("second public method in class");
    }
}
