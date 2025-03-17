import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Fisherman {
    static final int NUM_OARS = 5;
    static final int FISH_LIMIT = 5;
    static Oar[] oars = new Oar[NUM_OARS];

    public static void main(String[] args) {
        System.out.println("Start Main");
        for (int i = 0; i < NUM_OARS; i++) {
            oars[i] = new Oar(i);
        }

        FishermanThread[] fishermen = new FishermanThread[5];
        for (int i = 0; i < 5; i++) {
            fishermen[i] = new FishermanThread("Fisherman " + (i + 1));
            fishermen[i].start();
        }

        for (FishermanThread fisherman : fishermen) {
            try {
                fisherman.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Fisherman did not wait on each other");
            }
        }

        System.out.println("All fishermen have finished their tasks.");
        System.out.println("End Main");
    }
}

class FishermanThread extends Thread {
    String name;
    int fishCaught;
    Random random = new Random();

    public FishermanThread(String name) {
        this.name = name;
        this.fishCaught = 0;
    }

    @Override
    public void run() {
        System.out.println("Start " + name);

        while (fishCaught < Fisherman.FISH_LIMIT) {
            int oar1, oar2;

            // Attempt to acquire two distinct oars
            while (true) {
                oar1 = random.nextInt(Fisherman.NUM_OARS);
                oar2 = random.nextInt(Fisherman.NUM_OARS);

                if (oar1 != oar2) {
                    // Ensure oar1 < oar2 to prevent deadlock
                    if (oar1 > oar2) {
                        int temp = oar1;
                        oar1 = oar2;
                        oar2 = temp;
                    }

                    if (Fisherman.oars[oar1].tryLock()) { //continue if you got an oat
                        try {
                            if (Fisherman.oars[oar2].tryLock()) { //continue if you got an oat
                                try {
                                    System.out.println(name + " has oars " + oar1 + " and " + oar2); // confirmed and locked to oats
                                    goFishing(); // simulate the time taking to row to a lake and go back and then eat the fish.
                                    break;
                                } finally {
                                    Fisherman.oars[oar2].unlock(); // then we unlock nr 2 oat
                                }
                            }
                        } finally {
                            Fisherman.oars[oar1].unlock(); // then we unlock nr 1 oat
                            // then another fisherman can get an oat that they are lacking
                        }
                    }
                }

                // if you did not get two oats the fisherman will Sleep briefly before retrying
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        System.out.println("End " + name);
    }

    private void goFishing() {
        try {
            Thread.sleep(random.nextInt(2000) + 1000); // Simulate fishing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        fishCaught++;
        System.out.println(name + " caught a fish! Total: " + fishCaught);

        // Simulate eating the fish and taking a break
        try {
            Thread.sleep(random.nextInt(2000) + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Oar extends ReentrantLock {
    int id;

    public Oar(int id) {
        this.id = id;
    }
}
