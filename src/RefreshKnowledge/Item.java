package RefreshKnowledge;

import java.util.*;

public class Item {
    String name;
    int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Item item = (Item) object;
        return amount == item.amount && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        return String.format("Item: %s %d",name,amount);

    }
}
class Rock extends Item {
    String type;
    public Rock(String name, int amount, String type) {
        super(name, amount);
        this.type=type;
    }

    @Override
    public String toString() {
        return String.format("Rock: %s %d %s",name,amount,type);
    }
}
class FantasyWeapon extends Item {
    double damage;
    double pSec;
    double damagePSec;
    RARITY rarity;
    enum RARITY{
        COMMON(1), UNCOMMON(2), RARE(3), LEGENDARY(4);
        private final int value;

        RARITY(int value) {
            this.value=value;
        }

        public int getValue() {
            return value;
        }
    }
    public FantasyWeapon(String name,int amount,double damage, double pSec,RARITY rarity) {
        super(name,amount);
        this.damage = damage;
        this.pSec = pSec;
        this.damagePSec= damage/pSec;
        this.rarity=rarity;
    }


    public double getDamagePSec() {
        return damagePSec;
    }

    public int getRarityValue() {
        return rarity.value;
    }

    @Override
    public String toString() {
        return "FantasyWeapon{" +
                "damage=" + damage +
                ", pSec=" + pSec +
                ", damagePSec=" + damagePSec +
                ", rarity=" + rarity +
                '}';
    }


}
