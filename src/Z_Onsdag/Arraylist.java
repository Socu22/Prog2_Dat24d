package Z_Onsdag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arraylist {

    static List<String> stringList = new ArrayList<>(Arrays.asList("Bo","Jens", "Peter"));
    static boolean doesArraylistContainString(List<String> stringList, String string){
            if(!stringList.contains(string)){
                stringList.add(string);
                return false;

            }else {
                System.out.println("The String has been found!");
                return true;
        }

    }
    public static void main(String[] args) {
        System.out.println(doesArraylistContainString(stringList,"Bob"));
    }
}
