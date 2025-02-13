package MyProjects;

import RefreshKnowledge.Creature;

public class Player extends Creature{

    public Player(String name, String race,int level, CreatureClass creatureClass, double hp, double mp) {
        super(name, race, level, creatureClass, hp, mp);

    }



    public String toString() {
        return super.toString().replaceFirst("Creature","("+getRace()+")");
    }
}
