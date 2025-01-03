package RefreshKnowledge;

import java.util.List;

public class ClassesAndParameterUsage {

    public static void withoutLambda(){
        //this overwrites every method in the Runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Works1");
            }
        };
        runnable.run();
    }
    public static void withLambda(){
        //this is a Anonymous method for calling interfaces with one abstract method and nothing else
        Runnable runnable = ()->{
            System.out.println("Works2");
        };
        runnable.run();
    }
    public static void sendAtributeWithLambda(){
        //this is a Anonymous method for calling interfaces with one abstract method and nothing else
        InterfaceTester test = (x)->{
            System.out.println("test: "+x);
        };
        test.sendString("test for aids");

    }


    public static void main(String[] args) {
     withoutLambda();
        withLambda();
        sendAtributeWithLambda();


    }
}
//1 without labda
//2 with labda
//3 with the other thing

interface InterfaceTester{

    void sendString(String string);
}
