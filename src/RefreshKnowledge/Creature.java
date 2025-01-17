package RefreshKnowledge;

import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

public class Creature {
    private String name; // Name of creature
    private CreatureClass creatureClass;
    private String race; //Describes creature
    private double damage; // hit points
    private RandomGenerator critChance;
    private double hp; // Health points
    private double mp; // Mana Points

    enum CreatureClass{
        Minion(1.15), SubLeader(1.30), Leader(1.60), Veteran(2.20), Hero(3.40), King(5.80), God(10.60);
        private final double value;

        CreatureClass(double v) {
            this.value=v;
        }

        public double getValue() {
            return value;
        }
    }

    public Creature(String name, String race, CreatureClass creatureClass ,double hp, double mp) {
        this.name = name;
        this.race = race;
        this.creatureClass= creatureClass;
        this.damage=((hp*mp)/10)*creatureClass.getValue();
        this.critChance = new SplittableRandom();
        this.hp = hp;
        this.mp = mp;
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

    public double getDamage() {
       int critChanceValue= critChance.nextInt(11);
        if (critChanceValue==10){
            return damage*2;
        }
        return damage;
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
    public void hasDoneSomething(String type,double value,String prompt){
        String printValue =String.format("%s-%s(%s) has %s with %f %s !!",name,race,String.valueOf(creatureClass),type,value,prompt);
        System.out.println(printValue);
    }

    public double attack(){
        return getDamage();
    }

    @Override
    public String toString() {
        return "RefreshKnowledge.Creature{" +
                "\n\tname='" + name + '\'' +
                ", \n\tcreatureClass=" + creatureClass +
                ", \n\trace='" + race + '\'' +
                ", \n\tdamage=" + damage +
                ", \n\thp=" + hp +
                ", \n\tmp=" + mp +
                '}';
    }
}
class Goblin extends Creature {
    public Goblin(String name, String race, CreatureClass creatureClass, double hp, double mp) {
        super(name, race, creatureClass, hp, mp);
    }


    public static void main(String[] args) {
        Goblin goblin = new Goblin("Jenkins","RefreshKnowledge.Goblin",CreatureClass.God, 25.56,3);
        System.out.println(goblin);
        double health = 100;
        int times = 0;
        for (int i = 0; i <100; i++) {
            double damageDone = goblin.getDamage();
            goblin.hasDoneSomething("Attacked",damageDone, "damage");
            health-=damageDone;
            times++;
            if(health<0){
                System.out.println("done in "+times+" times, Hp is at "+health+" Health");
                break;
            }

        }

    }



}
