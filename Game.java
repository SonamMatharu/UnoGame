package UnoGame;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Hand {

private int currentPlayer;
private String[] playerIds;

private Deck deck;
private ArrayList<ArrayList<Card>> plyersHand; 
private ArrayList<Card> stockpile;

private Card.Color validColor;
private Card.Value validValue;

boolean gameDirection;

public Game(String[] pids) {
deck = new Deck();
deck.shuffle();
stockpile = new ArrayList<Card>();

playerIds = pids;
currentPlayer = 0;
gameDirection = false;

plyersHand = new ArrayList<ArrayList<Card>>();

for (int i = 0; i < pids.length; i++) {
ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
plyersHand.add(hand);
}
}
public void start(Game game) {
Card card = deck.drawCard();
validColor = card.getColor(); 
validValue = card.getValue(); 

if (card.getValue() == Card.Value.Wild) {
start(game);
}

if (card.getValue() == Card.Value.Wild_Four || card.getValue() == Card.Value.DrawTwo) {
start(game);
}

if (card.getValue() == Card.Value.Skip) {
JLabel message = new JLabel(playerIds[currentPlayer] + "was skipped!");
message.setFont(new Font("Arial", Font.BOLD, 48));
JOptionPane.showConfirmDialog(null, message); // this will print msg

if (gameDirection == false) {
currentPlayer = (currentPlayer + 1) % playerIds.length; //players order gets + 1 or - 1 skipping players
} else if (gameDirection == true) {
currentPlayer = (currentPlayer - 1) % playerIds.length;
if (currentPlayer == -1) {
currentPlayer = playerIds.length - 1;

}

}
}
if (card.getValue() == Card.Value.Reverse) {
JLabel message = new JLabel(playerIds[currentPlayer] + "The game direction changed!");
message.setFont(new Font("Arial", Font.BOLD, 48));
JOptionPane.showConfirmDialog(null, message);

}

}
}
