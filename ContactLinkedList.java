import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactLinkedList implements Serializable {
    private Node head;

    private static class Node implements Serializable {
        Contact contact;
        Node next;

        Node(Contact contact) {
            this.contact = contact;
            this.next = null;
        }
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean deleteContact(String name) {
        if (head == null) return false;
        if (head.contact.getName().equalsIgnoreCase(name)) {
            head = head.next;
            return true;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public Contact findContact(String name) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(name)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public void displayContacts() {
        Node current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        Node current = head;
        while (current != null) {
            contacts.add(current.contact);
            current = current.next;
        }
        return contacts;
    }
}
