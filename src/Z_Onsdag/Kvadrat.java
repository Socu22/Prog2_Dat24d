package Z_Onsdag;

public class Kvadrat {
    static void tegnKvadrtat(char c){
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                System.out.print(c+"  ");

            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        tegnKvadrtat('*');
    }
}
