package RefreshKnowledge;

import java.util.Random;

public class Enums {
    public static void main(String[] args) {
        System.out.println(randomGrade());
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

}
