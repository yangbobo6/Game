package game.memory;

import java.util.ArrayList;
import java.util.List;

import game.memory.cards.MemoryCard;

//玩家的类   定义玩家
public class Player {
	
	private String name;
	private List<MemoryCard> cardsWon;

	//一个玩家可以那多张牌   构造方法中加入????????  每个人都有一些卡牌
	public Player(String name) {
		super();
		this.name = name;
		this.cardsWon = new ArrayList<MemoryCard>();
	}

	//得分情况，几张牌就是多少分，每个人手上有多少牌
	public int getScore() {
		return cardsWon.size();
	}

	//增加卡牌
	public void earnCard(MemoryCard card) {
		cardsWon.add(card);
	}

	//名字
	public String getName() {
		return name;
	}

	//打印玩家的名字  得分情况
	@Override
	public String toString() {
		return "Player [name=" + name + ", cardsWon=" + cardsWon.size() + "]";
	}
	
	
}
