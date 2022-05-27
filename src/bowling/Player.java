package bowling;

public class Player {
    String name;
    int[] point = new int[10];
    int[] first = new int[10];
    int[] second = new int[10];
    int third;
    int sum;

    int control;
    int luck;

    boolean[] strike = new boolean[10];
    boolean[] spare = new boolean[10];

    public Player(String name, int control, int luck){
        this.name = name;
        this.control = control;
        this.luck = luck;
    }

    /*
    public int play(){
        int total = 0;
        double n = (double) (new java.util.Random().nextInt(luck))/150;

        total = (int)(control * 0.2 * n);
        if(total>10){
            total = 10;
        }
        return total;
    }*/
}
