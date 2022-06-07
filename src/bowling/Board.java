package bowling;

public class Board {
    public Board() {
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("    |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 | 10 |");
    }

    public void board(Player p) {
        p.sum = 0;
        System.out.print("     ");
        for(int i = 0; i < 10; i++) {
            System.out.print(p.first[i] + "  " + p.second[i] + "|");
        }
        System.out.println("");
        System.out.print(p.name);
        System.out.print("    ");
        for(int i = 0; i < 10; i++){
            p.sum += p.point[i];
            System.out.print("");
            if(p.sum < 100){
                System.out.print(" ");
                if(p.sum < 10){
                    System.out.print(" ");
                }
            }
            System.out.print(p.sum + " |");
        }
        System.out.print("    total:" + p.sum);
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}
