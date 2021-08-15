package game.memory.cards.old;

public class CardOld {
	
	/**
	 * private Attributes
	 */
	private final String drawing;
	private final String back="*****";
	private boolean visible=false;
	
	/**
	 * public getters (and setters)
	 * @return the attribute visible
	 */
	public boolean isVisible() {
		return this.visible;
	}

	public CardOld(String drawing) {
		super();
		this.drawing = drawing;
	}
	
	public boolean match(CardOld otherCard) {
		return this.drawing.equals(otherCard.drawing);
	}
	
	public void turn() {
		this.visible = !this.visible;
	}

	@Override
	public String toString() {
		String string="";
		if (visible) {
			string=drawing;
		}
		else {
			string=back;
		}
		return string;
	}	
	
}
