package Proiect;

public class Utils {

	public static boolean perfectNumber(int Number) {
		int i, Sum = 0;

		for(i = 1 ; i < Number ; i++) {
			if(Number % i == 0)  {
				Sum = Sum + i;
			}
		}
		if (Sum == Number) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean primeNumber(int Number) {
		boolean isPrime = true;

		for(int i = 2; i <= Number/2; i++) {
			int  temp = Number%i;
			if(temp == 0) {
				isPrime = false;
			}
		}
		if(isPrime) {
			return true;
		} else {
			return false;
		}
	}

	public static int sumOfNumbers(int Number) {

		int total = 0;

		while (Number != 0) {
			int lastDigit  = Number % 10;
			total += lastDigit;
			Number /= 10;
		}
		return total;
	}

	public static boolean isAllowedWeapon(String weapon) {
		return weapon.equals("knife") ||  weapon.equals("sniper")  || weapon.equals("kalashnikov");
	}

	public static int weaponPrice(String weapon) {
		int price = 0;

		switch (weapon) {
		case "knife": {
			price = 1000;
			break;
		}
		case "sniper": {
			price = 10000;
			break;
		}
		case "kalashnikov": {
			price = 20000;
			break;
		}
		} 
		return price;
	} 

	public static double calculateDistance(double x1, double y1, double x2, double y2) {
		double expr = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
		if (expr > 0) {
			return Math.sqrt(expr);
		}
		return 0;
	}

	public static double winProbability(PlayerStatus player) {
		return (3 * player.getHealth() + player.getScore() / 1000) / 4;
	}

	public static boolean compareRangeDuel(String weapon1, String weapon2) {
		boolean result = false;

		/* 
		cine are cutit pierde daca adversarul are arma
		in acest scenariu weapon1 != weapon2
		castiga cine are sniper sau daca oponentul nu are arma
		 */

		//compar existenta celei mai slabe arme pentru fiecare player
		if(weapon1.equals("knife") && isAllowedWeapon(weapon2)) {
			result = false;
		} else if (isAllowedWeapon(weapon1) && !isAllowedWeapon(weapon2)) {
			//test cine are arma
			return true;
		}

		if(weapon2.equals("knife") && isAllowedWeapon(weapon1)) {
			result = true;
		} else if (isAllowedWeapon(weapon2) && !isAllowedWeapon(weapon1)) {
			//test cine are arma
			return false;
		}
		//daca am ajuns aici verific cine are cea mai puternica arma si actualizez result-ul
		if(weapon1.equals("sniper")) {
			result = true;
		}

		if(weapon2.equals("sniper")) {
			result = false;
		}
		return result;
	} 

	public static boolean compareMeleeDuel(String weapon1, String weapon2) {
		boolean result = false;

		/* 
		cine are cutit pierde daca adversarul are arma
		in acest scenariu weapon1 != weapon2
		castiga cine are kalashnikov sau daca oponentul nu are arma
		 */

		//compar existenta celei mai slabe arme pentru fiecare player
		if(weapon1.equals("knife") && isAllowedWeapon(weapon2)) {
			result = false;
		} else if (isAllowedWeapon(weapon1) && !isAllowedWeapon(weapon2)) {
			//test cine are arma
			return true;
		}

		if(weapon2.equals("knife") && isAllowedWeapon(weapon1)) {
			result = true;
		} else if (isAllowedWeapon(weapon2) && !isAllowedWeapon(weapon1)) {
			//test cine are arma
			return false;
		}
		//daca am ajuns aici verific cine are cea mai puternica arma si actualizez result-ul
		if(weapon1.equals("kalashnikov")) {
			result = true;
		}

		if(weapon2.equals("kalashnikov")) {
			result = false;
		}
		return result;
	}
}
