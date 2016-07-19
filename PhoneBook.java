package phoneBookManagementAdvanced;

import java.util.ArrayList;

public class PhoneBook {
	private ArrayList<PhoneEntry> phoneEntries = new ArrayList<PhoneEntry>();

	private boolean isDuplicateName(String entryName) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			if (phoneEntries.get(i).getName().equals(entryName)) {
				return true;
			}
		}
		return false;
	}

	private boolean isDuplicateNumber(ArrayList<String> entryNumber) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			for (int j = 0; j < phoneEntries.get(i).getPhoneNumber().size(); j++) {
				for (int k = 0; k < entryNumber.size(); k++) {
					if (phoneEntries.get(i).getPhoneNumber().get(j)
							.equals(entryNumber.get(k))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean addEntry(PhoneEntry entry) {
		if (!isDuplicateName(entry.getName())
				&& !isDuplicateNumber(entry.getPhoneNumber())) {
			phoneEntries.add(entry);
			return true;
		}
		return false;
	}

	public boolean addPhoneNumber(String entryName, String phoneNumber) {

		if (isDuplicateName(entryName)
				&& (findEntryByNumber(phoneNumber) == null)) {
			for (int i = 0; i < phoneEntries.size(); i++) {
				if (entryName.equals(phoneEntries.get(i).getName())) {
					phoneEntries.get(i).setPhoneNumber(phoneNumber);
				}
			}
			return true;
		}
		return false;
	}

	public boolean deleteEntry(String entryName) {
		if (!isDuplicateName(entryName)) {
			return false;
		} else {
			for (int i = 0; i < phoneEntries.size(); i++) {
				if (phoneEntries.get(i).getName().equals(entryName)) {
					phoneEntries.remove(i);
					return true;
				}
			}

		}
		return false;
	}

	public ArrayList<PhoneEntry> findEntryByNotFullName(String entryName) {
		ArrayList<PhoneEntry> result = new ArrayList<PhoneEntry>();
		for (int i = 0; i < phoneEntries.size(); i++) {
			if (phoneEntries.get(i).getName().contains(entryName)) {
				result.add(phoneEntries.get(i));
			}
		}

		return result;
	}

	public PhoneEntry findEntryByName(String entryName) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			if (phoneEntries.get(i).getName().equals(entryName)) {
				return phoneEntries.get(i);
			}
		}
		return null;
	}

	public PhoneEntry findEntryByNumber(String entryNumber) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			for (int j = 0; j < phoneEntries.get(i).getPhoneNumber().size(); j++) {
				if (phoneEntries.get(i).getPhoneNumber().get(j)
						.equals(entryNumber)) {
					return phoneEntries.get(i);
				}
			}
		}
		return null;
	}

	public boolean editEntryByName(String oldName, String newName) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			if (phoneEntries.get(i).getName().equals(oldName)) {
				phoneEntries.get(i).setName(newName);
				return true;
			}
		}

		return false;
	}

	public boolean editEntryByNumber(String entryName, String oldNumber,
			String newNumber) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			if (phoneEntries.get(i).getName().equals(entryName)
					&& (phoneEntries.get(i).getPhoneNumber()
							.contains(oldNumber))) {
				PhoneEntry entry = findEntryByName(entryName);
				int index = entry.getPhoneNumber().indexOf(oldNumber);
				entry.getPhoneNumber().set(index, newNumber);
				return true;
			}
		}
		return false;
	}

	public boolean removeNumber(String entryName, String entryNumber) {
		for (int i = 0; i < phoneEntries.size(); i++) {
			for (int j = 0; j < phoneEntries.get(i).getPhoneNumber().size(); j++) {
				if ((phoneEntries.get(i).getPhoneNumber().get(j)
						.equals(entryNumber))
						&& (phoneEntries.get(i).getName().equals(entryName))) {
					phoneEntries.get(i).getPhoneNumber().remove(j);
					return true;
				}
			}
		}
		return false;
	}

	public boolean movePhoneNumberToOtherEntry(String entryNameTarget,
			String entryNameSource, String phoneNumber) {
		if ((findEntryByName(entryNameTarget) != null)
				&& (findEntryByName(entryNameSource) != null)
				&& (findEntryByNumber(phoneNumber) != null)) {
			boolean check = false;
			for (int i = 0; i < phoneEntries.size(); i++) {
				if (phoneEntries.get(i).getName().equals(entryNameSource)) {
					if (phoneEntries.get(i).getPhoneNumber()
							.remove(phoneNumber)) {
						check = true;
						break;
					} else {
						return false;
					}

				}

			}
			if (check) {
				for (int i = 0; i < phoneEntries.size(); i++) {
					if (phoneEntries.get(i).getName().equals(entryNameTarget)) {
						phoneEntries.get(i).getPhoneNumber().add(phoneNumber);
						return true;
					}
				}
			}

		}
		return false;
	}

	public void disp() {
		for (PhoneEntry temp : phoneEntries) {
			System.out.println(temp.toString());
		}
	}

}
