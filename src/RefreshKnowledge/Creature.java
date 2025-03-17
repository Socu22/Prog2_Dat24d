package RefreshKnowledge;



import MyProjects.Enemy;
import MyProjects.Player;

import java.util.Objects;
import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

public class Creature {

    private String name; // Name of creature
    private int level;
    private CreatureClass creatureClass;
    private String race; //Describes creature
    private double damage; // hit points
    private double tempDamage;
    private RandomGenerator critChance;
    private double hp; // Health points
    private double mp; // Mana Points
    private boolean isAlive;

    static CreatureClass[] classes = CreatureClass.values();
    static RandomGenerator randomGenerator = new SplittableRandom();



    public enum CreatureClass{
        Minion(1.15), SubLeader(1.30), Leader(1.60), Veteran(2.20), Hero(3.40), King(5.80), God(10.60);
        private final double multiplyValue;


        CreatureClass(double v) {
            this.multiplyValue =v;
        }

        public double getMultiplyValue() {
            return multiplyValue;
        }
    }

    public Creature(String name, String race,int level, CreatureClass creatureClass, double baseHp, double BaseMp) {
        this.name = name;
        this.race = race;
        this.creatureClass = creatureClass;
        this.critChance = new SplittableRandom();
        this.hp = baseHp;
        this.mp = BaseMp;
        this.isAlive=true;

        /*// Call setLevelLogic here to ensure it's applied to both Goblin and Mercenary
        setLevelLogicTesting();  // This method should always be invoked when a Creature is created
        */
        setLevelLogic(level);
    }
    public boolean getIsAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public CreatureClass getCreatureClass() {
        return creatureClass;
    }

    public void setCreatureClass(CreatureClass creatureClass) {
        this.creatureClass = creatureClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getDamage() {// nice way to say that there is 10% chance for a crit hit else normal damage.
       int critChanceValue= critChance.nextInt(11);
       tempDamage = damage;
        if (critChanceValue==10){
            tempDamage= damage*2;
            return damage*2;
        }
        return damage;
    }

    public double getTempDamage() {
        return tempDamage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }


    public double getHp() {
        return hp;
    }


    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public void hasDoneSomething(String type,double value,String prompt, String opponent){
        String printValue =String.format("%s-%s(%s) has %s with %f %s to %s",name,race,String.valueOf(creatureClass),type,value,prompt,opponent);
        System.out.println(printValue);
    }


    public double attack(){
        return getDamage();
    }
    public void attackedBy(Player player){
        this.hp-=Math.abs(player.attack());
        if(hp<0){
            this.isAlive=false;
        }

    }
    public void attackedBy(Enemy enemy){
        this.hp-=Math.abs(enemy.attack());
        if(hp<0){
            this.isAlive=false;
        }

    }
    private void updateValues(){
        setLevelLogicTesting();
    }
    public void increaseClass(){
        CreatureClass currentClass = creatureClass;
        for (int i = 0,classLength = classes.length; i < classLength; i++) {
            if (currentClass.multiplyValue == classes[i].multiplyValue){
                if (i == classLength-1){
                    break;
                }
                setCreatureClass(classes[i+1]);


            }

        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevelLogicTesting(){
        int x=1;
        for (CreatureClass creatureClass1 : classes){
            int lowest = x;
            int highest = x*20;
            x++;
            if (creatureClass1==this.creatureClass){
                //setLevel(randomGenerator.nextInt(lowest, highest)+1);
                setLevel(randomGenerator.nextInt(lowest, highest)+1);
                setHpMpLogic_andDamage(Math.max(level,1)); // send level gotten and then calc based on that the real hp and mp and damage logic
            }
        }


    }
    public void setLevelLogic(int level){
        int x=1;
        for (CreatureClass creatureClass1 : classes){
            x++;
            if (creatureClass1==this.creatureClass){

                setLevel(level);
                setHpMpLogic_andDamage(Math.max(this.level,1)); // send level gotten and then calc based on that the real hp and mp and damage logic
            }
        }


    }

    public void setHpMpLogic_andDamage(int level){
        double baseHp = this.hp;
        double baseMp = this.mp;
        setHp(((level*baseHp)/(baseHp/2)));
        setMp((level*baseMp)/(baseMp/2));
        this.damage = (((getHp() * getMp()) * creatureClass.getMultiplyValue()) / 20);
        this.damage = Math.max(this.damage, 1);  // Ensure that damage is never zero





    }



        @Override
    public String toString() {
        return "Creature{" +
                "\n\tname='" + name + '\'' +
                ", \n\tlevel='" + level + '\'' +
                ", \n\tcreatureClass=" + creatureClass +
                ", \n\trace='" + race + '\'' +
                ", \n\tdamage=" + damage +
                ", \n\thp=" + hp +
                ", \n\tmp=" + mp +
                '}';
    }
}

@VeryInportant
class Cat {
    @ImportantString
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("Munch");

    }
    @RunNow(times = 5)

    public void sayMeow(){
        System.out.println("Meow!");
    }
    private void sayAHiddenMeow(){
        System.out.println("Meow!(silently)");
    }
    public static void pus(){
        System.out.println("pus: Yikes");
    }
    private static void prs(){
        System.out.println("prs ouch");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat cat)) return false;
        return getAge() == cat.getAge() && Objects.equals(getName(), cat.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

