package RefreshKnowledge;
import java.io.Serializable;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.*;

class User  implements Comparable<User>, Serializable {
    private String name;
    private int credit;
    private String title;
    private int id;
    private String id2_NP;
    private static int userCounter;
    private String password;
    private LocalDateTime reqDateTime;



    public enum Title {
        Poor, Middle, Rich, CountryRich, WorldRich
    }

    User(String name, int credit) {
        userCounter++;
        this.id = userCounter;
        this.name = name;
        this.credit = credit;
        this.password="";
        this.reqDateTime= LocalDateTime.now();
        titleHandler();
        createUserID();
    }

    public User(String name, int credit,String password) {
        this.name = name;
        this.credit = credit;
        this.password = password;
        titleHandler();
        createUserID();
    }

    public int get_credit() {
        return credit;
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

    public void setPassword(String password) {
        this.password = password;
    }
    /*
    public void setPassword(String password) {
    this.password = BCrypt.hashpw(password, BCrypt.gensalt());
}

public boolean checkPassword(String password) {
    return BCrypt.checkpw(password, this.password);
}
     */

    public void set_Title(Title creditTitle) {
        this.title = creditTitle.name();
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
    //for a name phone thing
    boolean validUser(){
        return id2_NP.matches("^[a-z]{4}\\d{4}$");
        //    return username != null && !username.isEmpty() && email != null && !email.isEmpty();
    }
    boolean isWorldRich(){
        return "WorldRich".equals(this.title);
    }
    void createUserID(){
        String[] nameSplit = this.name.split(" ");

        String firstName= nameSplit[0].toLowerCase();
        String lastName= nameSplit[1].toLowerCase();

        String firstFour=firstName.substring(0,2)+lastName.substring(0,2);

        Random random = new Random();
        int digets=100+random.nextInt(9000);

        setId2_NP(firstFour+digets);



    }


    public void setId2_NP(String id2_NP) {
        this.id2_NP = id2_NP;
    }



    @Override
    public int compareTo(User o) {
        return Integer.compare(this.id, o.id);
        //return this.name.compareTo(o.name);
    }
    //something with overwriting equals and hasCode
    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return name.equals(user.name); // or email, depending on your requirements
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // or email, depending on your equality logic
    }
     */

    @Override
    public String toString() {
        return "User{" +
                "reqDateTime=" + reqDateTime +
                ", id2_NP='" + id2_NP + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", name='" + name + '\'' +
                '}';
    }
}

