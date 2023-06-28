import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        List<List<Integer>> firstCombination = findCombinations(arr, target);
        System.out.println("First Combination For " + target + ": " + firstCombination);

        int[] mergedArray = mergeAndSort(firstCombination);
        System.out.println("Merge Into a single Array: " + Arrays.toString(mergedArray));

        int doubledTarget = 2 * target;
        List<List<Integer>> secondCombination = findCombinations(mergedArray, doubledTarget);
        System.out.println("Second Combination For " + doubledTarget + ": " + secondCombination);
    }

    public static List<List<Integer>> findCombinations(int[] arr, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        List<List<Integer>> combination = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (complementMap.containsKey(complement)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(complement);
                combination.add(pair);
            } else {
                complementMap.put(arr[i], i);
            }
        }

        return combination;
    }

    public static int[] mergeAndSort(List<List<Integer>> combination) {
        List<Integer> mergedList = new ArrayList<>();

        for (List<Integer> pair : combination) {
            mergedList.addAll(pair);
        }

        int[] mergedArray = new int[mergedList.size()];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }

        Arrays.sort(mergedArray);
        return mergedArray;
    }
}