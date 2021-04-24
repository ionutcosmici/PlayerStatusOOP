package Proiect;
															//Proiect [P1] Concepte OOP - Ionut Cosmici
public class Main {

	public static void main(String[] args) {

		PlayerStatus Player1 = new PlayerStatus();
		PlayerStatus Player2 = new PlayerStatus();

		Player1.initPlayer("s1mple", 10, 100000);
		Player2.initPlayer("f0rest", 10, 100000);
		Player1.findArtifact(6);	
		Player2.findArtifact(11);
		Player1.setWeaponInHand("sniper");
		Player2.setWeaponInHand("kalashnikov");
		Player1.movePlayerTo(2, 1500);
		Player2.movePlayerTo(2, 3000); 
		System.out.println(Player2.shouldAttackOponent(Player1)); 
		Player1.showPlayerStatus();
		Player2.showPlayerStatus();
		 
		System.out.print("\nThe game that is being played by the two players is: ");   
		System.err.println(Player1.getGameName()); 

		System.out.println("\nPlayer " + Player1.getNickname() + (Player1.shouldAttackOponent(Player2) ? " has a chance to win against the Player " : 
				" has no chance of winning against the Player: ") + Player2.getNickname());
		
		System.out.println("\nPlayer " + Player2.getNickname() + (Player2.shouldAttackOponent(Player1) ? " has a chance to win against the Player " : 
				" has no chance of winning against the Player: ") + Player1.getNickname());
	}
}

/*
nr prim: 11
nr perfect: 6
nr par si suma cifrelor div cu 3: 12
nr fara puteri magice: 14
System.out.println(Utils.calculateDistance(2, 2, 2, 8));
 */