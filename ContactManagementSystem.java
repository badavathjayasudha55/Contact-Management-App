import java.util.*;

class Contact {
    int id;
    String name;
    String phone;

    Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phone;
    }
}

public class ContactManagementSystem {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addContact() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        contacts.add(new Contact(id, name, phone));
        System.out.println("Contact Added Successfully!");
    }

    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            for (Contact c : contacts) {
                System.out.println(c);
            }
        }
    }

    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    public static void deleteContact() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Contact> itr = contacts.iterator();

        boolean deleted = false;
        while (itr.hasNext()) {
            Contact c = itr.next();
            if (c.id == id) {
                itr.remove();
                deleted = true;
                System.out.println("Contact deleted!");
                break;
            }
        }

        if (!deleted) {
            System.out.println("Contact not found!");
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- CONTACT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}