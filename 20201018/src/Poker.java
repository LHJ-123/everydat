import java.util.*;

import static java.util.Collections.swap;

class Card {
    String value;
    String type;

    public Card(String value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "["+this.value+","+this.type+"]";
    }
}
public class Poker {
    public static List<Card> buyPokes() {
        String[] s = {"♥","♠","♣","♦"};
        List<Card> cards = new ArrayList<>();
        for (int i = 0;i<s.length;i++) {
            for (int j = 2;j<=10;j++) {
                Card card = new Card(String.valueOf(j),s[i]);
                cards.add(card);
            }
            cards.add(new Card("J",s[i]));
            cards.add(new Card("Q",s[i]));
            cards.add(new Card("K",s[i]));
            cards.add(new Card("A",s[i]));

        }
        return cards;
    }
    public static void shuffle(List<Card> cards) {
        Random random = new Random();
        for (int i = cards.size()-1;i>0;i--) {
            int r = random.nextInt(i);
            swap(cards,i,r);
        }
    }

    public static void main(String[] args) {
        List<Card> cards = buyPokes();
        shuffle(cards);
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for (int i = 0;i<5;i++) {
            for (int j = 0;j<players.size();j++) {
                List<Card> cards1 = players.get(j);
                Card card = cards.remove(0);
                cards1.add(card);
            }
        }
        System.out.println("玩家1的手牌: ");
        System.out.println(players.get(0));
        System.out.println("玩家2的手牌: ");
        System.out.println(players.get(1));
        System.out.println("玩家3的手牌: ");
        System.out.println(players.get(2));
    }
}
