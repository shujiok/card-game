import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // test default movement
        Card card = new Card();
        card.print();
    }
}

class Card{
    String cardName;
    int cardType;

    Card(){
        this.cardName = "dragon";
        this.cardType = 1;
    }
    Card(Card card){
        this.cardName = card.cardName;
        this.cardType = card.cardType;
    }

    void print(){
        var cardInfo = this.cardName + " " + this.cardType;
        System.out.println(cardInfo);
    }
}

class Field{
    //singleton pattern
}

class Deck{
    int DECK_MIN_VALUE = 40;
    List<Card> deck;
    Deck(){

    }

    boolean isValid(){
        if(deck.size()>=DECK_MIN_VALUE){
            return true;
        }
        else{
            return false;
        }
    }

    Card TakeTopCard() throws NoCardException{
        if(deck.isEmpty()){ throw new NoCardException(); }

        var topCard = deck.remove(0);
        return new Card(topCard);
    }
}

class NoCardException extends Exception{

}

class Hand{
    List<Card> cards;
    Hand(List<Card> cards){
        this.cards = new ArrayList<Card>();
        for (Card card : cards) {
            this.cards.add(card);
        }
    }
    Hand(Hand hand){
        this.cards = new ArrayList<Card>();
        for (Card card : hand.cards) {
            this.cards.add(card);
        }
    }

    boolean Add(Card card){
        return cards.add(card);
    }
}

class Turn{
    TurnDuelist duelist;
    
}

class Duelist{
    Hand hand;
    Deck deck;
    int lifePoint;
    void draw(){
        try
        {
            var drawCard = deck.TakeTopCard();
            hand.Add(drawCard);
        }
        catch(NoCardException nc)
        {
            // defeat of duelist trying to draw
        }
        
        
    }
}

class TurnDuelist{
    Duelist turnDuelist;
}

class StandByPhase{
    TurnDuelist duelist;
    StandByPhase(TurnDuelist duelist){

    }
    // void draw(){

    // }
}

class Duel{
    // two decks,
    Field field;
    Deck deckDuelist1;
    Deck deckDuelist2;
    Duelist duelist1;
    Duelist duelist2;
    Duel(Field field, Deck deck1, Deck deck2){
        this.field = field;
        this.deckDuelist1 = deck1;
        this.deckDuelist2 = deck2;
    }

    void start(){

    }
}
