package Z_Onsdag;

public class heofligeSamtale {
    public static void main(String[] args) {
        int x_Sleep = 10;
        int y_Say = 5;

        Thread Tysk = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < y_Say; i++) {
                    try {
                        sleep(x_Sleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Ich komme aus Deutschland. Ich spreche Deutsch! ");

                }
            }
        };
        Thread Dansk = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < y_Say; i++) {
                    try {
                        sleep(x_Sleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Jeg er fra Danmark. Jeg taler Dansk!");

                }
               ;
            }
        };
        Thread Engelsk = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < y_Say; i++) {
                    try {
                        sleep(x_Sleep);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("I am from England. I speak English! ");

                }

            }
        };
        Tysk.start();
        Dansk.start();
        Engelsk.start();



    }
}

