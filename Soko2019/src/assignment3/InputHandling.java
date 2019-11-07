package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandling {

    public static int[] convert(String input) {
        int[] result = new int[2];
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] numbers = {"8", "7", "6", "5", "4", "3", "2", "1"};
        int x = -1;
        int y = -1;
        for (int i = 0; i < letters.length; i++) {
            if (input.substring(0, 1).equals(letters[i])) {
                y = i;
            }
            if (input.substring(1, 2).equals(numbers[i])) {
                x = i;
            }
        }
        result[0] = x;
        result[1] = y;
        return result;
    }

}
