package Z_Onsdag;

public class JaNej extends Thread {
    public static void main(String[] args) {
      JaNej j = new JaNej();
      j.start();

      while(true) {
          System.out.println("ja");
      }
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("nej");

        }
    }
}
