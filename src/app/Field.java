package app;

/**
 * Field
 */
public class Field {

    private Player player;
    private int location;

    public Field(int location) {
        this.location = location;
	}

	public boolean setPlayer(Player player) {
        if(isSet()) return false;
        this.player = player;
        return true;
    }

    public Player getPlayer() {
        return player;
    }

    public String toString() {
        return isSet() ? player.getPawn() : "" + location ;
    }

    public boolean isSet() {
        return player != null;
    }
}