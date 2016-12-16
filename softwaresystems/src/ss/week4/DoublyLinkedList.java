package ss.week4;

import java.util.AbstractList;

public class DoublyLinkedList<Element> extends AbstractList<Element>{

    private int size;
    private Node header;

    public DoublyLinkedList() {
        size = 0;
        header = null;
    }

    @Override
    public Element remove(int index) {
        Node toRemove = getNode(index);
        Node prev = toRemove.previous;
        Node next = toRemove.next;

        prev.next = next;
        next.previous = prev;

        if(index == 0) {
            header = next;
        }

        size--;
        return toRemove.element;
    }

    @Override
    public void add(int index, Element element) {
        Node newNode = new Node(element);

        // check if there are already items in the list
        if (size() == 0) {
            header = newNode;
            header.next = header;
            header.previous = header;
        }
        else {
            // check if requested index is 0 (no link to previous node possible)
            if(index == 0) {
                newNode.next = header;
                newNode.previous = header.previous;
                header.previous = newNode;
                header = newNode;
            }
            else {
                Node n = getNode(index - 1);
                newNode.previous = n;
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

        // return index in list
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

    private class Node {
        Element element;
        Node next, previous;

        public Node(Element e) {
            this.element = e;
            this.next = null;
            this.previous = null;
        }
    }
}