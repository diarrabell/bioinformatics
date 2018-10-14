/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

/*
based on LList from lectures (posted on blackboard)
 */

public class LList<E> {
    private class Node<E> {
        private E data; //data
        private Node<E> next; //next node

        //node constructor
        public Node(E d, Node<E> n) {
            this.data = d;
            this.next = n;
        }

        public E getData() {
            return data;
        }

        public void setData(E d) {
            this.data = d;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public Node<E> next() {
            return next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private Node<E> curr;
    private int n;

    //constructors
    public LList() {
        curr=tail=head=new Node<E>(null,null);
        n = 0;
    }

    public LList(int size) {
        this();
    }

    // removes all elements
    public void clear() {
        head.setNext(null); // Drop access to links
        curr = tail = head = new Node<E>(null, null); // Create header
        n = 0;
    }

    //insert e at current position
    public void insert (E e) {
        curr.setNext(new Node<E>(e, curr.next()));
        if (tail == curr) {
            tail = curr.next();  // New tail
        }
        n++;
    }

    //adds e to end of list
    public void append(E e) {
        tail.setNext(new Node<E>(e, null));
        tail = tail.getNext();
        n++;
    }

    //remove and return current element
    public E remove() {
        if (curr.next() == null) {
            return null; // Nothing to remove
        }
        E e = curr.next().getData(); // Remember value
        if (tail == curr.next()) {
            tail = curr; // Removed last
        }
        curr.setNext(curr.next().next()); // Remove from list
        n--; // Decrement count
        return e; // Return value
    }

    //set curr at list start
    public void moveToStart() {
        curr = head;
    }

    //set curr at list end
    public void moveToEnd() {
        curr = tail;
    }

    //move curr one step left, no change if at front
    public void prev() {
        if (curr == head) {
            return; // No previous element
        }
        Node<E> temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
    }

    //move curr one step right, no change if at end
    public void next() {
        if (curr != tail) {
            curr = curr.next();
        }
    }

    //returns list length
    public int length() {
        return n;
    }

    //returns position of current element
    public int currPos() {
        Node<E> temp = head;
        int i;
        for (i=0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    //move down list to position
    public void moveToPos(int position) {
        if (position<0 && position>=n) {
            System.out.println("Position out of range");
        }
        curr = head;
        for(int i=0; i<position; i++) {
            curr = curr.next();
        }
    }

    //current element's value
    public E getValue() {
        if(curr.next() == null) {
            return null;
        }
        return curr.next().getData();
    }

    //generates readable representation of list's contents
    public String toString() {
        // Save the current position of the list
        int oldPos = currPos();
        int length = length();
        StringBuffer out = new StringBuffer((length() + 1) * 4);

        moveToStart();
        out.append("<");

        for (int i = 0; i < oldPos; i++) {
            out.append(getValue());
            out.append(" ");
            next();
        }

        out.append("| ");

        for (int i = oldPos; i < length; i++) {
            out.append(getValue());
            out.append(" ");
            next();
        }

        out.append(">");
        moveToPos(oldPos); // Reset the fence to its original position
        return out.toString();
    }
}
