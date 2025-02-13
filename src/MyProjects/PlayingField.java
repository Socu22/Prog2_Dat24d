package MyProjects;

import RefreshKnowledge.Creature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PlayingField {
    static boolean isRunning = true;
    static Player currentPlayer = new Player("John","Elf", 7,Creature.CreatureClass.Minion,10,50);
    static Enemy currentOpponentEnemy = null;
    static List<Enemy> ENEMY_LIST = Arrays.asList( new Enemy("Jenkins","Goblin",7, Creature.CreatureClass.King, 25.56,3),
            new Enemy("Bins","Goblin",7, Creature.CreatureClass.Leader, 40,3),
            new Enemy("kins","Goblin",7, Creature.CreatureClass.SubLeader, 25.56,3),
            new Enemy("insteps","Goblin",7, Creature.CreatureClass.Veteran, 25.56,3),
            new Enemy("Links","Goblin",7, Creature.CreatureClass.SubLeader, 25.56,3),
            new Enemy("Owns","Goblin",7, Creature.CreatureClass.Minion, 25.56,3),
            new Enemy("Koi","Goblin",7, Creature.CreatureClass.God, 10,50));
    static int inputInt;
    static String inputString = "";
    public static void main(String[] args) {
       // Collections.shuffle(ENEMY_LIST);
        runSimulation();





    }
    static void runSimulation() {
        System.out.println(currentPlayer);;
        while (isRunning){
            System.out.println();
            switchStart();



        }



    }

    static void switchStart(){
        inputInt = RefreshKnowledge.InputHandler.userInputInt("Choose Action (1 chooseEnemy,2. Attack,3. quit): ");

        switch (inputInt){
            case 1:
                chooseEnemy();
                break;
            case 2:
                //attackModifiable();
                attackEachOtherUntilOneIsDead();
                break;
            case 3:
                isRunning = false;
                break;



        }

    }
    static void chooseEnemy(){
        // will del dead Enemies from list "ENEMY_LIST"
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < ENEMY_LIST.size(); i++) {
            if (ENEMY_LIST.get(i).getIsAlive()) {
                enemies.add(ENEMY_LIST.get(i));
            }
        }
        ENEMY_LIST=enemies; // sets the sorted to the used list


        //Shows EnemiesALive
        ENEMY_LIST.forEach(enemy ->
                System.out.println("\t" + ENEMY_LIST.indexOf(enemy) + " " + enemy));
        int inputEnemy = RefreshKnowledge.InputHandler.userInputInt("Choose Enemy: "); // Chooses Enemy
        currentOpponentEnemy=ENEMY_LIST.get(inputEnemy); //Takes the Enemy into static COEnemy
    }
    static void attackEnemy(){
        //attacks once if enemy Chosen is still alive
        if(currentOpponentEnemy.getIsAlive()){
            currentOpponentEnemy.attackedBy(currentPlayer);
            if (currentOpponentEnemy.getIsAlive()){
                currentPlayer.hasDoneSomething("Attacked", currentPlayer.getTempDamage(),"damage","\n"+currentOpponentEnemy.getName()+"("+currentOpponentEnemy.getRace()+")"+"lvl: "+currentOpponentEnemy.getLevel()+"\nhp left: "+currentOpponentEnemy.getHp());
            }
        }
    }
    static void attackPlayer(){
        //attacks once if enemy Chosen is still alive
        if(currentPlayer.getIsAlive()){
            currentPlayer.attackedBy(currentOpponentEnemy);
            if (currentPlayer.getIsAlive()){
                currentOpponentEnemy.hasDoneSomething("Attacked", currentOpponentEnemy.getTempDamage(),"damage","\n"+currentPlayer.getName()+"("+currentPlayer.getRace()+")"+"lvl: "+currentPlayer.getLevel()+"\nhp left: "+currentPlayer.getHp());
            }
        }
    }
    static void attackEachOtherUntilOneIsDead(){ // it goes into a unlimited loop somehow. fix it. :->
        if (currentOpponentEnemy != null && currentPlayer!=null) {
            double hpPlayer = currentOpponentEnemy.getHp();
            double hpEnemy = currentOpponentEnemy.getHp();

            while (currentPlayer.getIsAlive()){
                if (!currentOpponentEnemy.getIsAlive()) break;
                attackEnemy();
                attackPlayer();
                System.out.println("-------------------------- ");
                System.out.println("Player hp: " + hpPlayer + "/" + currentPlayer.getHp());
                System.out.println("Enemy hp: " + hpEnemy + "/" + currentOpponentEnemy.getHp());
            }


        }
    }
    static void attackModifiable(){
        if (currentOpponentEnemy != null) {
            inputInt = RefreshKnowledge.InputHandler.userInputInt("how many times: "); // attacks how many times ?
            double hp = currentOpponentEnemy.getHp();
            System.out.println("Enemy Hp: " + hp); //Enemy start hp

            for (int i = 0; i < inputInt; i++) {
                attackEnemy();
                if (!currentOpponentEnemy.getIsAlive()) break;
            }
            System.out.println("Enemy hp: " + hp + "/" + currentOpponentEnemy.getHp()); // makes a Comparison of current hp and (hp-attack)
        }
    }


    }




