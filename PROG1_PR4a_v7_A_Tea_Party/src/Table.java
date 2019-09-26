public class Table {
	private Guest[] guests = new Guest[4];

	void addGuest(Guest guest) {
		for (int i = 0; i < this.guests.length; i++) {
			if (this.guests[i] == null) {
				this.guests[i] = guest;
				break;
			}
		}
	}

	void printTeaParty() {
		for (int i = 0; i < guests.length; i++) {
			if(guests[i] != null) {
				guests[i].printInformation();
			}
		}
	}
}
