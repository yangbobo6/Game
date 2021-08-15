package game.memory.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.memory.cards.old.CardOld;

public class TableOld {

	public static final int TOTAL_NUMBER_OF_CARDS = 10;
	
	private List<CardOld> cards;

	public TableOld() {
		super();
		cards  = new ArrayList<CardOld>(TOTAL_NUMBER_OF_CARDS);

		for (int i = 0; i < (TOTAL_NUMBER_OF_CARDS/2); i++) {
			String drawing = drawingRelated(i);
			CardOld c1 = new CardOld(drawing);
			CardOld c2 = new CardOld(drawing);
			cards.add(c1);
			cards.add(c2);
		}
		Collections.shuffle(cards);
	}
	
	public void turnACard(int position) {
		CardOld card = cards.get(position);
		card.turn();
	}
	
	/**
	 * requires two visible cards on table
	 * @return if the two cards match
	 */
	public boolean checkPair() {
		//First, we have to find the two visible cards
		CardOld c1=null;			CardOld c2=null;
		int i=0;
		while(c2==null) { // && c1==null
			CardOld currentCard = cards.get(i);
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
		while (theEnd && i<cards.size()) {
			theEnd=cards.get(i++)==null; //first we check, after we increment i.
		}		
		return theEnd;
	}
	
	public CardOld remove(int position) {
		CardOld removedCard = cards.get(position);
		cards.set(position, null);
		return removedCard;
	}

	private String drawingRelated(int i) {
		String drawing="";
		switch (i) {
		case 0: drawing="HOUSE";
		break;
		case 1: drawing=" DOG ";
		break;
		case 2: drawing=" CAT ";
		break;
		case 3: drawing="*STAR";
		break;
		case 4: drawing="MoOoN";
		break;
		case 5: drawing="SEVEN";
		break;
		case 6: drawing="PLANE";
		break;
		case 7: drawing="WOMAN";
		break;
		default:
			drawing="XXXXX";
			break;
		}
		return drawing;
	}

	@Override
	public String toString() {
		String stringTable="";
		
		for (int i = 0; i < cards.size(); i++) {
			CardOld card = cards.get(i);
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

	public CardOld get(int i) {
		return cards.get(i);
	}

	


}
