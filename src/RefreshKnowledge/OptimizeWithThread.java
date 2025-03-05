package RefreshKnowledge;
import java.net.*;
import java.io.*;
import java.util.*;
public class OptimizeWithThread {
    static boolean r = true;
    public static void main(String[] args) { // main Thread
        /*ThreadExample t = new ThreadExample(); // new thread
        t.start(); //Thread started and run method runs.

        jaNejExample(); // the simple way to see how Threads work. It get send to the cpu in a buffer and then randomly writes something in no predictable order

        //for 9 tabel

        /*Thread NiTabel = new Thread(){
            @Override
            public void run() {
                int tal =0;
                while (r) {
                    tal += 9;
                    System.out.println(tal);

                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        NiTabel.start();*/
        //----
        List<Integer> intList = new ArrayList<>();
        //----
        /*

        Thread Primetal = new Thread(
        ) {
            @Override
            public void run() {
                int x = 0;

                while (r) {
                    x++;

                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (InputHandler.isPrime(x)) {
                        intList.add(x);
                    }
                }
            }
        };
        Primetal.start();

         */











        Scanner sc = new Scanner(System.in);
        int input= 2;
        switch (input){
            case 1:// for 9 tabel
                while (r) {
                    String string = sc.nextLine();
                    if(string != null){
                        r = false;

                    }
                }
                break;
            case 2:
                while (r){ // for primetal
                    String string = sc.nextLine();
                    if(string != null){
                        r = false;
                        System.out.println(intList);

                    }
                }
                break;
        }



    };

    static void jaNejExample(){
        while(true) {
            System.out.println("ja"); //This works because of a synchronized block that makes sure that the two printline from this and Threadexample does not collide and overwrite each other.
        }
    }


}
class test extends Thread {
    int integer;

    public test(int integer) {
        this.integer = integer;
    }
}
class ThreadExample extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("nej");

        }
    }
}

class ThreadExample2 extends Thread {
    public static void main(String[] args) {
        int x_Sleep = 10;
        int y_Say = 5;

        Thread Tysk = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < y_Say; i++) {
                    try {
                        sleep(x_Sleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Ich komme aus Deutschland. Ich spreche Deutsch! ");

                }
            }
        };
        Thread Dansk = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < y_Say; i++) {
                    try {
                        sleep(x_Sleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Jeg er fra Danmark. Jeg taler Dansk!");

                }
                ;
            }
        };
        Thread Engelsk = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < y_Say; i++) {
                    try {
                        sleep(x_Sleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("I am from England. I speak English! ");

                }

            }
        };
        Tysk.start();
        Dansk.start();
        Engelsk.start();



    }
}
