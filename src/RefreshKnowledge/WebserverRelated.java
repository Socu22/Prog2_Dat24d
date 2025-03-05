package RefreshKnowledge;
import java.net.*;
import java.io.*;
import java.util.*;
public class WebserverRelated {
}

class FlertraadetWebserver
{
    public static void main(String[] arg)
    {
        try {
            ServerSocket serversocket = new ServerSocket(8001);

            while (true)
            {
                Socket forbindelse = serversocket.accept();
                Anmodning a = new Anmodning(forbindelse);
                new Thread(a).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Anmodning implements Runnable
{
    private Socket forbindelse;

    Anmodning(Socket forbindelse)
    {
        this.forbindelse = forbindelse;
    }

    public void run()
    {
        try {
            PrintWriter ud = new PrintWriter(forbindelse.getOutputStream());
            BufferedReader ind = new BufferedReader(
                    new InputStreamReader(forbindelse.getInputStream()));

            String anmodning = ind.readLine();
            System.out.println("start "+new Date()+" "+anmodning);

            ud.println("HTTP/0.9 200 OK");
            ud.println();
            ud.println("<html><head><title>Svar</title></head>");
            ud.println("<body><h1>Svar</h1>");
            ud.println("Tænker over "+anmodning+"<br>");
            for (int i=0; i<100; i++)
            {
                ud.print(".<br>");
                ud.flush();
                Thread.sleep(100);
            }
            ud.println("Nu har jeg tænkt færdig!</body></html>");
            ud.flush();
            forbindelse.close();
            System.out.println("slut  "+new Date()+" "+anmodning);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}