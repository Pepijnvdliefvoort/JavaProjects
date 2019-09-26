import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Field {
	public Field() {
		setField();
	}

	// Breedte x hoogte van het veld
	static final int size = 10;

	// Initialisation
	HashMap<String, Square> squares = new HashMap<String, Square>();

	// Get & setters
	public HashMap<String, Square> getField() {
		return squares;
	}

	public void setField() {

		for (char columnName = 'A'; columnName <= 'J'; columnName++) {
			for (int y = 1; y <= size; y++) {
				Square newSquare = new Square();
				String number = String.valueOf(columnName) + y;

				// Assign key with value eg. A1, new Square
				squares.put(number, newSquare);
			}

		}
	}

	// Print field
	public void printField() {
		for (int y = size; y > 0; y--) {
			// Alignment for 2 digits
			if (y < 10) {
				System.out.print(" ");
			}
			// Print vertical numbers counting down
			System.out.print(y + "| ");
			for (char columnName = 'A'; columnName <= 'J'; columnName++) {
				String number = String.valueOf(columnName) + y;

				// Square value
				Square square = squares.get(number);
				if (square.isShot()) {
					if (square.getShip() != null) {
						System.out.print(square.getShip().getTypeShip().substring(0, 1) + " ");
					} else {
						System.out.print("~ ");
					}
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println("  +--------------------");
		System.out.println("    A B C D E F G H I J");
	}

	// Algorithm to place ship on field
	public void initShips() {
		// Create all available ships
		Ship[] ships = new Ship[] { new Ship("Vliegdekschip", 5), new Ship("Slagschip", 4), new Ship("Onderzeeër", 3),
				new Ship("Torpedobootjager", 3), new Ship("Patrouilleboot", 2) };
		int rowSteps = size / ships.length;
		int shipCounter = 0;

		// Create list from 1 - 10
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			numbers.add(i);
		}

		while (shipCounter < ships.length) {

			// Row iteration
			BeginShipLoop: for (int y = 1; y <= size; y += rowSteps) {

				// shuffle ArrayList with every new iteration
				Collections.shuffle(numbers);
				int randomNumer = numbers.get(y);

				// If randomNumber is 0, up it by 1 to prevent NullPointException (out of range)
				if (randomNumer == 0) {
					randomNumer++;
				}
				// Column iteration
				for (int x = 0; x < numbers.size(); x++) {
					char currentChar = (char) ('A' + numbers.get(x));
					String key = String.valueOf(currentChar) + randomNumer;

					// Check if random chosen square is available (null)
					if (squares.get(key).getShip() == null) {
						boolean direction = getRandomDirection();
						boolean placeable = true;

						// Vertical ship placement
						if (direction) {

							// Check if length of ship squares are available on vertical axis (null)
							for (int j = 0; j < ships[shipCounter].getLength(); j++) {
								String checkSquare = String.valueOf(currentChar) + (randomNumer + j);

								// Try catch to check for valid positions
								try {
									if (squares.get(checkSquare).getShip() != null) {
										placeable = false;
										break;
									}
								} catch (NullPointerException e) {
									placeable = false;
									break;
								}

							}

							// If all squares are available (null), place ship
							if (placeable) {
								for (int i = 0; i < ships[shipCounter].getLength(); i++) {
									String currentPosition = String.valueOf(currentChar) + (randomNumer + i);
									Square currentSquare = squares.get(currentPosition);
									currentSquare.setShip(ships[shipCounter]);
								}
								// After ship is placed, end current ship's loop
								break BeginShipLoop;
							}
						}
						// Horizontal ship placement
						else {
							char availableChar = (char) ('A' + numbers.get(x));
							char placeChar = (char) ('A' + numbers.get(x));

							// Check if length of ship squares are available on horizontal axis (null)
							for (int j = 0; j < ships[shipCounter].getLength(); j++) {
								String checkSquare = String.valueOf(availableChar) + randomNumer;
								availableChar++;

								// Try catch to check for valid positions
								try {
									if (squares.get(checkSquare).getShip() != null) {
										placeable = false;
										break;
									}
								} catch (NullPointerException e) {
									placeable = false;
									break;
								}

							}
							// If all squares are available (null), place ships
							if (placeable) {
								for (int i = 0; i < ships[shipCounter].getLength(); i++) {
									String currentPosition = String.valueOf(placeChar) + randomNumer;
									placeChar++;
									Square currentSquare = squares.get(currentPosition);
									currentSquare.setShip(ships[shipCounter]);
								}
								break BeginShipLoop;
							}
						}
					}

				}
			}
			// Continue onto the next ship
			shipCounter++;
		}

	}

	// Get random boolean
	public static boolean getRandomDirection() {
		return Math.random() < 0.5;
	}

	// Shoot specific square
	public void shoot(String pos) {
		Square aimedSquare = squares.get(pos);
		aimedSquare.setShot(true);

		// Print updated field
		printField();
	}

	public boolean validateGuess(String pos) {
		try {
			if (squares.get(pos).getShip() == null || squares.get(pos).getShip() != null) {
				if (squares.get(pos).isShot()) {
					System.err.println("*** Er is al op dit veld geschoten! ***");
					return false;
				} else {
					return true;
				}
			} else {
				System.err.println("*** De locatie " + pos + " bestaat niet! ***");
				return false;
			}
		} catch (NullPointerException e) {
			System.err.println("*** De locatie " + pos + " bestaat niet! ***");
			return false;
		}

	}
}
