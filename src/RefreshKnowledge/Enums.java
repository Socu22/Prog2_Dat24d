package RefreshKnowledge;

import java.util.*;
import java.util.stream.Collectors;

public class Enums {

    public static void main(String[] args) {
        System.out.println(randomGrade());
        String test= String.valueOf(Enums.test.One);
        System.out.println(test);
        logic(1);

    }
    enum test{
        One,Two,Three
    }



    static String randomGrade(){
        int x = test.values().length;
        test[] grades = test.values();
        Random random = new Random();

        return String.valueOf(grades[random.nextInt(x)]);

    }
    static void logic(int y){
        int eSize = test.values().length;
        test[] testValues = test.values();
        List<String> testValuesAsList= new ArrayList<>();
        for (int i = 0; i <eSize ; i++) {
            testValuesAsList.add(String.valueOf(testValues[i]));

        }
        testValuesAsList.forEach(string -> {
            System.out.println(string.length()+". "+string);


        });


    }

}
