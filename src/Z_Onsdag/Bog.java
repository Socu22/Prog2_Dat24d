package Z_Onsdag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bog {
    int ISBNN_No;
    String title;
    int ReleaseYear;

    public Bog(int ISBNN_No, String title, int releaseYear) {
        this.ISBNN_No = ISBNN_No;
        this.title = title;
        ReleaseYear = releaseYear;
    }

    public int getISBNN_No() {
        return ISBNN_No;
    }

    public void setISBNN_No(int ISBNN_No) {
        this.ISBNN_No = ISBNN_No;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Z_Onsdag.Bog{" +
                "ISBNN_No=" + ISBNN_No +
                ", title='" + title + '\'' +
                ", ReleaseYear=" + ReleaseYear +
                '}';
    }
}
class Library{
    static List<Bog> bogList = new ArrayList<>(Arrays.asList(new Bog(223311,"Solider",2024),new Bog(223311,"Solider2",2025)));

    static boolean Same_ISBNN_No(Bog bog){
        for(Bog bog_ : bogList ){
            if (bog_.ISBNN_No==bog.ISBNN_No){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Same_ISBNN_No(new Bog(223311,"soldier3",2026)));
    }
}
