import java.util.*;

public class Race {
	// Constructor
	public Race(int distance, boolean started) {
		this.setDistance(distance);
		this.setRaceStarted(started);
	}

	private ArrayList<Racecar> raceCars = new ArrayList<Racecar>();
	private boolean raceStarted;
	private int distance;

	// Get & setters
	public ArrayList<Racecar> getRaceCars() {
		return raceCars;
	}

	public void setRaceCars(ArrayList<Racecar> raceCars) {
		this.raceCars = raceCars;
	}

	public boolean isRaceStarted() {
		return raceStarted;
	}

	public void setRaceStarted(boolean raceStarted) {
		this.raceStarted = raceStarted;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	/*
	 * Methods
	 */

	// Add racecar to racecars array
	public void addRaceCar(Racecar racecar) {
		if (!isRaceStarted()) {
			raceCars.add(racecar);
		} else {
			System.out.println("De race is begonnen! Er mogen geen auto's meer toegevoegd worden!");
		}

	}

	// Give all cars random start position
	public void runRace() {
		boolean racing = true;
		Collections.shuffle(raceCars);

		int pos = 1;
		int currentDistance = 0;
		for (Racecar car : raceCars) {
			car.setStartPosition(pos);
			car.setCurrentDistance(currentDistance);
			pos++;
			currentDistance = currentDistance - 8;
//			System.out.println(car.toString());
		}

		while (racing) {
			for (int i = 0; i < raceCars.size(); i++) {
				Racecar car = raceCars.get(i);

				Random randomNumber = new Random();
				int rand = randomNumber.nextInt(car.getMaxSpeed()) + 1;
				int current = car.getCurrentDistance();

				// Distance updaten
				car.setCurrentDistance(current + rand);

				// Stop for loop when a car wins
				if (car.getCurrentDistance() >= getDistance()) {
					racing = false;
				}
			}
			Collections.sort(raceCars, new Comparator<Racecar>() {
				@Override
				public int compare(Racecar o1, Racecar o2) {
					return o2.getCurrentDistance() - o1.getCurrentDistance();
				}
			});
		}

	}

	public void raceResult() {
		System.out.println();
		for (int i = 0; i < raceCars.size(); i++) {
			Racecar car = raceCars.get(i);
			System.out.println("*** AND THE WINNERS ARE... ***");
			System.out.println("The number: " + (i + 1));
			System.out.println(car.toString());
			System.out.println();
		}
	}

}
