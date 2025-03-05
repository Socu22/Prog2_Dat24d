package Z_Onsdag;

import RefreshKnowledge.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primtal extends Thread {
    static boolean r = true;
    static List<Integer> intList= new ArrayList<>();
    public static void main(String[] args) {
        Primtal m = new Primtal();
        m.start();
        Scanner sc = new Scanner(System.in);
        while (r){
            String string = sc.nextLine();
            if(string != null){
                r = false;
                System.out.println(intList);

            }
        }


    }

    @Override
    public void run() {
        int x=0;

        while (r){
            x++;

            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(InputHandler.isPrime(x)){
                intList.add(x);
            }

        }
    }

}
