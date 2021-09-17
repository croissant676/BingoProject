public class BingoTile {

	private int value;
	private boolean crossedOff;
	
	public BingoTile(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean isCrossedOff() {
		return crossedOff;
	}
	
	public void setCrossedOff(boolean crossedOff) {
		this.crossedOff = crossedOff;
	}
	
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BingoTile bingoTile)) return false;
		if (value != bingoTile.value) return false;
		return crossedOff == bingoTile.crossedOff;
	}
	
	
	public int hashCode() {
		int result = value;
		result = 31 * result + (crossedOff ? 1 : 0);
		return result;
	}
	
	
	public String toString() {
		return "BingoTile{" +
				"value=" + value +
				", crossedOff=" + crossedOff +
				'}';
	}
}
