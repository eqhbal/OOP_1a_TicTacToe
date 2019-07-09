package app;

/**
 * Player
 */
public class Player {

    private String name;
    private String pawn;
    private int score = 0;
    
    public int getScore() {
        return score;
    }

    public String getPawn() {
        return pawn;
    }

	public String getName() {
		return name;
    }

    public Player(String name, String pawn) {
        this.name = name;
        this.pawn = pawn;
    }
    
    public void Win() {
        System.out.println(name + " has won!");
        score = score + 1;
    }
    
    public String toString() {
        return name + " score : " + score;
    }
}