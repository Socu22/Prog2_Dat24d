package Z_Onsdag;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelenfonListe {
    static Map<String, Integer> field = new HashMap<>();
    public static void main(String[] args) {


    }
}

class Main {
    static String file = "src" + File.separator + "Z_Onsdag" + File.separator+ "TelenfonListe.txt" + File.separator;
    static Scanner scanner = new Scanner(System.in);
    static int action;
    static boolean isrunning = true;
    static String navn;
    static int tlf;
    public static void main(String[] args) {

        while (isrunning) {
            System.out.println("Choose action: 1. new, 2. show, 3. search(name), 4. del,5. if name exist, 6. all names, 7. save, 8. load, 9. exit");
            action = scanner.nextInt(); //action for switch


            switch (action) {
                case 1: // add navn og tlf
                    add();
                    break;
                case 2: // show tlf list
                    showAll();
                    break;
                case 3://search Method: tlf
                    searchWithName();
                    break;
                case 4: //del
                    delete();
                    break;
                case 5:// if name exist
                    ifNameExist();
                    break;
                case 6: // all names
                    allNames();
                    break;
                case 7: //save
                    saveInFile();
                    break;
                case 8: //load
                    loadFromFile();
                    break;
                case 9: //exist
                    isrunning = false;
                    break;




            }

        }
    }
    static void add(){
        System.out.println("Write name: ");
        navn = scanner.next();
        scanner.nextLine();
        System.out.println("Write phone number: ");
        tlf = scanner.nextInt();
        scanner.nextLine();
        TelenfonListe.field.put(navn, tlf);
    }
    static void showAll(){
        for (Map.Entry<String, Integer> entry : TelenfonListe.field.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    static void searchWithName(){
        System.out.println();
        navn = scanner.next();
        scanner.nextLine();
        for (Map.Entry<String, Integer> entry : TelenfonListe.field.entrySet()) {
            if (entry.getKey().equals(navn)) {
                System.out.println("name: " + entry.getKey() + " tlf: " + entry.getValue());
            }
        }

    }
    static void delete(){
        navn = scanner.next();
        scanner.nextLine();
        TelenfonListe.field.remove(navn);
    }
    static void ifNameExist(){
        navn = scanner.next();
        scanner.nextLine();
        if (TelenfonListe.field.containsKey(navn)) {
            System.out.println("Name exist.");
        } else {
            System.out.println("Name does not exist.");
        }
    }
    static void allNames(){
        for (String name : TelenfonListe.field.keySet()) {
            System.out.println(name);
        }
    }

    static void saveInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, Integer> entry : TelenfonListe.field.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] parts;
            System.out.print("successfully Loaded n From DataBaseTxtFile To List\n");
            while ((line = reader.readLine()) != null) {
                parts = line.split(" ");
                TelenfonListe.field.put(parts[0], Integer.parseInt(parts[1]));


            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }


    }
}
