package ss.week4;

import java.util.*;

public class MergeSort {

    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
        merge(list);
    }

    public static <Elem extends Comparable<Elem>> void merge(List<Elem> array) {
        if (array.size() > 1) {

            // split array into two halves
            List<Elem> left = leftHalf(array);
            List<Elem> right = rightHalf(array);

            // recursively sort the two halves
            merge(left);
            merge(right);

            // merge the sorted halves into a single array
            sort(array, left, right);
        }
    }

    // Order the left and right arrays
    public static <Elem extends Comparable<Elem>> void sort(List<Elem> result, List<Elem> left, List<Elem> right) {
        int i1 = 0; // index into left array
        int i2 = 0; // index into right array

        List<Elem> helper = new ArrayList<>(); //Helper array

        // Order the lists
        for (int i = 0; i < result.size(); i++) {
            if (i2 > right.size() - 1 || (i1 <= left.size() - 1 && left.get(i1).compareTo(right.get(i2)) < 0)) {
                helper.add(i, left.get(i1));
                i1++;
            }
            else {
                helper.add(i, right.get(i2));
                i2++;
            }
        }

        // Put the ordered list in the original
        ListIterator<Elem> i = result.listIterator();
        int count = 0;
        while (i.hasNext() && count < helper.size()) {
            i.next();
            i.set(helper.get(count));
            count++;
        }
    }

    // Returns the first half of the given array.
    public static <Elem extends Comparable<Elem>> List<Elem> leftHalf(List<Elem> array) {
        int size1 = array.size() / 2;
        List<Elem> left = new ArrayList<>();

        for (int i = 0; i < size1; i++) {
            left.add(i, array.get(i));
        }

        return left;
    }

    // Returns the second half of the given array.
    public static <Elem extends Comparable<Elem>> List<Elem> rightHalf(List<Elem> array) {
        int size1 = array.size() / 2;
        int size2 = array.size() - size1;
        List<Elem> right = new ArrayList<>();

        for (int i = 0; i < size2; i++) {
            right.add(i, array.get(i + size1));
        }

        return right;
    }
}