package bowling;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ScoreCounter score = new ScoreCounter();
        Player p1 = new Player("A", 70, 100);
        Player p2 = new Player("B", 95, 83);

        List<Player> players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);

        //1~10回までのスコアを計算
        for(int flame = 0; flame < 10; flame++){
            for(Player p: players){
                score.score(flame, p); //各回の点数を計算
            }
        }

        //スコアの表示
        //表示されるのはリザルトのみ
        //プレイヤーが3人以上の場合を想定していない
        Board board = new Board();
        for(Player p: players) {
            board.board(p);
        }
        if(p1.sum == Math.max(p1.sum, p2.sum)) {
            System.out.println(p1.name + "の勝ち");
        }else{
            System.out.println(p2.name + "の勝ち");
        }
        System.out.println("ゲーム終了");
    }
}

