package game.memory.cards;

public enum MyColor {
	SPADE("S", "black"), HEART("H","red"),CLUB("C", "black"), DIAMOND("D","red");
	
	private static final MyColor[] array = MyColor.values();
	private String stringValue;
	private String realColor;
	
	private MyColor(String stringValue, String realColor) {
		this.stringValue = stringValue;
		this.realColor=realColor;
	}

	public boolean sameRealColor(MyColor other) {
		return this.realColor.equals(other.realColor);
	}
	
	public String toString() {
		return stringValue;
	}

	public static MyColor get(int i) {
		return array[i];
	}
	
	
	
}
