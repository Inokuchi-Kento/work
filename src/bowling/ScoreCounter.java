package bowling;

public class ScoreCounter {
    int down;

    public void score(int flame, Player p){
        int pin = 10;
        /* 1回目の投球 */
        //down = p.play();
        new java.util.Random().nextInt(11);
        p.first[flame] = down;

        if(flame > 0 && (p.strike[flame-1] == true || p.spare[flame - 1] == true)){ //前回がスペアorストライク
            p.point[flame - 1] += down;
        }
        pin -= down;//1回目の投球終了後のピンの残り本数

        /* ストライク以外の場合は2回目の投球 */
        if(pin != 0){
            down = new java.util.Random().nextInt(pin+1);
            p.second[flame] = down;

            if(flame > 0 && p.strike[flame - 1] == true){ //前フレームがストライクだった場合
                p.point[flame - 1] += down;
            }
            pin -= down; //現在の残り本数
            if(pin == 0) { //スペア判定
                p.spare[flame] = true;
            }
        }else{ //ストライクの場合
            if(flame > 1 && p.strike[flame - 1] == true && p.strike[flame - 2] == true){ //前回と前々回がストライクだった場合
                p.point[flame - 2] += down;
            }
            p.strike[flame] = true;
        }
        p.point[flame] += 10 - pin; //合計ポイントに加算
        lastFlame(flame, pin, p); //10フレーム目の処理
    }

    /* 10フレーム目の処理 */
    public void lastFlame(int flame, int pin, Player p){
        if(flame == 9 && pin == 0){
            pin = 10;
            //2投目
            down = new java.util.Random().nextInt(pin+1);
            pin -= down;

            /* 10フレーム目がスペアなので3投目 */
            if(p.spare[flame] == true){
                p.point[flame] += 10 - pin;
            }
            if (p.strike[flame] == true){ //一頭目で10の場合
                //2投目
                if(p.strike[flame - 1] == true){
                    p.second[flame] = down;
                    p.point[flame - 1] += down; //9フレーム目がストライクだった場合
                }
                p.point[flame] += down;
                if(pin == 0){ //2投目もストライク
                    down = new java.util.Random().nextInt(11);
                    p.third = down;
                    p.point[flame] += down ;
                }
            }
        }
    }
}
