package Z_Onsdag;

public class Search {
   static int searchMethod(String[] strings, String s){
        for (int i = 0; i <strings.length ; i++) {
            if (strings[i].equals(s)){
                return i;
            }
        }
        throw new RuntimeException(" cannot find string in array");


    }

    public static void main(String[] args) {
       String[] strings = {"JEFF", "BOB", "LL"};
        System.out.println(searchMethod(strings,"LL½xL"));
    }
}
