package com.entertainment.client;

import com.entertainment.Television;
import java.util.HashSet;
import java.util.Set;

public class TelevisionClient {

    public static void main(String[] args) {

        // examine == and the equals() method
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println(tvA.hashCode()); // hashcode is 54
        System.out.println(tvB.hashCode()); // hashcode is 54

        System.out.println("tvA == tvB: " + (tvA == tvB));   // you'll see true or false
        System.out.println(("tvA.equals(tvB): " + tvA.equals(tvB))); // true now

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        System.out.println("The size of the set is: " + tvs.size());   // should be 1
    }
}
