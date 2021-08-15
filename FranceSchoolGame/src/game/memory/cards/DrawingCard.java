package game.memory.cards;
//样式
public class DrawingCard extends MemoryCard{
	
	/**
	 * private Attribute
	 */
	//给卡片赋予样式
	private final Drawing drawing;	

	public DrawingCard(Drawing drawing) {
		super();
		this.drawing = drawing;
	}
	//卡片的花式比较
	@Override
	public boolean match(MemoryCard otherCard) {
		return this.drawing.equals(((DrawingCard)otherCard).drawing);
	}

	//取正面
	@Override
	public String getFace() {
		return drawing.toString();
	}
	
	
	
	
}
