package Z_Onsdag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static List<String> sort(List<String> stringList) {
        int length = stringList.size();
        List<String> sortedList = new ArrayList<>(stringList); // Copy input list

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (sortedList.get(j).compareTo(sortedList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap elements
            Collections.swap(sortedList, i, minIndex);
        }
        return sortedList;
    }
}
