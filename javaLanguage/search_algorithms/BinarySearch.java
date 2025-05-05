package javaLanguage.search_algorithms;

import javaLanguage.helper.Helper;
import java.util.ArrayList;
import java.util.Random;

public class BinarySearch {

    static int randomTarget;
    private int[] arr;
    public int getSize() {
        return size;
    }
    private int size;

    ArrayList<Integer> numOfChecksAverage = new ArrayList<>();;

    public BinarySearch(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public static void beginBinarySearchExperiment(int numOfRuns) {
        for (int i = 2; i <= numOfRuns; i++) {
            binarySearchActions((int) Math.pow(2,i));
        }
    }

    static void binarySearchActions(int size) {
        BinarySearch binarySearch = new BinarySearch(Helper.generateIntArray(size), size);
        for (int i = 0; i < 100000; i++) {
            randomTarget = new Random().nextInt(0, binarySearch.getSize());
            binarySearch.search(randomTarget);
        }
        System.out.println(STR."n: \{binarySearch.getSize()} \tMax Checks (log2(n)): \{Helper.log2(binarySearch.getSize())} \tAverage Checks: \{binarySearch.generateAverageChecks()}");
    }

    public double generateAverageChecks() {
        double sum = 0;
        for (int number : numOfChecksAverage) {
            sum += number;
        }
        return sum / numOfChecksAverage.size();
    }


    public void search(int target) {
        int min = 0;
        int max = arr.length - 1;
        int numOfChecks = 0;
        while (min <= max) {
            numOfChecks++;
            int mid = (min + max) / 2;
            if (arr[mid] == arr[target]) {
                numOfChecksAverage.add(numOfChecks);
                return;
            }
            if (arr[mid] < target) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
    }
}