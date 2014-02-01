package fares.myapps.sinktheships.gamelogic;

import java.util.ArrayList;

public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Ship> ships = new ArrayList<Ship>();
		
		Ship ship1 = new Ship();
		Ship ship2 = new Ship();
		Ship ship3 = new Ship();
		
		ship1.setName("Lombardo");
		ship2.setName("Titanic");
		ship3.setName("Gambetha");
		
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		
		GameHelper gameHelper = new GameHelper();

		for (int i = 0; i < 3; i++) {
			System.out.println("The " + (i+1) + " ship's location:\n");
			gameHelper.positionShip(ships.get(i));
			System.out.println("-----------------------\n");
		}
	}

}
