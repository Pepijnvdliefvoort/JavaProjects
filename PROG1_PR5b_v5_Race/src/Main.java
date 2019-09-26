
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Race race = new Race(4000, false);
		 race.addRaceCar(new Racecar("Ferrari", "Jasper", 5));
		 race.addRaceCar(new Racecar("Porsche", "Bob", 10));
		 race.addRaceCar(new Racecar("Fiat", "Jos", 9));
		 race.runRace();
		 race.raceResult();
	}

}
