import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    public String suit;
    public String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "(" + suit + rank + ")";
        //return String.format("(%s%s)",suit,rank);
    }
}

public class Poker {
//创建一副牌
    public static List<Card> buyPoker() {
        String[] suits = {"♠","♥","♣","♦"};
        List<Card> poker = new ArrayList<>();
        for(int i = 0;i<4;i++) {
            for(int j =2;j<=10;j++) {
                Card card = new Card(suits[i],String.valueOf(j));
                poker.add(card);
            }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));

        }
        return poker;

    }
    public static void shuffle(List<Card> poker) {
        Random random = new Random();
        for(int i = poker.size()-1;i>0;i--) {
            //产生一个[0,i)的随机数
            int r = random.nextInt(i);
            swap(poker,i,r);

        }
    }
    private static void swap(List<Card> poker,int i,int j) {
        Card tmp = poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }

    public static void main(String[] args) {
        List<Card> poker = buyPoker();
        //洗牌
        shuffle(poker);
        System.out.println(poker);
        //发牌，发给3个人，每人发5张
       List<List<Card>>  players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for(int cardIndex = 0;cardIndex < 5;cardIndex++) {
            for(int playerIndex = 0;playerIndex<3;playerIndex++) {
                //获取到这个玩家
                List<Card> player = players.get(playerIndex);
                //把poker最前面的牌发给玩家
                Card topCard = poker.remove(0);
                player.add(topCard);
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
