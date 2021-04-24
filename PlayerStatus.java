package Proiect;

public class PlayerStatus {

	private String nickname;
	private int score;
	private int lives;
	private int health = 100;
	private String weaponInHand;
	private double positionX;
	private double positionY;
	private String gameName = "Counter-Strike: Global Offensive";


	public String getGameName() {
		return gameName;
	}

	void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getNickname() {
		return nickname;
	}

	private void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setHealth(int health) {
		this.health = health > 100 ? 100 : health; 
	}

	public void addHealth(int health) {
		int newHealth = this.health + health;
		setHealth(newHealth);
	}

	public int getHealth() {
		return this.health;
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}

	public void addScore(int score) {
		int newScore = this.score + score;
		setScore(newScore);
	}

	public void removeScore(int score) {
		int newScore = this.score - score;
		newScore = newScore > 0 ? newScore : 0;
		setScore(newScore);
	}


	public void initPlayer(String nickname) {
		setNickname(nickname);
	}

	public void initPlayer(String nickname, int lives) {

		setNickname(nickname);
		this.lives = lives;
	}

	public void initPlayer(String nickname, int lives, int score) {

		setNickname(nickname);
		this.lives = lives;
		setScore(score);
	}

	public void findArtifact(int artifactCode) {

		if(Utils.perfectNumber(artifactCode)) {
			addScore(5000);
			lives += 1;
			setHealth(100);
		}

		else if(Utils.primeNumber(artifactCode)) {
			addScore(1000);
			lives += 2;
			addHealth(25);
		}

		else if ((artifactCode % 2 == 0) && (Utils.sumOfNumbers(artifactCode) % 3 == 0)) {
			removeScore(3000);
			removeHealth(25);
		}

		else {
			addScore(artifactCode);
		}
	}

	private void endGame(int damage) {
		System.out.println("\n\tRecived damage: " +damage);
		System.err.println("\t ~~ GAME OVER ~~");
	}

	private void  removeHealth(int damage) {
		health -= damage;
		if (health < 1 && lives > 1) {
			lives -= 1;
			setHealth(100);
		} else if (health < 1) {
			lives -= 1;
			endGame(damage);
		}
	}

	public String getWeaponInHand() {
		return weaponInHand != null ? weaponInHand : "";
	}

	public boolean setWeaponInHand(String weaponInHand) {
		if (Utils.isAllowedWeapon(weaponInHand)) {
			int weaponPrice = Utils.weaponPrice(weaponInHand);
			if (getScore() > weaponPrice) {
				this.weaponInHand = weaponInHand;
				removeScore(weaponPrice);;
				return true;
			}
		}
		return false;
	} 

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public void movePlayerTo(double positionX, double positionY) {
		setPositionX(positionX);
		setPositionY(positionY);
	}

	private boolean duel(PlayerStatus player1, PlayerStatus player2) { 
		//intorc rezultatul din perspectiva player1 -> true daca player1 castiga duelul impotriva player2
		if (player1.getWeaponInHand().equals(player2.getWeaponInHand())) {
			double myProbability = Utils.winProbability(player1);
			double oponentProbability = Utils.winProbability(player2);
			return myProbability > oponentProbability;
		} else {
			//aici am arme diferite
			double distance = Utils.calculateDistance(player1.getPositionX(), player1.getPositionY(), player2.getPositionX(), player2.getPositionY());
			if (distance > 1000) {
				return Utils.compareRangeDuel(player1.getWeaponInHand(), player2.getWeaponInHand());
			} else {
				return Utils.compareMeleeDuel(player1.getWeaponInHand(), player2.getWeaponInHand());
			}
		}
	}

	public boolean shouldAttackOponent(PlayerStatus oponent) {
		return duel(this, oponent);
	}

	public void showPlayerStatus() {
		System.out.println("\nPlayer " + this.nickname + " profile: "
				+ "\n\n\t- Nickname: " + nickname
				+ "\n\t- Score: " + score
				+ "\n\t- Lives: " + lives
				+ "\n\t- Health: " + health
				+ "\n\t- Weapon: " + weaponInHand
				+ "\n\t- Location: " + this.positionX + ", " + this.positionY
				);
	}
}
