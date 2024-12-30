package RefreshKnowledge;

import java.lang.ref.Cleaner;
import java.util.EnumMap;

public class JavaDesignPatterns {
    public static void main(String[] args) {
        System.out.println("This is how Singleton Patterns are made/used: ".toUpperCase()); //when you only want one instance of class
        System.out.println("Early Instance:  "+SingletonPattern.getInstance().logic());//Early Instantitaion
        System.out.println("Instance defined when usefull"+SingletonPattern.getInstance2().logic2()); // lazy instation
        System.out.println("Same as above but threadsafe"+SingletonPattern.getInstance2Revised().logic2()); // lazy instation (but threadsafe, Kind of like a door that makes sure only one thread comes inside with the synkronised blok)
        System.out.println("Strategy Pattern".toUpperCase());

    }
}

class SingletonPattern{//Spring FrameWork //without scope in it, it is consideret a Singleton, reversely its a bean in framework if it is defined in a configuation class suing @bean(backbone of your application and that are managed by the Spring IoC container), or anotating(metadata that provides data about program ) your class with component
    int number;
    public static void main(String[] args) {

    }
    //Early instantiation: we create the instance at load time
    private static final SingletonPattern instance =new SingletonPattern();  //This makes a global instance in Compile time, not in runtime
    private SingletonPattern(){
        this.number=22;
    };

    public static SingletonPattern getInstance() {
        return instance;
    }


    public int logic() {
        int test = getInstance().number;
        return test;
    }
    //Lazy instantiation: we create the instance when required
    private static SingletonPattern instance2; //the reverse... but it is better to do in runtime if big project
    //private SingletonPattern(){}
    public static SingletonPattern getInstance2(){
        if(instance2==null){
            instance2=new SingletonPattern();
        }
        return instance2;
    }
    public int logic2() {
        int test = getInstance().number;
        return test;
    }
//Lazy instantiation For making a thread safe by making sure that only one thread at a time can make a new instance
    //Uses earlier methods except this one and instance

    private static volatile SingletonPattern instance2revised;

    public static SingletonPattern getInstance2Revised(){
        if(instance2revised==null){
            synchronized (SingletonPattern.class){
                if (instance2revised==null){
                    instance2revised= new SingletonPattern();
                }
            }
            instance2revised=new SingletonPattern();
        }
        return instance2revised;
    }

}
/*https://medium.com/@minadev/solving-everyday-problems-essential-java-design-patterns-you-need-to-know-01dba2939b45*/
// dosen't work Strategy Pattern: lacks Springwork implimented
class StrategyPattern{

    public static void main(String[] args) {
        //ApplicationContext springContext = new AnnotationConfigApplicationContext("com.mina.strategy");
        //LoginContext paymentContext = springContext.getBean(LoginContext.class);

        //loginContext.processPayment(LoginMethod.MAIl,"Test@gmail.com");
        //loginContext.processPayment(LoginMethod.TLF, "99999999");

    }
}
interface LoginStrategy{
    void login(String tlfOrMail);

}
//@Component;
class TLFLoginStrategy implements LoginStrategy{


    @Override
    public void login(String tlf) {
        System.out.printf("Login Type is tlf: %s ",tlf);

    }
}
class MAILLoginStrategy implements LoginStrategy{

    @Override
    public void login(String mail) {
        System.out.printf("Login Type is mail: %s",mail);

    }
}
enum LoginMethod{
    TLF("tlf"), MAIl("mail");
    private final String value;

    LoginMethod(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
//@Component
class LoginContext {
    private static final String BEAN_SUFFIX = "Strategy";

    //@autowired
    //private ApplicationContext context;
    private EnumMap<LoginMethod,LoginStrategy> strategies;

    public void processPayment(LoginMethod loginMethod, String loginString){
        LoginStrategy paymentStrategy = strategies.get(loginMethod);
        if(loginMethod==null){
            throw new IllegalArgumentException("No strategy found for LoginMethod: "+loginMethod);

        }
        paymentStrategy.login(loginString);
    }
    //@PostConstruct
    public void init(){
        this.strategies= new EnumMap<>(LoginMethod.class);
        // Arrays.stream(LoginMethod.values()).forEach(loginMethod -> strategies.put(loginMethod),(LoginStrategy) context.getBean(loginMethod.getValue()+BEAN_SUFFIX));

    }
}

//Factory Pattern
//------------------

class AbstractFactoryPattern{//https://medium.com/@minadev/solving-everyday-problems-essential-java-design-patterns-you-need-to-know-01dba2939b45#:~:text=Abstract%20Factory%20Pattern%3A

    public static void main(String[] args) {
        FactoryVilla fv = new FactoryVilla();
        Client fvClient = new Client(fv);
        Building fvReceiver= fvClient.getpBuilding();
        fvReceiver.print();

        FactoryTower ft = new FactoryTower();
        Client ftClient= new Client(ft);
        Building ftReceiver= ftClient.getpBuilding();
        ftReceiver.print();
    }
}
abstract class Building {
    int etager;
    String name;

    Building(String name, int etager){
        this.name=name;
        this.etager=etager;
    }
    public abstract void print();


}
class Building_vila extends Building {
    Building_vila(String name, int etager) {
        super(name, etager);
    }

    @Override
    public void print() {
        System.out.println("Villa:\n \tname:"+name+"\n\t"+"etager: "+etager);

    }

}
class Building_tower extends Building {
    Building_tower(String name, int etager) {
        super(name, etager);
    }

    @Override
    public void print() {
        System.out.println("Tower:\n \tname:"+name+"\n\t"+"etager: "+etager);

    }

}
interface Factory{
    Building createBuilding();
}
class FactoryVilla implements  Factory{
    @Override
    public Building createBuilding() {
        return new Building_vila("GayHouse",3);
    }
}
class FactoryTower implements  Factory{
    @Override
    public Building createBuilding() {
        return new Building_tower("GayTower",30);
    }
}
class Client{
    private Building pBuilding;
    Client(Factory factory){
        pBuilding=factory.createBuilding();
    }

    public Building getpBuilding() {
        return pBuilding;
    }
}


class BuilderPattern{
    public static void main(String[] args) {
        UserComplex user = new UserComplex.UserBuilder("45674","Jens","Habdi")
                .address("Glostrup")
                .phone("234355")
                .build();
        System.out.println(user);

    }

}

