package MyProjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {


}
class Database{
    static Map<Member,List<Book>> database =new HashMap<Member,List<Book>>();
    static List<Book> books=new ArrayList<>();
}
class Book {
    String title;
    String author;
    String ISBN;
    boolean isAvailable;

    public Book(String title, String author, String ISBN, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %b", title, author, ISBN, isAvailable);
    }
}
class BookManagement {

    void addBook(Book book) {
        Database.books.add(book);

    }
    void updateBook(String booktitle) {
        Book bookToRemove = null;
        for (Book book : Database.books)
            if (book.title.equals(booktitle)) {
                bookToRemove = book;

            }
        if (bookToRemove != null) {
            Database.books.remove(bookToRemove);
            System.out.println("Book " + bookToRemove + " was added to the database");
        }
    }

    void deleteBook(Book book) {

    }
    void listBooks() {

    }

}
class Member{
    String name;
    int id;
    static int counter = 0;
    String email;
    int tlf;


    public Member(String name, String email, int tlf) {
        this.name = name;
        this.email = email;
        this.tlf = tlf;
        counter++;
        this.id = counter;
        //if() in case of duplicate id
    }
    void borrowBook(String bookTitle) {
        //send borrow date to BorrowRecord



    }
    void returnBook() {
        //send borrow date to BorrowRecord

    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d", name, email, tlf, id);
    }
}
class MemberManagement {
    public static void main(String[] args) {
        MemberManagement memberManagement = new MemberManagement();
        memberManagement.addMember(new Member("p","mail",0));
        memberManagement.addMember(new Member("p2","mail",0));
        memberManagement.addMember(new Member("p3","mail",0));
        memberManagement.viewMembers();
        memberManagement.deleteMember("p");
        memberManagement.viewMembers();
        memberManagement.updateMember("p2","newname");
        memberManagement.viewMembers();
    }

    void addMember(Member member) {
        List<Book> memberBooks = new ArrayList<Book>();
        Database.database.put(member,memberBooks);

    }
    void updateMember(String memberName, String newName) {
        Member memberToUpdate = null;
        String oldName = null;
        for(Member member : Database.database.keySet()) {
            if(member.name.equals(memberName)) {
                memberToUpdate = member;
                oldName = memberToUpdate.name;
                break;
            }
        }

        if(memberToUpdate != null) {
            memberToUpdate.name = newName;
            Database.database.put(memberToUpdate,Database.database.get(memberToUpdate));
            System.out.printf("Member %s has been updated\n", oldName);
        }else{
            System.out.printf("Member %s does not exist\n", memberName);
        }

    }
    void deleteMember(String memberName) {

        Member memberToDelete = null;
        for(Member member : Database.database.keySet()) {
            if(member.name.equals(memberName)) {
                memberToDelete = member;
                break;
            }
        }
        if(memberToDelete != null) {
            Database.database.remove(memberToDelete);
            System.out.printf("Member %s has been deleted\n", memberToDelete.name);
        }else{
            System.out.printf("Member %s does not exist\n", memberName);
        }


    }
    void viewMembers() {
        for (Map.Entry<Member, List<Book>> entry : Database.database.entrySet()) {
            System.out.println(entry.getKey());
        }

    }

}

class BorrowRecord{


    void viewRecords() {

    }

}



