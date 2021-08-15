package game.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.memory.cards.MemoryCard;

public class MemoryGame {
	
	private Table table;
	private List<Player> players;	

	public MemoryGame(Table table, List<Player> players) {
		super();		this.table = table;		this.players = players;
	}

	private void playTheGame() {
		//输入一个数字  开始游戏
		Scanner sc = new Scanner(System.in);
		//create a loop until the end of the game
		int currentPlayer=0;
		Player player;
		//桌子上没有卡牌时，游戏结束
		while (!table.endOfGame()) {
		// -> ask for two cards
			//list的方法  取当前玩家的
			player = players.get(currentPlayer);
			int indiceCard1=askForACard(sc,player.getName(),1);
			MemoryCard card1 = table.get(indiceCard1);
			card1.turn();
			int indiceCard2=askForACard(sc,player.getName(),2);
			MemoryCard card2 = table.get(indiceCard2);
			card2.turn();
			showAndWait(sc);
		// -> check if they match, finally we do not need checkPair
			if (card1.match(card2)) {
				player.earnCard(table.remove(indiceCard1));
				player.earnCard(table.remove(indiceCard2));
			}
			else {
				// change the current player
				System.out.println("change the player");
				currentPlayer++;
				currentPlayer=(currentPlayer%players.size());
				// hide cards
				card1.turn();
				card2.turn();
			}
		}
		System.out.println(players);
		sc.close();
	}

	private void showAndWait(Scanner sc) {
		System.out.println(table);
		System.out.println("press a key and enter...");
		sc.next();
	}

	//询问选择几号牌
	private int askForACard(Scanner sc, String name, int indice) {
		//打印桌子上的卡牌
		System.out.println(table);
		boolean validChoice=false;
		int i=0;
		while (!validChoice) {
			System.out.println(name+", give the position of the card "+indice+" to show");
			i=sc.nextInt();
			//条件  输入的值在0 -19  桌子上有卡牌   并且卡牌不可见时候
			validChoice= (i>=0 && i<table.getNumberOfCards()
					&& table.get(i)!=null
					&& !table.get(i).isVisible() );  
		}		
		return i;
	}

	public static void main(String[] args) {
		//define the number and names of players
		//Table table=new Table(MemoryCard.DRAWING);
		//定义桌子上 有card32类型   20张牌
		Table table=new Table(MemoryCard.CARD32,20);
		//玩家有两个
		List<Player> players=new ArrayList<Player>(2);
		//steve和bob两个角色
		players.add(new Player("Steve"));
		players.add(new Player("Bob"));
		
		MemoryGame game = new MemoryGame(table, players);
		game.playTheGame();

		/*
		Table table = new Table();
		System.out.println(table);
		*/
		
		/*
		Card card = new Card("HOUSE");
		System.out.println(card);
		card.turn();
		System.out.println(card);
		Card card2 = new Card("HOUSE");
		Card card3 = new Card(" DOG ");
		System.out.println("two houses : "+card.match(card2));
		System.out.println("dog and house : "+card.match(card3));
		 */
		
	}

}
