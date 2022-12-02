import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.xml.crypto.Data;
import javax.xml.validation.Validator;

public class ElfCalories {
    public static void main(String[] args) throws IOException {
      test2(args);

    }

    public static void test1()  throws IOException {
        String calories = new String(Files.readAllBytes(Paths.get("calories.txt")));

        // Look from the start
        int initPos = 0;
        int endPos = 0;
        int maxCalories=0;
        int currentCalories=0;

        while ((endPos = calories.indexOf("\n", initPos)) >= 0) {
            String calorie = calories.substring(initPos, endPos);
            initPos = endPos + 1;
            if(calorie.isEmpty()) {
                if(maxCalories < currentCalories) 
                    maxCalories = currentCalories;

                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(calorie);
            }

            //System.out.println(calorie);
        }

        System.out.println(maxCalories);
    }

    public static void test2(String[] args) throws IOException {


        SortedSet<Integer> set=new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s2 - s1;
            }
        });

        String calories = new String(Files.readAllBytes(Paths.get("calories.txt")));

        // Look from the start
        int initPos = 0;
        int endPos = 0;
        int maxCalories=0;
        int currentCalories=0;

        while ((endPos = calories.indexOf("\n", initPos)) >= 0) {
            String calorie = calories.substring(initPos, endPos);
            initPos = endPos + 1;
            if(calorie.isEmpty()) {
                if(maxCalories < currentCalories) 
                    maxCalories = currentCalories;

                    set.add(currentCalories);
                currentCalories = 0;
            } else {
                currentCalories += Integer.parseInt(calorie);
            }

            //System.out.println(calorie);
        }
       
       int total = set.stream().limit(3).mapToInt(Integer::intValue).sum();

       System.out.println(total);
    }
}