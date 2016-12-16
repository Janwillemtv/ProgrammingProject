package ss.week4;

import java.util.AbstractList;

public class LinkedList<Element> extends AbstractList<Element>{

    private int size;
    private Node header;

    public LinkedList () {
        size = 0;
        header = null;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if(index > 0) {
            Node prev = getNode(index - 1);
            Node toRemove = getNode(index);

            prev.next = toRemove.next;
        }
        else {
            header = header.next;
        }

        size--;
        return true;
    }

    @Override
    public Element remove(int index) {
        Node toRemove = getNode(index);
        Node next = toRemove.next;

        if(index == 0) {
            header = next;
        }

        size--;
        return toRemove.element;
    }

    @Override
    public void add(int index, Element element) {
        Node newNode = new Node(element);

        if (size() == 0) {
            header = newNode;
            header.next = header;
        }
        else {
            if (index == 0) {
                newNode.next = header;
                header = newNode;
            } else {
                Node n = getNode(index - 1);
                newNode.next = n.next;
                n.next = newNode;
            }
        }

        size++;
    }

    @Override
    public Element get(int index) {
        Node n = header;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n.element;
    }

    public Node getNode(int index) {
        Node n = header;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n;
    }

    @Override
    public int indexOf(Object o) {

        // return place in list
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    public class Node {
        Element element;
        Node next;

        public Node(Element e) {
            this.element = e;
            this.next = null;
        }

        public Element getElement() {
            return this.element;
        }
    }

    public Node findBefore(Element e) {
        int index = indexOf(e);

        if (index - 1 > -1) {
            return getNode(index - 1);
        }

        return null;
    }
}