package game.memory.cards.old;

import game.memory.cards.Drawing;

public class CardAlone {
	
	/**
	 * private Attributes
	 */
	private final Drawing drawing;
	private final Drawing back=Drawing.BACK;
	private boolean visible=false;
	
	/**
	 * public getters (and setters)
	 * @return the attribute visible
	 */
	public boolean isVisible() {
		return this.visible;
	}

	public CardAlone(Drawing drawing) {
		super();
		this.drawing = drawing;
	}
	
	public boolean match(CardAlone otherCard) {
		return this.drawing.equals(otherCard.drawing);
	}
	
	public void turn() {
		this.visible = !this.visible;
	}

	@Override
	public String toString() {
		String string="";
		if (visible) {
			string=drawing.toString();
		}
		else {
			string=back.toString();
		}
		return string;
	}

	
	
	
}
