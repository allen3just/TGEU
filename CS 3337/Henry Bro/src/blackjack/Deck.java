package blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Deck {
	private Card[] deck = new Card[52];
	
	private int cardCounter = 52;
	//this keeps track of the position of the cards in the deck
	private int cardPosition = 0;
	
	
	public Deck(){
		int value = 2;
		String suit;
		
		for(int i=0;i<52;i++){
			//sets the suits
			if(i % 4 == 0)
				suit = " of Diamonds";
			else if((i % 4) - 1 == 0)
				suit = " of Clubs";
			else if((i % 4) - 2 == 0)
				suit = " of Hearts";
			else
				suit = " of Spades";
			
			//initializes 4 of each card
			if(i % 4 == 0 && i != 0)
				value++;
			
			deck[i] = new Card(value, suit);
		}
	}
	
	
	
	public Card[] getDeck() {
		return deck;
	}



	public void setDeck(Card[] deck) {
		this.deck = deck;
	}



	public int getCardCounter() {
		return cardCounter;
	}


	public void setCardCounter(int cardCounter) {
		this.cardCounter = cardCounter;
	}


	public int getCardPosition() {
		return cardPosition;
	}

	public void setCardPosition(int cardPosition) {
		this.cardPosition = cardPosition;
	}



	//shuffles the deck randomly
	public void shuffleDeck(){
		List<Card> list = Arrays.asList(deck);
		Collections.shuffle(list);
		
		cardCounter = 52;
		cardPosition = 0;
	}
	
	//deal cards. Returns 0 value card suggesting that there are no cards left
	public Card deal(){
		if(cardPosition < 52){
			cardCounter--;
			return deck[cardPosition++];
		}else
			return new Card(0,"0");
			
	}
	
	public Card getCard(){
		return deck[cardPosition - 1];
	}
	
}
