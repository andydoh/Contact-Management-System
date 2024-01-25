import java.io.*;
import java.util.List;

public class FileOperations {
	private static final String FILE_NAME = "/Users/andydo/eclipse-workspace/Contact Management System/src/contacts.txt";

    public static void saveContacts(ContactLinkedList contactsList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            List<Contact> contacts = contactsList.getContacts();
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
                writer.newLine();
            }
            System.out.println("Contacts saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public static ContactLinkedList loadContacts() {
        File file = new File(FILE_NAME);
        ContactLinkedList contacts = new ContactLinkedList();

        if (!file.exists()) {
            System.out.println("No existing contacts file found. A new file will be created.");
            return contacts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    contacts.addContact(new Contact(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
            System.out.println("Contacts loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
        return contacts;
    }
}











