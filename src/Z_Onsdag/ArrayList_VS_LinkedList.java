package Z_Onsdag;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_VS_LinkedList {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();
    public static void main(String[] args) {
        int x = 1000000;
        double start,end,sum;

        System.out.println("test .add i forhold til hvor hurtigt Arralist vs LinkedList er: (res: arraylist normal hurtigere)");
        start = System.currentTimeMillis();
        for (int i = 0; i <x; i++) {
            arrayList.add(i);

        }
        end = System.currentTimeMillis();
        sum = end- start;
        System.out.println("ArrayList took: " + sum + " ms");
        System.out.println(arrayList.size());
        arrayList=new ArrayList<>();

        start = System.currentTimeMillis();
        for (int i = 0; i <x; i++) {
            linkedList.add(i);

        }
        end = System.currentTimeMillis();
        sum = end- start;
        System.out.println("LinkedList took: " + sum + " ms");
        System.out.println(linkedList.size());
        linkedList=new LinkedList<>();

        System.out.println("test .addLast i forhold til hvor hurtigt Arralist vs LinkedList er: (res: arraylist normal hurtigere men er langsomere end ved .add)");
         start = System.currentTimeMillis();
        for (int i = 0; i <x; i++) {
            arrayList.addLast(i);

        }
         end = System.currentTimeMillis();
         sum = end- start;
        System.out.println("ArrayList took: " + sum + " ms");
        //arrayList=new ArrayList<>();

        start = System.currentTimeMillis();
        for (int i = 0; i <x; i++) {
            linkedList.addLast(i);

        }
        end = System.currentTimeMillis();
        sum = end- start;
        System.out.println("LinkedList took: " + sum + " ms");
        //linkedList=new LinkedList<>();

        System.out.println("test .get i forhold til hvor hurtigt Arralist vs LinkedList er: Her er linked list hurttigere ");
        start = System.currentTimeMillis();
        for (int i = 0; i <x; i++) {
            arrayList.get(i);

        }
        System.out.println();
        end = System.currentTimeMillis();
        sum = end- start;
        System.out.println("ArrayList took: " + sum + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i <x; i++) {
            linkedList.get(i)
            ;

        }
        System.out.println();
        end = System.currentTimeMillis();
        sum = end- start;
        System.out.println("LinkedList took: " + sum + " ms");




    }
}
