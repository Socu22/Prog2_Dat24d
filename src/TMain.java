public class TMain extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        TMain thread = new TMain();
        thread.start();
        System.out.println(amount);
        amount++;
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("hovse");
        }
        System.out.println(amount);

    }

    public void run() {
        amount++;
    }
}