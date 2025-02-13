package Z_Onsdag;

import java.util.ArrayList;
import java.util.List;

public class Car {
    int speed;
    String  currentGear;


    enum Gear{
        Back(-1), Fri(0), One(1), Two(2), Three(3), Four(4);
        private final int  value;
        Gear(int value){
            this.value=value;
        }

        public int getValue() {
            return value;
        }
    }


    public void increaseGear(String lovligGear){
        Gear[] gears = Gear.values();
        for (int i = 0; i <6 ; i++) {
            if(lovligGear.equals(String.valueOf(gears[i]))){
                this.currentGear= String.valueOf(gears[i+1]);


            }

        }

    }

    @Override
    public String toString() {
        return "Z_Onsdag.Car{" +
                "speed=" + speed +
                ", currentGear='" + currentGear + '\'' +
                '}';
    }
}
class Garage{
   static Car[] carArray= {new Car(), new Car(), new Car(), new Car(), new Car(), new Car()};

   List<Car> returAlleNeutral(){
       Car.Gear[] gears = Car.Gear.values();
       String gearN = String.valueOf(gears[1]);

       List<Car> carList = new ArrayList<>();
       for (int i = 0; i < 6 ; i++) {
           if(carArray[i].currentGear.equals(gearN)){
               carList.add(carArray[i]);
           }



       }
       return carList;
   }

    public static void main(String[] args) {
        Garage garage = new Garage();
        for (Car car : Garage.carArray){
            car.currentGear= String.valueOf(Car.Gear.Fri);
        }
        Garage.carArray[2].currentGear = String.valueOf(Car.Gear.Back);
        garage.returAlleNeutral().forEach(x->x.increaseGear("Fri"));}


}
