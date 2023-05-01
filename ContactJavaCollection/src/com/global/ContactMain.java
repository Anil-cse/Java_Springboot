package com.global;

import java.util.*;

import com.global.modal.Contact;

public class ContactMain {

	private static List<Contact> contacts = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\nSelect an option:");
	            System.out.println("1. Add a contact");
	            System.out.println("2. Display all contacts");
	            System.out.println("3. Update a contact");
	            System.out.println("4. Delete a contact");
	            System.out.println("5. Exit");

	            choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter email: ");
	                    String email = scanner.nextLine();
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter phone: ");
	                    String phone = scanner.nextLine();
	                    System.out.print("Enter address: ");
	                    String address = scanner.nextLine();
	                    Contact contact = new Contact(email, name, phone, address);
	                    contacts.add(contact);
	                    System.out.println("Contact added successfully!");
	                    break;
	                case 2:
	                    if (contacts.isEmpty()) {
	                        System.out.println("No contacts found.");
	                    } else {
	                        System.out.println("List of contacts:");
	                        contacts.stream().forEach(c -> System.out.println("Email: " + c.getEmail() + ", Name: " + c.getName() + ", Phone: " + c.getPhone() + ", Address: " + c.getAddress()));
	                    }
	                    break;
	                case 3:
	                    if (contacts.isEmpty()) {
	                        System.out.println("No contacts found.");
	                    } else {
	                    	 System.out.println("Enter email of contact to edit: ");
	                    	    String emailToEdit = scanner.nextLine();
	                    	    Contact updatedContact = contacts.stream().filter(c -> c.getEmail().equals(emailToEdit)).findFirst().orElse(null);
	                        if (updatedContact == null) {
	                            System.out.println("Contact not found.");
	                        } else {
	                            System.out.print("Enter new email: ");
	                            email = scanner.nextLine();
	                            System.out.print("Enter new name: ");
	                            name = scanner.nextLine();
	                            System.out.print("Enter new phone: ");
	                            phone = scanner.nextLine();
	                            System.out.print("Enter new address: ");
	                            address = scanner.nextLine();
	                            updatedContact.setEmail(email);
	                            updatedContact.setName(name);
	                            updatedContact.setPhone(phone);
	                            updatedContact.setAddress(address);
	                            System.out.println("Contact updated successfully!");
	                        }
	                    }
	                    break;
	                case 4:
	                    if (contacts.isEmpty()) {
	                        System.out.println("No contacts found.");
	                    } else {
	                        System.out.print("Enter email of contact to delete: ");
	                        			email = scanner.nextLine();
	                        			Contact deletedContact = contacts.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
	                        			if (deletedContact == null) {
	                        			System.out.println("Contact not found.");
	                        			} else {
	                        			contacts.remove(deletedContact);
	                        			System.out.println("Contact deleted successfully!");
	                        			}
	                        			}
	                                    break;
	                case 5:
	                System.out.println("Exiting...");
	                break;
	                default:
	                System.out.println("Invalid choice. Please try again.");
	                }
	                } while (choice != 5);
	                
	                }
	
}
