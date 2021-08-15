package game.memory.cards;
//值和颜色
public class Card32 extends MemoryCard {

	//卡片的值
	private final int value;
	//卡片的颜色
	private final MyColor color; 
	//卡片的构造方法
	public Card32(int value, int color) {
		super();
		//为什么加7
		this.value = value+7;
		this.color = MyColor.get(color);
	}

	//获取卡片正面方法
	@Override
	public String getFace() {
		return "|"+value+"."+color.toString()+"|";
	}

	//卡片的比较   是否相等
	@Override
	public boolean match(MemoryCard otherCard) {
		//向下转型  ???
		Card32 card2 = (Card32) otherCard;
		//this表示当前这个card    值相等&&颜色相等
		return this.value==card2.value && this.sameRealColor(card2);
	}
	//判断颜色是否相等
	private boolean sameRealColor(Card32 card2) {
		return this.color.sameRealColor(card2.color);
	}

}
