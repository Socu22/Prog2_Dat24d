package Z_Onsdag;

import RefreshKnowledge.InputHandler;

public class Grass {
    static final double DAILY_GROWTH= 0.8;
    static double cutGrass(double currentGrowth, double howHighBeforeCut ){
        double dage =0;
        while (currentGrowth<howHighBeforeCut){
            currentGrowth+=DAILY_GROWTH;
            dage++;

        }


    return dage;
    }

    public static void main(String[] args) {
        double currentG = InputHandler.userInputDouble("CurrentG= ");
        double howhigh = InputHandler.userInputDouble("howhigh= ");
        System.out.println(cutGrass(currentG,howhigh));
    }
}
