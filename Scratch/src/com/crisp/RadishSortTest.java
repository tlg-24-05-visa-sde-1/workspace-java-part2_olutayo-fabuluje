package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();


        // color, size, tailLength, guysOnTop
        radishes.add(new Radish("white", 1.5, 2.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 0));
        radishes.add(new Radish("red", 2.7, 5.5, 0));
        radishes.add(new Radish("pink", 0.9, 0.0, 6));

       // original list
        System.out.println("original list");
        dump(radishes);

        System.out.println("sort by natural order");
        radishes.sort(null);  // passing null means natural order
        dump(radishes);

        System.out.println("sort by color via RadishColorComparator");
        radishes.sort(new RadishColorComparator());
        dump(radishes);

        System.out.println("sort by guysOnTop via RadishGuysOnTopComparator");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);

        System.out.println("sort by color via anonymous Comparator class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop());
            }
        });
        dump(radishes);


        dump(radishes);

        System.out.println("sort by tailLength via anonymous class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish o1, Radish o2) {
                return Double.compare(o1.getTailLength(), o2.getTailLength());
            }
        });
        dump(radishes);

    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);   // toString() automatically called
        }
        System.out.println();
    }
}