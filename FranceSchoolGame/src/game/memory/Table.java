package game.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.memory.cards.Card32;
import game.memory.cards.Drawing;
import game.memory.cards.DrawingCard;
import game.memory.cards.MemoryCard;

public class Table {

	//默认????
	public static final int DEFAULT_NUMBER_OF_CARDS = 10;

	//存储卡牌的集合
	private List<MemoryCard> cards;
	//卡牌的类型
	private final int type;
	//卡牌的数量
	private final int numberOfCards;

	//有参构造方法
	public Table(int type) {
		this(type, DEFAULT_NUMBER_OF_CARDS);
	}
	//有参构造方法
	public Table(int type, int numberOfCards) {
		super();
		this.type=type;	
		this.numberOfCards=numberOfCards;
		//创建 MemoryCard类型卡牌数组
		cards  = new ArrayList<MemoryCard>(numberOfCards);
		for (int i = 0; i < (numberOfCards/2); i++) {			
			create2Cards(i);
		}
		Collections.shuffle(cards);
	}

	//创建2张卡片方法
	private void create2Cards(int i) {
		//创建什么类型
		switch (type) {
		case MemoryCard.DRAWING:
			//引用枚举类型
			Drawing drawing = Drawing.get(i);
			//创建卡牌c1和c2
			MemoryCard c1 = new DrawingCard(drawing);
			MemoryCard c2 = new DrawingCard(drawing);
			//添加卡牌
			cards.add(c1);
			cards.add(c2);
			break;
		case MemoryCard.CARD32:  //添加卡片值和颜色
			int value = i/4;
			int color = i%2;
			c1 = new Card32(value, color);
			c2 = new Card32(value, color+2);
			cards.add(c1);
			cards.add(c2);
			break;

		default:
			//impossible
			break;
		}
		
	}
	
	public void turnACard(int position) {
		MemoryCard card = cards.get(position);
		card.turn();
	}
	
	/**
	 * requires two visible cards on table
	 * @return if the two cards match      查看是否匹配
	 */
	public boolean checkPair() {
		//First, we have to find the two visible cards
		MemoryCard c1=null;			MemoryCard c2=null;
		int i=0;
		while(c2==null) { // && c1==null
			MemoryCard currentCard = cards.get(i);
			//传来c1和c2   比较两个值是否相等
			if (currentCard.isVisible()) {
				// we found one visible card
				if (c1==null)	{	c1=currentCard;	}
				else			{	c2=currentCard;	}
			}				
			i++;
		}
		return c1.match(c2);
	}
	
	public boolean endOfGame() {
		boolean theEnd=true; // check if each place is equal to null
		int i=0; // browse the list "cards" until the end.		
		// we leave the loop when a place is not null or at the end of the list.
		while (theEnd && i<cards.size()) {     //遍历全部，如果都为空，则  theEnd为ture
			theEnd=cards.get(i++)==null; //first we check, after we increment i.
		}		
		return theEnd;
	}

	//移除桌子上的的卡片
	public MemoryCard remove(int position) {
		MemoryCard removedCard = cards.get(position);
		cards.set(position, null);
		return removedCard;
	}

	

	@Override
	public String toString() {
		String stringTable="";
		
		for (int i = 0; i < cards.size(); i++) {
			MemoryCard card = cards.get(i);
			if (card!=null) {
			stringTable += i+" : "+card.toString() + "    ";
			}
			else {
				stringTable+="             ";
			}
			if (i%4==3) {
				stringTable+="\n";
			}
		}
		return stringTable+"\n";
	}

	//获取卡牌的内容
	public MemoryCard get(int i) {
		return cards.get(i);
	}

	//查看卡牌的数量
	public int getNumberOfCards() {
		return numberOfCards;
	}

	


}
