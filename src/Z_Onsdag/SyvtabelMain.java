package Z_Onsdag;

import java.util.Scanner;

public class SyvtabelMain extends Thread {


    static boolean r = true;
    public static void main(String[] args) {

        SyvtabelMain t = new SyvtabelMain();
        t.start();


        Scanner sc = new Scanner(System.in);

        while (r) {
            String string = sc.nextLine();
            if(string != null){
                r = false;

            }
        }




    }

    @Override
    public void run() {
        int tal =0;
        while (r) {
            tal += 7;
            System.out.println(tal);

            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
