package RefreshKnowledge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateDatabase {
    public static void main(String[] args) {
        Buffered_W_R.loadListBasedOnFile();
        Buffered_W_R.itemList=Buffered_W_R.itemList.stream().distinct().toList();
        Buffered_W_R.saveFileBasedOnList();

    }
}
class Buffered_W_R {
    static List<Item> itemList = new ArrayList<>();
    static String filename="src" + File.separator + "RefreshKnowledge" + File.separator + "DataBaseTxtFile.txt";

    static void saveFileBasedOnList() {
        //writeInFileBasedOnList
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            System.out.print("successfully saved n From List To DataBaseTxtFile\n");

            for (Item item : itemList) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
                System.out.println("\t"+item.name);
            }
            System.out.println("Done");

        } catch (IOException e) {
            System.out.println("Failed to save: " + e.getMessage());
        }
    }
    static  public void loadListBasedOnFile() {
        //readInFileBasedOnFile_SendToArraylist
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] parts;
            System.out.print("successfully Loaded n From DataBaseTxtFile To List\n");
            while ((line = reader.readLine()) != null) {
                parts = line.split(" ");
                if (parts[0].equals("Rock:")){
                    String name= parts[1];
                    int amount= Integer.parseInt(parts[2]);
                    String type= parts[2];
                    itemList.add(new Rock(name,amount,type));
                    System.out.println("\t"+name);
                }else {
                    String name= parts[1];
                    int amount= Integer.parseInt(parts[2]);
                    itemList.add(new Item(name,amount));
                    System.out.println("\t"+name);


                }


            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
    }




}
