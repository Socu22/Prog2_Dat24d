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
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(isPrime(x)){
                intList.add(x);
            }

        }
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // If divisible by any number other than 1 and itself
            }
        }
        return true; // If not divisible, it's a prime number
    }
}
