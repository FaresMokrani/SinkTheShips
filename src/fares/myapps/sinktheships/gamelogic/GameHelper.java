package fares.myapps.sinktheships.gamelogic;

public class GameHelper {

	private final String gridAlphabets = "abcdefg";
	private final int GRID_SIZE = 49;
	private final int GRID_LENGTH = 7;
	private final int SHIP_SIZE = 3;
	private int[] gameGrid = new int[GRID_SIZE];

	public void positionShip(Ship ship) {
		int[] currentLocation = new int[SHIP_SIZE];
		int incr = 1;
		boolean success = false;
		int shipDirection = 0;
		int shipParts = 0;
		int startingPoint = 0;
		int trials = 0;
		String temp = "";
		char horizontalCoord = ' ';
		String verticalCoord = "";

		while (!success && trials < 100) {
			currentLocation = new int[SHIP_SIZE];// reinitialize every time
			success = true;
			shipDirection = rand(2);
			startingPoint = rand(GRID_SIZE);
			shipParts = 0;
			if (shipDirection == 1) {// direction = 1 => vertical
				incr = GRID_LENGTH;
			}
			while (shipParts < SHIP_SIZE) {
				if (startingPoint > GRID_SIZE - 1 || gameGrid[startingPoint] == 1) {
					// already occupied or starting point off grid
					success = false;
					break;
				}
				if (shipDirection == 0 && shipParts > 0
						&& startingPoint % GRID_LENGTH == 0) {
					// direction = 0 => horizontal
					success = false;
					break;
				}
				currentLocation[shipParts] = startingPoint;
				gameGrid[startingPoint] = 1;
				startingPoint += incr;
				shipParts++;
			}
			trials++;
		}
		if (success) {
			for (int i = 0; i < SHIP_SIZE; i++) {
				horizontalCoord = gridAlphabets.charAt(currentLocation[i]
						% GRID_LENGTH);
				verticalCoord = String.valueOf((currentLocation[i] / 7) + 1);
				temp = horizontalCoord + verticalCoord;
				ship.setLocation(temp);
				System.out.println((i+1) + " location: " + temp);
			}
		}else{
			System.out.println("Error: could't position the ship");
		}
	}

	private int rand(int num) {
		return (int) (Math.random() * num);
	}
}
