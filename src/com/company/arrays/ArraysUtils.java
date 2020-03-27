package com.company.arrays;

import java.util.*;

public class ArraysUtils {
    public void luckySort(ArrayList<String> strings, Comparator<String> comp){
        while (!check(strings,comp)){
            Collections.shuffle(strings);
        }
    }

    //increase check
    private boolean check(ArrayList<String> strings, Comparator<String> comp){
        String str = strings.get(0);

        for(int i = 1; i < strings.size(); i++){
            if(comp.compare(str,strings.get(i)) > 0){
                return false;
            }
            str = strings.get(i);
        }
        return true;
    }
}
