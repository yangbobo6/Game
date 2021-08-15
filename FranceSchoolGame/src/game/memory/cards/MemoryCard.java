package game.memory.cards;

public abstract class MemoryCard extends Card {

	//创建卡牌的类型    具体是什么类型
	public static final int DRAWING=0;
	public static final int CARD32=1;

	//卡片之间相互比较
	public abstract boolean match(MemoryCard otherCard);
	
}
