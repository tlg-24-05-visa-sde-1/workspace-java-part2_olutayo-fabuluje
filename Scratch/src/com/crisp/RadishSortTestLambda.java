package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RadishSortTestLambda {

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
        // TODO: use a lambda this time
        radishes.sort( (r1, r2) -> r1.getColor().compareTo(r2.getColor()) );
        dump(radishes);

        System.out.println("sort by guysOnTop via RadishGuysOnTopComparator");
        radishes.sort( (r1, r2) -> Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop()) );
        dump(radishes);

        System.out.println("sort by color via anonymous Comparator class");
        radishes.sort( (r1, r2) -> r1.getColor().compareTo(r2.getColor()) );
        dump(radishes);

        System.out.println("sort by tailLength via anonymous class");
        radishes.sort( (r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()) );
        dump(radishes);

    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);   // toString() automatically called
        }
        System.out.println();
    }
}