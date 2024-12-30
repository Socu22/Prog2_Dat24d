package RefreshKnowledge;

public class Interfaces {
    public static void main(String[] args) {
        Name n = new Name();
        n.display();
        n.print();
        n.stats();
    }
}

//this show InterfaceLogic in the case of overwrite methods from other interfaces
interface API {

    default void show(){
        System.out.println("API: Version 1.0");
    }
    void stats();
    interface one extends API {
        void display();

    }
    interface two extends API{
        void print();
    }

}
class Name implements API.one, API.two {
    @Override
    public void display() {
        System.out.println("Path");

    }

    @Override
    public void print() {
        System.out.println("22");

    }

    @Override
    public void stats() {
        System.out.println("Works");

    }


}