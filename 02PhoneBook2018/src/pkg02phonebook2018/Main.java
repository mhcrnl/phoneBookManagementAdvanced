package pkg02phonebook2018;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
            //TEST PERSOANA  
            Controller con = new Controller();
            con.start();
            Persoana.test1();
            Contact.test2();
            
		PhoneBook phoneBookMng = new PhoneBook();
		Scanner input = new Scanner(System.in);
		boolean check = true;
		while (check) {
			System.out
					.println("========== PhoneBook Management System ========== :");
			System.out.println("1. Add entryphone");
			System.out.println("2. Add phone number to entry");
			System.out.println("3. Edit entryphone ");
			System.out.println("4. Delete entryphone");
			System.out.println("5. Delete single phone number");
			System.out.println("6. Find entryphone ");
			System.out.println("7. Move phone number to the another entry");
			System.out.println("8. Display entryphone");
			System.out.println("9. Exit");
			System.out.println("Enter your option :");
			System.out
					.println("==================================================");
			int key = input.nextInt();

			switch (key) {
			case 1:
				input.nextLine();
				PhoneEntry entry = new PhoneEntry();

				System.out.println("Name of entryphone:");
				entry.setName(input.nextLine());
				while (true) {
					System.out.println("Number of entryphone[insert 0 to exit]: ");
					String entryNumberInput = input.nextLine();
					if (entryNumberInput.equals("0")) {
						break;
					}
					entry.addPhoneNumber(entryNumberInput);
				}

				if (phoneBookMng.addEntry(entry)) {
					System.out
							.println("Add the entry to the list successfully");
				} else {
					System.out
							.println("Add the entry to the list NOT successfully");
				}

				break;
			case 2:
				input.nextLine();
				System.out.println("Input name of contact: ");
				String entryName = input.nextLine();
				System.out.println("Input number: ");
				String entryPhone = input.nextLine();
				if (phoneBookMng.addPhoneNumber(entryName, entryPhone)) {
					System.out
							.println("Add the phone number to the entry successfully");
				} else {
					System.out
							.println("Add the phone number to the entry NOT successfully");
				}
				break;
			case 3: {
				System.out
						.println("Do you want to modify entryName or entryPhoneNumber : 1?2");
				int temp = input.nextInt();
				switch (temp) {
				case 1:
					input.nextLine();
					System.out.println("Enter entry name in the list :");
					String existedName = input.next();
					input.nextLine();
					System.out.println("Enter new name :");
					String newName = input.nextLine();

					if (phoneBookMng.editEntryByName(existedName, newName)) {
						System.out.println("Modification is successful");
					} else {
						System.out.println("Modification is NOT successful");
					}
					break;
				case 2:
					input.nextLine();
					System.out.println("Enter entry name:");
					String entryName2 = input.nextLine();
					System.out.println("Enter entry number u want to edit: ");
					String oldNumber = input.nextLine();
					System.out.println("Enter new entry number");
					String newNumber2 = input.nextLine();
					if (phoneBookMng.editEntryByNumber(entryName2, oldNumber,
							newNumber2)) {
						System.out.println("Modification is successful");
					} else {
						System.out.println("Modification is NOT successful");
					}
					break;
				}
			}
				break;
			case 4:
				input.nextLine();
				System.out.println("Enter the name you want to delete :");
				String delName = input.nextLine();
				if (phoneBookMng.deleteEntry(delName)) {
					System.out.println("Delete successfully");
				} else {
					System.out.println("Delete NOT successfully");
				}
				break;

			case 5:
				input.nextLine();
				System.out.println("Enter the entry name:");
				String entryName3 = input.nextLine();
				System.out.println("Enter the number u want to remove:");
				String entryPhoneNumber = input.nextLine();
				PhoneEntry entry2 = phoneBookMng.findEntryByName(entryName3);
				if ((entry2 != null)
						&& entry2.getPhoneNumber().remove(entryPhoneNumber)) {
					System.out.println("Remove phone number successfully");
				} else {
					System.out.println("Failed");
				}

				break;

			case 6:
				System.out.println("Do u want to find by name or number : 1?2");
				int temp2 = input.nextInt();
				switch (temp2) {
				case 1:
					input.nextLine();
					System.out.println("Enter the name that u want to find :");
					String findName = input.nextLine();
					ArrayList<PhoneEntry> result = phoneBookMng
							.findEntryByNotFullName(findName);
					if (result != null) {
						System.out.println(result);
					} else {
						System.out.println("NOT found ");
					}
					break;
				case 2:
					input.nextLine();
					System.out
							.println("Enter the number that u want to find :");
					String findNumber = input.nextLine();
					PhoneEntry result2 = phoneBookMng
							.findEntryByNumber(findNumber);
					if (result2 != null) {
						System.out.println(result2);
					} else {
						System.out.println("NOT found ");
					}
					break;
				}
				break;

			case 7:
				input.nextLine();
				System.out.println("Enter entryNameTarget: ");
				String entryNameTarget = input.nextLine();
				System.out.println("Enter entryNameSoource:");
				String entryNameSource = input.nextLine();
				System.out.println("Enter phoneNumber of source:");
				String phoneNumber = input.nextLine();
				if (phoneBookMng.movePhoneNumberToOtherEntry(entryNameTarget,
						entryNameSource, phoneNumber)) {
					System.out.println("Move the phone number successfully");
					if (phoneBookMng.findEntryByName(entryNameSource)
							.getPhoneNumber().isEmpty()) {
						phoneBookMng.deleteEntry(entryNameSource);
					}
				} else {
					System.out.println("Failed");
				}
				break;

			case 8:
				phoneBookMng.disp();
                            
                        
				break;

			case 9:
				System.out
						.println("Exit program, Programming is just a game !!!");
				check = false;
				break;

			default:
				System.out.println("Wrong selection!");
				break;
			}

		}

	}
}
