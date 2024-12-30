package RefreshKnowledge;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class User {
    String name;
    int credit;
    String title;
    int id;
    String id2;
    static int userCounter;
    static Scanner sc = new Scanner(System.in);

    public enum Title {
        Poor, Middle, Rich, CountryRich, WorldRich
    }

    User(String name, int credit) {
        userCounter++;
        this.id = userCounter;
        this.name = name;
        this.credit = credit;
        titleHandler();
        complexIdHandler();
    }
    public int get_credit() {
        return credit;
    }
    public void set_Title(Title creditTitle) {
        this.title = creditTitle.name();
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void titleHandler() {
        if (get_credit() <= 50) {
            set_Title(User.Title.Poor);
        } else if (get_credit() > 50 && get_credit() <= 500) {
            set_Title(User.Title.Middle);
        } else if (get_credit() > 500 && get_credit() <= 5000) {
            set_Title(User.Title.Rich);
        } else if (get_credit() > 5000 && get_credit() <= 50000) {
            set_Title(User.Title.CountryRich);
        } else if (get_credit() > 50000 && get_credit() <= 500000) {
            set_Title(User.Title.WorldRich);
        }


    }
    boolean validUser(){
        return id2.matches("^[a-z]{4}\\d{4}$");

    }
    void createUserID(){
        String[] nameSplit = this.name.split(" ");

        String firstName= nameSplit[0].toLowerCase();
        String lastName= nameSplit[1].toLowerCase();

        String firstFour=firstName.substring(0,2)+lastName.substring(0,2);

        Random random = new Random();
        int digets=100+random.nextInt(9000);

        this.id2=firstFour+digets;



    }
    private void complexIdHandler(){
        createUserID();
        System.out.println(validUser());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", credit=" + credit +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", id2='" + id2 + '\'' +
                '}';
    }
}

