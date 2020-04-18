package org.example;

import org.example.cache.CacheConfigManager;

public class CacheHandler {

    public void getStudentData(int i) {
        System.out.println("********** Call " + String.valueOf(i) + " Started **********");
        System.out.println("Call " + String.valueOf(i) + ": " + CacheConfigManager.getInstance().getStudentDataFromCache("S100"));
        System.out.println("Call " + String.valueOf(i) + ": " + CacheConfigManager.getInstance().getStudentDataFromCache("M101"));
        System.out.println("Call " + String.valueOf(i) + ": " + CacheConfigManager.getInstance().getStudentDataFromCache("P102"));
        System.out.println("********** Call " + String.valueOf(i) + " Ended **********");
    }

}
