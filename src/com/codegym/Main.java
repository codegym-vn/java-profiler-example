package com.codegym;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static final int BOUNDARY = 100000;

    public static void main(String[] args) {

        List<Integer> aList = (new Main()).getData();

        long duration = useFor(aList);
        System.out.println("For: " + duration + " milliseconds");

        duration = explicitIterator(aList);
        System.out.println("Iterator: " + duration + " milliseconds");

        duration = useForEach(aList);
        System.out.println("ForEach: " + duration + " milliseconds");
    }

    public List<Integer> getData() {
        List<Integer> aList = new LinkedList<>();
        for (int i = 0; i < BOUNDARY; i++) {
            aList.add(i);
        }
        return aList;
    }

    static long useFor(List<Integer> aList) {
        long startTimestamp = new Date().getTime();
        for (int i = 0; i < aList.size(); i++) {
            aList.get(i);//Just access the element
        }
        long endTimestamp = new Date().getTime();
        return (endTimestamp - startTimestamp);
    }

    static long useForEach(List<Integer> aList) {
        long startTimestamp = new Date().getTime();
        for (Integer i : aList) {
            //Just access the element
        }
        long endTimestamp = new Date().getTime();
        return (endTimestamp - startTimestamp);
    }

    static long explicitIterator(List<Integer> aList) {
        long startTimestamp = new Date().getTime();
        for (Iterator<Integer> it = aList.iterator(); it.hasNext();) {
            it.next();//Just access the element
        }
        long endTimestamp = new Date().getTime();
        return (endTimestamp - startTimestamp);
    }
}
