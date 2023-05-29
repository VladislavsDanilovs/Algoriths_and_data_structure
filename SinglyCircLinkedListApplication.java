package DequeAndSinglyCircList;

class SinglyCircularlyLinkedListApp {
    public static void main(String[] args) {
        SinglyCircularlyLinkedList list = new SinglyCircularlyLinkedList();
        System.out.println(list.isEmpty());
        list.addNode(5);
        list.addNode(6);
        System.out.println(list.search(5));
        System.out.println(list.search(6));
        System.out.println(list.isEmpty());
        list.deleteNode(7);
        System.out.println(list.search(7));
        list.addNode(8);
        list.display();
    }
}

class SinglyCircularlyLinkedList {
    private Node head = null;
    private Node tail = null;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }

        tail = newNode;
        tail.setNextNode(head);
    }

    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.getNextNode();
            if (nextNode.getValue() == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.setNextNode(nextNode.getNextNode());
                    if (head == nextNode) {
                        head = head.getNextNode();
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    public boolean search(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.getValue() == searchValue) {
                    return true;
                }
                currentNode = currentNode.getNextNode();
            } while (currentNode != head);
            return false;
        }
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void display() {
        Node currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.getValue());
                currentNode = currentNode.getNextNode();
            } while (currentNode != head);
        }
    }
}

public class Node {
    private int value;
    private Node nextNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

