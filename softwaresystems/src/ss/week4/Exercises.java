package ss.week4;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
        int negative = 0;
        for (int intValue : arr) {
            if(intValue < 0 ) negative += 1;
        }
        return negative;
    }

    public static void reverseArray(int[] ints) {
        int l = 0;
        int r = ints.length - 1;

        while( l < r ) {

            // swap the values at the left and right indices
            int temp = ints[l];
            ints[l] = ints[r];
            ints[r] = temp;

            // move the left and right index pointers in toward the center
            l++;
            r--;
        }
    }


    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
