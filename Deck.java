package UnoGame;

public class Deck {

private Card[] cards; 

private int cardsInDeck;

public Deck() {

cards = new Card[108];

}

public void reset()

{

Card.Color[] colors = Card.Color.values();

cardsInDeck = 0;

for(int i = 0; i < colors.length-1; i++)

{

Card.Color color = colors[i];

cards[cardsInDeck++] = new Card(color, Card.Value.getValue(0));

for(int j = 1; j < 10; j++)

{

cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j));

cards[cardsInDeck++] = new Card(color, Card.Value.getValue(j));

}

Card.Value[] values = new Card.Value[]{Card.Value.DrawTwo,Card.Value.Skip,Card.Value.Reverse};

for(Card.Value value : values)

{

cards[cardsInDeck++] = new Card(color, value);

cards[cardsInDeck++] = new Card(color, value);

}

}

Card.Value[] values = new Card.Value[]{Card.Value.Wild, Card.Value.Wild_Four};

for(Card.Value value : values)

{

for(int i = 0; i < 4; i++)

{

cards[cardsInDeck++] = new Card(Card.Color.Wild, value);

}

}

}

public Card drawCard() { 



return null;

}

}
