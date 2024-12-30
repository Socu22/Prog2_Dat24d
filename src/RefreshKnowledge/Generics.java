package RefreshKnowledge;

import java.io.Serializable;
import java.util.List;

public class Generics {
    public static void main(String[] args) {

        Printer p = new Printer("hey,", 2.33f);
        p.print();
        shout("There are this many apples :",22);


    }

    private static <T,G> void shout(T thingToShout, G otherThingToShout){
    System.out.println(thingToShout);
    System.out.println(otherThingToShout);

}

}





class Printer<T,G extends Serializable>{

    T thingToPrint;
   G otherThingToPrint;

    Printer(T thingToPrint,G otherThingToPrint ){
        this.thingToPrint=thingToPrint;
        this.otherThingToPrint=otherThingToPrint;

    }
    public void print(){
        System.out.println(thingToPrint);
        System.out.println(otherThingToPrint);
    }

}
 