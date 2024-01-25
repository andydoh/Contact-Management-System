import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactLinkedList contactList = FileOperations.loadContacts();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Save Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    // Delete Contact
                    System.out.print("Enter Name of Contact to Delete: ");
                    String nameToDelete = scanner.nextLine();
                    if (contactList.deleteContact(nameToDelete)) {
                        System.out.println("Contact Deleted Successfully.");
                    } else {
                        System.out.println("Contact Not Found.");
                    }
                    break;
                case 3:
                    // Search Contact
                    System.out.print("Enter Name of Contact to Search: ");
                    String nameToFind = scanner.nextLine();
                    Contact foundContact = contactList.findContact(nameToFind);
                    if (foundContact != null) {
                        System.out.println("Contact Found: " + foundContact);
                    } else {
                        System.out.println("Contact Not Found.");
                    }
                    break;
                case 4:
                    // Display All Contacts
                    contactList.displayContacts();
                    break;
                case 5:
                    // Save Contacts
                    FileOperations.saveContacts(contactList);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Please enter a number between 1 and 6.");
            }
        }
    }
}
