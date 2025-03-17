import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LTC_Main {
    static Resource[] res = new Resource[2];

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started");
        res[0] = new Resource("Candle");
        res[1] = new Resource("Lighter");
        Student s1 = new Student("Johanne");
        Student s2 = new Student("John");
        s1.start();
        s2.start();
        s1.join();
        s2.join();

        
        System.out.println("Main ended");
    }
}
class Student extends Thread {
    static Random gen = new Random();
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" started");
        try {
            boolean keepGoing = true;
            while (keepGoing){
                int resNo= gen.nextInt(2);
                Thread.sleep(gen.nextInt(10000));
                LTC_Main.res[resNo].lock();
                System.out.println("\t"+name+" got the "+ LTC_Main.res[resNo]);

                resNo= (resNo+1)%2;
                Thread.sleep(gen.nextInt(10000));
                if(LTC_Main.res[resNo].tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("\t"+name+"got the "+ LTC_Main.res[resNo]);
                    System.out.println("Lights Candle!");
                    keepGoing=false;
                }
                if(LTC_Main.res[0].isHeldByCurrentThread()) LTC_Main.res[0].unlock(); System.out.println("\t"+name+" has given up Candle");
                if(LTC_Main.res[1].isHeldByCurrentThread()) LTC_Main.res[1].unlock(); System.out.println("\t"+name+" has given up Lighter");





            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+" ended");


    }
}
class Resource extends ReentrantLock{
    String name;
    Resource(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}