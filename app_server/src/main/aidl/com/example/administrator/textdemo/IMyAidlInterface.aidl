// IMyAidlInterface.aidl
package com.example.administrator.textdemo;

// Declare any non-default types here with import statements
import com.example.administrator.textdemo.People;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

     List<People> addPeople(in People peo);
}
