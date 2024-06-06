package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient extends TreeSet<Television> {

    public static void main(String[] args) {

        // examine == and the equals() method
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        //System.out.println(tvA.hashCode()); // hashcode is 54
        //System.out.println(tvB.hashCode()); // hashcode is 54

        System.out.println("tvA == tvB: " + (tvA == tvB));   // you'll see true or false
        System.out.println(("tvA.equals(tvB): " + tvA.equals(tvB)));// true now

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the set is: " + tvs.size());   // should be 1
        System.out.println();
        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }
}
