package RefreshKnowledge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListSort {
    static List<String> stringList = Arrays.asList("Jef", "Jonas", "Peter", "Bob");
    static List<String> fruits = Arrays.asList(
            "Cherry",
            "Dragonfruit",
            "Elderberry",
            "Elderberry",
            "Apple",
            "Banana",
            "Cherry");
    static List<Integer> integerList = Arrays.asList(2, 6, 3, 1, 9, 77, 6, 3, 5, 6, 8, 0, 9);
    static List<Double> doubleList = Arrays.asList(2.3, 6.3, 3.3, 1.7, 9.7, 77.9, 6.0, 3.9, 5.8, 6.1, 8.2, 0.0, 9.3);
    static List<Float> floatList = Arrays.asList(1.2f, 3.4f, 5.6f, 7.8f, 9.0f, 2.2f, 4.4f, 6.6f);
    static List<Long> longList = Arrays.asList(100L, 200L, 300L, 400L, 500L, 600L, 700L);
    static List<Short> shortList = Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
    static List<Byte> byteList = Arrays.asList((byte) 10, (byte) 20, (byte) 30, (byte) 40, (byte) 50);
    static List<Boolean> booleanList = Arrays.asList(true, false, true, false, true);

    static int[] intArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    static double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};
    static float[] floatArray = {0.5f, 1.5f, 2.5f, 3.5f, 4.5f, 5.5f, 6.5f, 7.5f};
    static long[] longArray = {1000L, 2000L, 3000L, 4000L, 5000L, 6000L, 7000L};
    static short[] shortArray = {(short) 10, (short) 20, (short) 30, (short) 40, (short) 50};
    static byte[] byteArray = {(byte) 5, (byte) 15, (byte) 25, (byte) 35, (byte) 45};
    static boolean[] booleanArray = {false, true, false, true, false};

    static List<Fish> fishList = Arrays.asList(new Fish(2, 3, "Starlike"),
            new Fish(2, 5, "Blue"),
            new Fish(7, 7, "Red"));
    static List<User> userList = Arrays.asList(
            new User("Jens Vej",50),
            new User("Bob Ko",500),
            new User("Thomas Pus",5000),
            new User("Johnson Jackson",5003),
            new User("Jefferson Bit",50001),
            new User("Rasmus Cookie",50000));
    static List<String[]> wordArrays = List.of(
            new String[]{"apple", "banana", "cherry"},
            new String[]{"banana", "date", "apple"},
            new String[]{"fig", "grape", "apple"}
    );
    static List<FantasyWeapon> fantasyWeapons = Arrays.asList(
            new FantasyWeapon("Ruby sword", 1, 1100, 5.1, FantasyWeapon.RARITY.COMMON),
            new FantasyWeapon("Magic sword", 1, 125.2, 2.5, FantasyWeapon.RARITY.RARE),
            new FantasyWeapon("Light Saber", 1, 110.3, 1, FantasyWeapon.RARITY.LEGENDARY),
            new FantasyWeapon("Enchanted Axe", 1, 150, 4.8, FantasyWeapon.RARITY.UNCOMMON),
            new FantasyWeapon("Bronze Dagger", 1, 45.7, 3.2, FantasyWeapon.RARITY.COMMON),
            new FantasyWeapon("Dragon Slayer", 1, 200, 6.0, FantasyWeapon.RARITY.LEGENDARY),
            new FantasyWeapon("Silver Bow", 1, 120, 4.5, FantasyWeapon.RARITY.RARE),
            new FantasyWeapon("Iron Mace", 1, 75, 3.0, FantasyWeapon.RARITY.UNCOMMON),
            new FantasyWeapon("Warrior's Blade", 1, 195, 4.0, FantasyWeapon.RARITY.COMMON),
            new FantasyWeapon("Elder Staff", 1, 300, 7.5, FantasyWeapon.RARITY.LEGENDARY),
            new FantasyWeapon("Shadow Fang", 1, 160, 2.8, FantasyWeapon.RARITY.RARE),
            new FantasyWeapon("Knight's Shield", 1, 180, 5.5, FantasyWeapon.RARITY.UNCOMMON),
            new FantasyWeapon("Wooden Club", 1, 120, 1.5, FantasyWeapon.RARITY.COMMON),
            new FantasyWeapon("Phoenix Blade", 1, 250, 8.0, FantasyWeapon.RARITY.LEGENDARY),
            new FantasyWeapon("Steel Spear", 1, 150, 3.1, FantasyWeapon.RARITY.UNCOMMON)
    );
}

class Collection {
    public static List<User> userList = ListSort.userList;
    public static void main(String[] args) {

       //collectionsMethods();

        arraysAndArraylist();


        //Vector

        Vector<Double> vector = new Vector<>();
        vector.addAll(ListSort.doubleList);
        vector.add(2.3);
        vector.addElement(2.33);
       // vector.removeElementAt(5); // removes at index
        System.out.println(vector);
        //List<Double> test = vector.stream().filter(aDouble -> aDouble<4).sorted().collect(Collectors.toList());
        //System.out.println(test);

    }
    static void collectionsMethods(){
        List<Integer> integerList = ListSort.integerList;

        //Can shuffle places in any child under Collections
        System.out.println("Original int list: "+integerList);
        Collections.shuffle(integerList); //shuffles randomly
        System.out.println("Original int list .Shuffled"+integerList);

        Collections.sort(integerList);

        integerList.forEach(integer -> {
            if(integer % 2==0){
                System.out.println(integer);
            }
        });
        System.out.println("Original int list .sort"+integerList); //sort based on natural order

        Collections.shuffle(integerList);
        //System.out.println("find max and min values ");
        System.out.println(integerList);
        System.out.println("max:"+Collections.max(integerList));
        System.out.println("Min"+Collections.min(integerList));
    }
    static void arraysAndArraylist(){
        //Arrays
        int[] intsArr = ListSort.intArray;
        System.out.println("intsArr before: "+Arrays.toString(intsArr));


        for (int x =0; x< intsArr.length/2; x++){ //goes through half the lsit
            int a = intsArr[x]; // takes the current x element and stores it.

            intsArr[x] = intsArr[intsArr.length-1-x]; //takes what the current length-1-x is and sets it to x's index
            intsArr[intsArr.length-1-x]= a; //does the reverse with a earlier stores value
        }
        System.out.println("intsArr after: "+Arrays.toString(intsArr));
        intsArr = ListSort.intArray;
        Arrays.sort(intsArr); //easier
        System.out.println(Arrays.toString(intsArr));




        //Lists
        System.out.println("List: ");

        List<Integer> syncIntList = Collections.synchronizedList(ListSort.integerList);
        List<Integer> synIntDividedInTwo = new ArrayList<>();
        Runnable listOperations = ()->{
            synchronized (syncIntList){
                syncIntList.forEach((e)->{
                    synIntDividedInTwo.add(e*2);
                });
            }
        };
        listOperations.run();
        System.out.println(syncIntList);
        System.out.println(synIntDividedInTwo);


        List<Integer> listOf = List.of(1,2,4,5,3,1,2,3);
        List<Integer> listArrayListOf = Arrays.asList(1,2,4,5,3,1,2,3);

        listOf.forEach(number->{
            System.out.println(number+" (listOf)");
        });

        List<Integer> noDublicates= new ArrayList<>();// manual method
        for (Integer element: listOf){
            if (!noDublicates.contains(element)){ // makes sure that the bollean true is true if the element is not in the listonly contained in the list once
                noDublicates.add(element);
            }
        }



    }

//userSearcherFromSecondProject
    //Search by partial or full name
    static User searchByName(String name) throws RuntimeException {
        ArrayList<User> foundList = new ArrayList<>();
        System.out.println("Indtast navn: ");
        //Adds found members to list
        for (User u: userList){
            if (u.getName().contains(name)){
                foundList.add(u);
            }
        }
        //If only one member is found, returns found member
        if(foundList.size() == 1){
            return foundList.getFirst();
        }
        //Outputs found members by list, lets user choose
        else if (foundList.size() > 1) {
            System.out.println("Følgende brugere blev fundet med dette navn:");
            int foundUserNR = 1;
            for (User u : foundList) {
                System.out.println(foundUserNR + ": " + u.getName() + " ID: " + u.getId());
                foundUserNR++;
            }
            int foundUserChoice = InputHandler.userInputInt("Hvilken bruger vil du tilgå?");

            try {
                return foundList.get(foundUserChoice - 1);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Der er ikke en mulighed med det nummer.");
            }
        }
        throw new RuntimeException("cant find user!");
    }

       //Searches users by id
    static User searchByID(int id) throws RuntimeException{
        System.out.println("Indtast ID: ");
        for (User u: userList){
            if (u.getId()== id){
                return u;
            }
        }
        throw new RuntimeException("cant find member");
    }

    //Combines search methods
    public static User smartSearch() throws RuntimeException{

        String userInput = InputHandler.userInputString("Indtast navn eller ID på den ønskede bruger:");
        int idInput = 0;
        try{
            idInput = Integer.parseInt(userInput);
        }catch (Exception e){

        }
        if(idInput>0){
            return searchByID(idInput);
        }
        else{
            return searchByName(userInput);
        }
    }

    public static void startCollections(){}



}

class StreamClass {
    public static void main(String[] args) throws IOException {
        //startTestWithMapAndListStream();
        //videoExampleTest();

        HashMap<String, Integer> res = ListSort.fruits.stream().collect(Collectors.toMap(
                Function.identity(), String::length,
                (e1, e2) -> e1, HashMap::new));
        System.out.println(res);


        Stream<String> stringStream = Stream.of("jens", "Bo");

        stringStream.filter(string -> string.startsWith("j")).forEach(System.out::println);

        List<Integer> integerList =ListSort.integerList.stream().filter(integer -> integer % 2==0).collect(Collectors.toList());
        System.out.println(integerList);
        integerList=ListSort.integerList;

        System.out.println(integerList);
        List<Integer> noDublicates = integerList.stream().distinct().collect(Collectors.toList());//Makes sure there are no dublicates
        System.out.println(noDublicates);

        List<String> names = ListSort.fruits.stream().filter(string -> string.startsWith("A")).toList();

















    }
    public static void startTestWithMapAndListStream(){
        // data From a External List of Users
        List<User> userList = ListSort.userList;


        // Sort users by credit score with ealier userList in a stream, returns a list
        List<User> listSortstream = userList.stream()
                .sorted(Comparator.comparing(User::get_credit))
                .toList();

        // Create a set of titles, we have the enum from User which we used LinkedHasmap to Make sure that there is order but no dublicates
        Map<String, Integer> titleMap= new LinkedHashMap<>();
        int x=1; // a value that helps to find the lowest values of the keys/titles
        for (User.Title title : User.Title.values()){
            titleMap.put(title.name(),50*x); // puts it into a map,.
            x=x*10;

        }
        System.out.println(
                titleMap // prints it out so you can see how it is determined.
        );

        // Group users by title, using the Collectors.groupBy method
        Map<String, List<User>> groupedUsers = listSortstream.stream()
                .collect(Collectors.groupingBy(User::getTitle));

        // Sort users within each group by title and credit
        groupedUsers.forEach((title, users) -> {
            users.sort(Comparator.comparing(User::getTitle).thenComparing(User::get_credit));
        });



        // Print grouped users
        for(String key: titleMap.keySet()){
            System.out.println(key);
            for (User u : listSortstream) {
                if(key.equalsIgnoreCase(u.getTitle())){
                    System.out.println("\t-"+u);
                }


            }
        }
    }

    public static void videoExampleTest() throws IOException {
       //https://www.youtube.com/watch?v=t1-YZ6bF-g0
        //1. Integer Stream
        IntStream
                .range(1,10) //Sub Operation
                .forEach(System.out::print);//Terminal Operation
        System.out.println();
        //2 Integer Stream with skip
        IntStream
                .range(1,10)
                .skip(5) //skip first 5 elements
                .forEach(x-> System.out.println(x)); //x is the paramater that is passed into the lambda.
        //3 Integer Stream with sum
        System.out.println("--");
        System.out.println(IntStream
                .range(1,5)
                .sum());
        System.out.println();
        //4 Stream.of Sorted  and findFirst
        Stream.of("Ava","Jen","Po")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        //5 Stream from Array, sort, Filter and print
        String[] names ={"Al","Anders","Bob","Jenny","Sophie"};
        Arrays.stream(names)
                .filter(x->x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        //6 average sqare of an int array
        Arrays.stream(new int[] {2,4,7,9,3,2})
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println);
        //7 stream from List, filter and print
        List<String> people = Arrays.asList("Al","Anders","Bob","Jenny","Sophie");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x->x.startsWith("a"))
                .forEach(System.out::println);
        //8 stream rows form text file, sort, filter , and print
        System.out.println();
        Stream<String> navneord = Files.lines(Paths.get("src\\RefreshKnowledge\\tekstfileExample.txt"));
        navneord
                .sorted()
                .filter(x->x.length()>5)
                .forEach(System.out::println);
        navneord.close();
        //9 Stream rows from txt file and save to List
        System.out.println();
        List<String> navneord2 = Files.lines(Paths.get("src\\RefreshKnowledge\\tekstfileExample.txt"))
                .filter(x->x.contains("b"))
                .collect(Collectors.toList());
        navneord2.forEach(x-> System.out.println(x));
        //10 Stream rows from a csv file and count
        Stream<String> rows = Files.lines(Paths.get("src\\RefreshKnowledge\\rowsInCSV.txt"));
        int rowCount= (int) rows
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .count();
        System.out.println(rowCount+" rows");
        rows.close();
        //11 Stream row from CVS file, parse data from rows
        System.out.println();
        Stream<String> row2 =Files.lines(Paths.get("src\\RefreshKnowledge\\rowsInCSV.txt"));
        row2
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1])>15)
                .forEach(x-> System.out.println(x[0]+" "+x[1]+" "+x[2]));
        row2.close();
        //12 Stream rows from CSV fil, store fields in HashMap
        System.out.println();
        Stream<String> rows3 = Files.lines(Paths.get("src\\RefreshKnowledge\\rowsInCSV.txt"));
        Map<String,Integer> map = new HashMap<>();
        map = rows3
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1])>15)
                .collect(Collectors.toMap(x->x[0],x->Integer.parseInt(x[1])));
        rows3.close();
        for(String key : map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
        //13  Reduction - sum
        double total = Stream.of(7.4,3.3,6.9)
                .reduce(0.0,(Double a, Double b)->a+b);
        System.out.println("total: "+total);
        //Reductions -summary stats
        IntSummaryStatistics summaryStatistics= IntStream.of(7,6,4,55,7,8,90,3)
                .summaryStatistics();
        System.out.println(summaryStatistics);

    }

}

class SetsAndMaps {
    public static void main(String[] args) {
        System.out.println(ListSort.fishList);
        System.out.println(ListSort.integerList);


        // Printing the ArrayLists
        System.out.println("Fruits List: " + ListSort.fruits);
        System.out.println("Integer List: " + ListSort.integerList);


    //Set HashSet, makes sure than no dublicates is there, and thewre is no order, or index
        Set<String> fruitsSet = new HashSet<>(ListSort.fruits);
        Set<Integer> IntegerSet = new HashSet<>(ListSort.integerList);


        // Printing the Hashsets
        System.out.println("Fruits HashSet: " + fruitsSet);
        System.out.println("Integer HashSet: " + IntegerSet);
        for (Integer integer : IntegerSet){
           // System.out.println("Integer HashSet: " + integer); //you can do this.
        }



        // TreeSet, makes sure than no dublicates is there, sorts by natural order
        fruitsSet = new TreeSet<>(ListSort.fruits);
        IntegerSet = new TreeSet<>(ListSort.integerList);

        // Printing the TreeSets
        System.out.println("Fruits TreeSet: " + fruitsSet);
        System.out.println("Integer TreeSet: " + IntegerSet);

        // TreeSet, makes sure than no dublicates is there, the order is the same as the order it was send to the set
        fruitsSet = new LinkedHashSet<>(ListSort.fruits);
        IntegerSet = new LinkedHashSet<>(ListSort.integerList);

        // Printing the TreeSets
        System.out.println("Fruits LinkedHashSet: " + fruitsSet);
        System.out.println("Integer LinkedHashSet: " + IntegerSet);



        //Maps
        Map<String,String> users= new HashMap<>();
        users.put("jens","lol123");

        //searches for unqiue
        Runnable countsUniqueNumbers = ()->{
            Map<String,Integer> frqMap = new HashMap<>();
            for(String s: ListSort.fruits){
                frqMap.put(s,frqMap.getOrDefault(s,0)+1);
            }
            int uniqueCount = 0;
            for(int count: frqMap.values()){
                if(count==1){
                    uniqueCount++;
                }
            }
            System.out.println("uniquecount: "+uniqueCount);
        };
        countsUniqueNumbers.run();

        Runnable MapsAndEntries =()-> {
            //Maps used in a smart way
            Map<String, Integer> studentScores = new HashMap<>();
            studentScores.put("Alice", 85);
            studentScores.put("Bob", 76);
            studentScores.put("Charlie", 92);
            studentScores.put("Diana", 67);
            System.out.println("All scores: ");
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                System.out.println("\t" + entry.getKey() + "   " + entry.getValue());
            }
            System.out.println("above 80");
            for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
                if (entry.getValue() >= 80) {
                    System.out.println("\t" + entry.getKey() + "   " + entry.getValue());
                }
            }
            System.out.println("update a value ");


            String studentToUpdate = "Bob";
            if (studentScores.containsKey(studentToUpdate)) {
                studentScores.put(studentToUpdate, 88); // Update score (here you are certain that this is the student, other methods is possible, like remove)
                System.out.println("\nUpdated " + studentToUpdate + "'s score to " + studentScores.get(studentToUpdate));
            } else {
                System.out.println("\nStudent " + studentToUpdate + " not found.");
            }
            System.out.println(studentScores.get("Bob"));
        };

        List<String[]> listAndMapsAndSPlit = ListSort.userList.stream().map(user -> user.getName().split(" ")).toList();
        listAndMapsAndSPlit.forEach(array-> System.out.println(Arrays.toString(array)));


        //Flatmaps
        ListSort.wordArrays.forEach(array->{
            System.out.println(Arrays.toString(array));
        });
        List<String> ListOfArraysFlattendToOneStream = (List<String>) ListSort.wordArrays.stream().flatMap(Arrays::stream).distinct().toList();
        System.out.println(ListOfArraysFlattendToOneStream);


        //



    }
}



//this show the Comparators way of sorting items
class ComparatorLogic {
    public static void main(String[] args) {
        _Comparator();

        Comparable<String> stringComparable; //Comparable is something that compares specific values for example it could be User.name, it will try to make some kind of sorting when it does that, a Comparator uses this to its advandgede in Collections and Arrays.sort or List.sort. but many times comparable is equal to the .equals but that one compares the whole thing rather that one value that it is the same, especially when working with objects.
        Runnable runnable = ()->{
            //-1 means: user1 is less than user2, 1 means: user1 is more than user2, 0 means that the 2 objects are comparable to each other. (Needs implementation of Comparable<User> to work)
            List<User> users = ListSort.userList;
            User user1 = users.get(0);
            User user2 = users.get(1);
            System.out.println(user1.compareTo(user2));
        };
        runnable.run();




    }
    static void _Comparator(){
        System.out.println(ListSort.fishList);
        ListSort.fishList.sort(Comparator.comparingInt(Fish::getFins).thenComparing(Fish::getColor));
        System.out.println(ListSort.fishList);


        List<String> stringList = Arrays.asList("Jensen", "Bo", "Peterson", "Hansen", "Jackson", "Henrik");
        //stringList.sort(Comparator.comparing(s ->s.indexOf("s") ));
        //stringList.sort(Comparator.comparingInt(String::length));
        // Collections.sort(stringList,Comparator.comparing(String::length));

        System.out.println(stringList);


        //Takes a List of Arrays as a list, and sorts them arcording to intvalue
        List<Integer> integerList = Arrays.asList(2, 5457, 43, 57, 4, 77, 8, 18, 34, 65, 12, 33, 11, 345, 3333); //this is made of the Integer types not int as it is not a referance type
        //integerList.add(3); //Tries to overwrite an abstract method
        System.out.println(integerList.size());
        integerList.sort(Comparator.comparing(Integer::intValue)); //sort arcording to Integer Objects values
        System.out.println(integerList);
        //Adds List of Arrays as a list to an Arraylist
        ArrayList<Integer> integerArrayList = new ArrayList<>(integerList);
        integerArrayList.add(3); //uses .add which can be used in a ArrayList as Colections.add is overwrite'd correctly
        integerArrayList.sort(Comparator.comparing(Integer::intValue)); //again
        System.out.println(integerArrayList);

        integerList = integerArrayList; //checks if it can be sent back
        System.out.println(integerList); //Check

        List<String> stringLisT = new ArrayList<>();
        stringLisT.add("AC");//Bigger hashcode value than singe Char
        stringLisT.add("D");
        stringLisT.add("B");
        stringLisT.add("C");
        System.out.println("list: " + stringLisT);

        List<String> synList = Collections.synchronizedList(stringLisT);
        synList.add("E"); //Much better
        synList.sort(Comparator.comparingInt(String::hashCode));
        System.out.println("SynList: " + synList);

        System.out.println("Fantasywepons ");
        System.out.println(ListSort.fantasyWeapons);
        List<FantasyWeapon> fantasyWeapons = ListSort.fantasyWeapons;
        Collections.sort(fantasyWeapons, Comparator.comparing(FantasyWeapon::getDamagePSec).thenComparing(FantasyWeapon::getRarityValue)); //finds out that it is only when the First Comparing is equal to each other that the .thenComparing take priority
        fantasyWeapons.forEach(x-> System.out.println(x));

    }


}


class Fish {
    int gills;
    int fins;
    String color;

    Fish(int gills, int fins, String color){
        this.gills=gills;
        this.fins=fins;
        this.color=color;
    }

    public int getGills() {
        return gills;
    }

    public int getFins() {
        return fins;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                ", color='" + color + '\'' +
                '}';
    }
}

