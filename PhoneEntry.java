package phoneBookManagementAdvanced;

import java.util.ArrayList;

public class PhoneEntry {
	private String name;
	private ArrayList<String> phoneNumber = new ArrayList<String>();

	public PhoneEntry() {
	}

	public PhoneEntry(String name, ArrayList<String> phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.add(phoneNumber);
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getPhoneNumber() {
		return phoneNumber;
	}

	public boolean addPhoneNumber(String phoneNumber) {

		ArrayList<String> entryNumber = new ArrayList<>(this.phoneNumber);
		entryNumber.add(phoneNumber);
		if (!isDuplicatePhoneNumber(entryNumber)) {
			this.phoneNumber = entryNumber;
			return true;
		}
		return false;
	}

	public boolean deletePhoneNumber(String phoneNumber) {
		if (this.phoneNumber.remove(phoneNumber)) {
			return true;
		} else
		
			return false;

	}

	private boolean isDuplicatePhoneNumber(ArrayList<String> phoneNumber) {
		for (int i = 0; i < phoneNumber.size(); i++) {
			for (int j = i + 1; j < phoneNumber.size(); j++) {
				if (phoneNumber.get(i).equals(phoneNumber.get(j))) {
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		return "Name: " + name + ", Phone number: " + phoneNumber;
	}

}
