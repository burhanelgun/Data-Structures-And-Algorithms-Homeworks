package com.connect.burhan.coonectfour;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


import static com.connect.burhan.coonectfour.MyView.board;
import static com.connect.burhan.coonectfour.main.amountOfTimee;
import static com.connect.burhan.coonectfour.main.gameMode;
import static com.connect.burhan.coonectfour.main.radius;
import static com.connect.burhan.coonectfour.main.size;

/**
 * Oyunun oynanabilmesi için gerekli olan algoritmaları içeren class
 */
public class Customer extends AppCompatActivity {

    int playColumn;
    int playRow;
    private char player = 'X';
    public int livingCell = 0;
    public int win;
    public int[] xAxis;
    public int[] yAxis;
    public int counter=amountOfTimee;
    public Button newGameButton;
    public Button undoButton;
    public TextView winner;
    CountDownTimer timer;
    MediaPlayer dropAudio;
    MediaPlayer winAudio;

    public Customer(){

        xAxis = new int[size*size];
        yAxis = new int[size*size];

    }

    /**
     * Ekrana tıklanıldığında yapılması gerekenleri yapar ayrıca taş düstüğünde ses dosyasını çalıştırır ve kalan saniyeyi tutan counterı artırır
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(com.connect.burhan.coonectfour.R.layout.activity_customer);

        dropAudio= MediaPlayer.create(getApplicationContext(), com.connect.burhan.coonectfour.R.raw.dropaudio); // ses dosyaları eklenir
        winAudio= MediaPlayer.create(getApplicationContext(), com.connect.burhan.coonectfour.R.raw.win);


        MyView a = new MyView(this);
        RelativeLayout b = findViewById(com.connect.burhan.coonectfour.R.id.relativeLayout);
        b.addView(a);



        final TextView label = (TextView) findViewById(com.connect.burhan.coonectfour.R.id.textView3);
        timer = new CountDownTimer(600000, 1000) {
            public void onTick(long millisUntilFinished) {
                if(amountOfTimee!=10000) {
                    label.setText(String.valueOf(counter));

                    if (counter < 6) {
                        label.setTextColor(Color.RED);
                        label.setTextSize(40);

                    } else {
                        label.setTextColor(Color.BLACK);
                        label.setTextSize(30);
                    }
                    counter--;
                    if (counter == -1) {
                        Random random = new Random();
                        int number = random.nextInt(size);
                        playColumn = number;
                        counter = amountOfTimee;
                        play();
                    }
                }
            }

            public void onFinish() {

            }
        }.start();


        newGameButton=(Button)findViewById(com.connect.burhan.coonectfour.R.id.newGameButton);

        undoButton=(Button)findViewById(com.connect.burhan.coonectfour.R.id.undoButton);

        newGameButton.setVisibility(View.GONE);


        winner=(TextView)findViewById(com.connect.burhan.coonectfour.R.id.winner);

        winner.setVisibility(View.GONE);


        a.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {


                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {    //ekrana tıklanılan koordinata göre oyun oynatılır
                    float mX = motionEvent.getX();

                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            if (board[0][j].getterCellType() == '.') {
                                if (mX > board[i][j].getterxPos() - radius && mX < board[i][j].getterxPos() + radius) {
                                    playColumn = board[i][j].getterColumn();
                                    play();



                                    if (counter > 0) {
                                        counter = amountOfTimee;
                                    }

                                    return true;

                                }
                            }
                        }
                    }
                    return true;
                }
                return true;

            }

        });

    }

    /**
     * oyunu oynatan methoddur.sıra değşimi ve taş atımı yapar
     */
    public void play(){
        if (win != 1 && win != 2 && win != 3) {
            if (gameMode == 1) {  // boarda taşları atmak için kullanılır


                setBoard(player);



                int a = controlfour(player, playRow, playColumn); // 4 leme durumu yada  tahtanın dolması durumu varsa win değişkeni değiştirilir
                int c = emptyMapControl();
                if (c == 0) {
                    win = 3;
                    winner.setVisibility(View.VISIBLE);
                    winner.setText("NO WINNER");
                    winner.setTextColor(Color.BLACK);
                    timer.cancel();
                    newGameButton.setVisibility(View.VISIBLE);
                    undoButton.setVisibility(View.GONE);
                    return;
                }
                if (a > 0 && a < 27) { // eğer 4 leme durmu varsa win değişkenine atama yapılır
                    lower(player, a);
                    if (player == 'X') {
                        win = 1;
                        winAudio.start();
                        winner.setVisibility(View.VISIBLE);
                        winner.setText("WINNER RED");
                        winner.setTextColor(Color.RED);
                        timer.cancel();
                    }
                    if (player == 'O') {
                        win = 2;
                        winAudio.start();
                        winner.setVisibility(View.VISIBLE);
                        winner.setText("WINNER BLUE");
                        winner.setTextColor(Color.BLUE);
                        timer.cancel();
                    }
                    newGameButton.setVisibility(View.VISIBLE);
                    undoButton.setVisibility(View.GONE);

                }

                if (player == 'X') { // kullanıcı sırası değiştirilir
                    player = 'O';
                } else if (player == 'O') {
                    player = 'X';
                }
            }

            if (gameMode == 2) {   // ikinci modda kullanıcı oynar sonra bilgisayar oynar
                setBoard('X');

                int a = controlfour('X', playRow, playColumn);
                int b = emptyMapControl();
                if (b == 0) {
                    win = 3;
                    return;
                }
                if (a > 0 && a < 27) {  // eğer  leme durmu varsa win değişkenine atama yapılır

                    lower('X', a);
                    if (player == 'X') {
                        win = 1;
                        winAudio.start();
                        winner.setVisibility(View.VISIBLE);
                        winner.setText("WINNER RED");
                        winner.setTextColor(Color.RED);
                        timer.cancel();
                    }
                    newGameButton.setVisibility(View.VISIBLE);
                    undoButton.setVisibility(View.GONE);

                }


                if (compSetBoard() == 2) { // bilgisayarın oynadığı method ve eğer 2 return ediyorsa bilgisayar kazanmış demektir
                    win = 2;
                    winner.setVisibility(View.VISIBLE);
                    winner.setText("WINNER BLUE");
                    winner.setTextColor(Color.BLUE);
                    newGameButton.setVisibility(View.VISIBLE);
                    undoButton.setVisibility(View.GONE);
                    timer.cancel();
                }
                int c = emptyMapControl();
                if (c == 0) {
                    win = 3;
                    winner.setVisibility(View.VISIBLE);
                    winner.setText("NO WINNER");
                    winner.setTextColor(Color.BLACK);
                    newGameButton.setVisibility(View.VISIBLE);
                    undoButton.setVisibility(View.GONE);
                    timer.cancel();
                    return;
                }
            }
        }
    }

    /**
     * kullacı new game butonuna bastığında çalışacak olan methoddur
     * yeni bir oyun başlar(ana menüye geri döndürür)
     * @param view
     */
    public void newGame(View view) {
        timer.cancel();
        counter=0;
        onBackPressed();
        finish();
    }

    /**
     * kullanıcı undo butonuna bastığında çalışacak olan methoddur
     * Butona basıldıkça en son yapılan hamleden itibaren bir hareket geri alır
     * @param view
     */
    public void undo(View view) {
        if(gameMode==1) {
            if (livingCell > 0) {
                livingCell--;  // her yapılan undo da livingcell 1 azalır
                board[yAxis[livingCell]][xAxis[livingCell]].setterData('.'); // ve hamle arraylerinin(xAxis, yAxis) en son elemanını kullanarak o hücrenin gameType ı * a geri çevrilir.
                yAxis[livingCell] = 0; // en son hamle yok edildiği için o hamlelere 0 atadım.
                xAxis[livingCell] = 0;
                if (player == 'X') {
                    player = 'O';
                } else if (player == 'O') {
                    player = 'X';
                }

            }
        }
    }

    /**
     * Board arka planında çalışan iki boyutlu arraye atama yapılır
     * @param player
     */

    public void setBoard(char player){


        for(int i = size-1;i>=0;i--){
            dropAudio.start();


            if(board[i][playColumn].getterCellType()=='.'){ // eğer set edilmesi istenen yer boşssa oraya set işlemi yapılır
                playRow=board[i][playColumn].getterRow();
                if(player=='X'){
                    board[i][playColumn].setterData('X');
                    xAxis[livingCell]=playColumn;
                    yAxis[livingCell]=playRow;
                    livingCell++;
                }
                if(player=='O'){
                    board[i][playColumn].setterData('O');
                    xAxis[livingCell]=playColumn;
                    yAxis[livingCell]=playRow;
                    livingCell++;
                }
                break;
            }
        }
    }

    /**
     * Bilgisayar oynar
     * @return
     */
    public int compSetBoard(){

        if(board[size -1][size/2].getterCellType()=='.'){  /* oyunun baslangicinda bilgisayar haritanin ortasinin en altta kalan uygun noktasina O koyar ve bu bir kez gerceklesir*/
            board[size -1][size/2].setterData('O');
            xAxis[livingCell]=playColumn;
            yAxis[livingCell]=playRow;
            livingCell++;

            return 0;
        }
        if( board[size -1][size/2].getterCellType()=='X' && board[size -2][size/2].getterCellType()=='.' ){
            board[size -2][size/2].setterData('O');
            xAxis[livingCell]=playColumn;
            yAxis[livingCell]=playRow;
            livingCell++;

            return 0;
        }

        //4 lü durumu varmı diye kontrol etmek için

        for(int i = 0;i<size;i++) {
            for (int j = 0; j < size; j++) {

                int a = controlfour('O', i, j);

                if (a > 0 && a < 27 && board[i][j].getterCellType() == '.') { // bilgisayar için 4 leme durmu varmı kontrolu

                    if (i + 1 < size) {
                        if ((board[i + 1][j].getterCellType() == 'X' || board[i + 1][j].getterCellType() == 'O')) {
                            board[i][j].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            playRow = i;
                            playColumn = j;
                            lower('O',a);
                            return 2;
                        }
                    }
                    if (i == size - 1) {
                        board[size - 1][j].setterData('O');
                        xAxis[livingCell]=playColumn;
                        yAxis[livingCell]=playRow;
                        livingCell++;

                        playRow = i;
                        playColumn = j;
                        lower('O',a);
                        return 2;
                    }
                }
            }
        }
        //x in 4 lemesini engelleme kontrolu

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int b =controlfour('X',i,j);

                if (b>0 && b<27 && board[i][j].getterCellType()=='.'){
                    if(i+1<size){
                        if((board[i+1][j].getterCellType()=='X' || board[i+1][j].getterCellType()=='O') ){
                            board[i][j].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            return 0;
                        }
                    }
                    if(i==size-1){
                        board[size-1][j].setterData('O');
                        xAxis[livingCell]=playColumn;
                        yAxis[livingCell]=playRow;
                        livingCell++;

                        return 0;
                    }
                }
            }
        }
        //x ikileme ve üçleme durumları
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j].getterCellType()=='O'){
                    if(i==size-1){
                        if(j+1<size){
                            if(board[size-1][j+1].getterCellType()=='.'){
                                board[size-1][j+1].setterData('O');
                                xAxis[livingCell]=playColumn;
                                yAxis[livingCell]=playRow;
                                livingCell++;

                                return 0;
                            }
                        }
                        if(j-1>-1){
                            if(board[size-1][j-1].getterCellType()=='.'){
                                board[size-1][j-1].setterData('O');
                                xAxis[livingCell]=playColumn;
                                yAxis[livingCell]=playRow;
                                livingCell++;

                                return 0;
                            }
                        }
                        if(j+1<size && size-2>-1){
                            if(board[size-2][j+1].getterCellType()=='.'){
                                board[size-2][j+1].setterData('O');
                                xAxis[livingCell]=playColumn;
                                yAxis[livingCell]=playRow;
                                livingCell++;

                                return 0;
                            }
                        }
                    }
                    if(i-1>-1){
                        if(board[i-1][j].getterCellType()=='.'){
                            board[i-1][j].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            return 0;
                        }
                    }

                    if(j+1<size && i+1>size){
                        if(board[i][j+1].getterCellType()=='.' && (board[i+1][j+1].getterCellType()=='X' || board[i+1][j+1].getterCellType()=='O')){
                            board[i][j+1].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            return 0;
                        }
                    }

                    if(j+1<size && i-1>-1){
                        if(board[i-1][j+1].getterCellType()=='.' && (board[i][j+1].getterCellType()=='X' || board[i][j+1].getterCellType()=='O')){
                            board[i-1][j+1].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            return 0;
                        }
                    }
                    if(i-1>-1 && j-1>-1){
                        if(board[i-1][j-1].getterCellType()=='.' && (board[i][j-1].getterCellType()=='X' || board[i][j-1].getterCellType()=='O')){
                            board[i-1][j-1].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            return 0;
                        }
                    }
                    if(i+1>size&& j-1>-1){
                        if(board[i][j-1].getterCellType()=='.' && (board[i+1][j-1].getterCellType()=='X' || board[i+1][j-1].getterCellType()=='O')){
                            board[i][j-1].setterData('O');
                            xAxis[livingCell]=playColumn;
                            yAxis[livingCell]=playRow;
                            livingCell++;

                            return 0;
                        }
                    }
                }
            }
        }
        // eğer yukardaki hiç bir durum oluşmadıysa bilgisayar bulduğu ilk boş ve uygun yere oynar
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i+1<size-1 ){
                    if(board[i][j].getterCellType()=='.' && (board[i+1][j].getterCellType()=='X' || board[i+1][j].getterCellType()=='O')) {
                        board[i][j].setterData('O');
                        xAxis[livingCell]=playColumn;
                        yAxis[livingCell]=playRow;
                        livingCell++;

                        return 0;
                    }
                }
                if(i==size-1){
                    board[i][j].setterData('O');
                    xAxis[livingCell]=playColumn;
                    yAxis[livingCell]=playRow;
                    livingCell++;

                    return 0;
                }
            }
        }
        return -1;
    }

    public int controlfour(char cursor,int playRo,int playCol) { // hangi dörtlünün 4 lendiğine göre return değeri değişir

        int flag=0;

        // yatay durumlar için kazanma 4 leme durumu
        if(playCol+3<size){
            if(board[playRo][playCol+1].getterCellType()==cursor && board[playRo][playCol+2].getterCellType()==cursor && board[playRo][playCol+3].getterCellType()==cursor){
                flag=1;
            }
        }
        if(playCol+2<size && playCol-1>-1){
            if(board[playRo][playCol-1].getterCellType()==cursor && board[playRo][playCol+1].getterCellType()==cursor && board[playRo][playCol+2].getterCellType()==cursor){
                flag=2;
            }
        }
        if(playCol+1<size && playCol-2>-1){
            if(board[playRo][playCol-2].getterCellType()==cursor && board[playRo][playCol-1].getterCellType()==cursor && board[playRo][playCol+1].getterCellType()==cursor){
                flag=3;
            }
        }
        if(playCol-3>-1){
            if(board[playRo][playCol-3].getterCellType()==cursor && board[playRo][playCol-2].getterCellType()==cursor && board[playRo][playCol-1].getterCellType()==cursor){
                flag=4;
            }
        }



        //dikey durumdaki kazanma 4leme durumu
        if(size>playRo+3){

            if(board[playRo+1][playCol].getterCellType()==cursor && board[playRo+2][playCol].getterCellType()==cursor && board[playRo+3][playCol].getterCellType()==cursor){
                flag=5;
            }
        }



        //çapraz kazanma durumu
        if(playRo>=3 && playCol>=3 && size-1>=playRo && size-1>=playCol ){
            if(board[playRo-3][playCol-3].getterCellType()==cursor && board[playRo-2][playCol-2].getterCellType()==cursor && board[playRo-1][playCol-1].getterCellType()==cursor){
                flag=6;
            }
        }

        if(playRo>=2 && playCol>=2 && size-2>=playRo && size-2>=playCol){
            if(board[playRo-2][playCol-2].getterCellType()==cursor && board[playRo-1][playCol-1].getterCellType()==cursor && board[playRo+1][playCol+1].getterCellType()==cursor){
                flag=7;
            }
        }

        if(playRo>=1 && playCol>=1 && size-3>=playRo && size-3>=playCol ){
            if(board[playRo-1][playCol-1].getterCellType()==cursor && board[playRo+1][playCol+1].getterCellType()==cursor && board[playRo+2][playCol+2].getterCellType()==cursor){
                flag=8;
            }
        }


        if(playRo>=0 && playCol>=0 && size-4>=playRo && size-4>=playCol ){
            if(board[playRo+1][playCol+1].getterCellType()==cursor && board[playRo+2][playCol+2].getterCellType()==cursor && board[playRo+3][playCol+3].getterCellType()==cursor){
                flag=9;
            }
        }




        //çapraz kazanma durumu
        if(playRo>=3 && playCol<=size-4 && size-1>=playRo && 0<=playCol){
            if(board[playRo-3][playCol+3].getterCellType()==cursor && board[playRo-2][playCol+2].getterCellType()==cursor && board[playRo-1][playCol+1].getterCellType()==cursor){
                flag=10;
            }
        }


        if(playRo>=2 && playCol<=size-3 && size-2>=playRo && 1<=playCol){
            if(board[playRo+1][playCol-1].getterCellType()==cursor && board[playRo-1][playCol+1].getterCellType()==cursor && board[playRo-2][playCol+2].getterCellType()==cursor){
                flag=11;
            }
        }


        if(playRo>=1 && playCol<=size-2 && size-3>=playRo && 2<=playCol){
            if(board[playRo+2][playCol-2].getterCellType()==cursor && board[playRo-1][playCol+1].getterCellType()==cursor && board[playRo+1][playCol-1].getterCellType()==cursor){
                flag=12;
            }
        }

        if(playRo>=0 && playCol<=size-1 && size-4>=playRo && 3<=playCol){
            if(board[playRo+1][playCol-1].getterCellType()==cursor && board[playRo+2][playCol-2].getterCellType()==cursor && board[playRo+3][playCol-3].getterCellType()==cursor){
                flag=13;
            }
        }
        // kazanma durumlarına göre farklı return değerleri oluşur
        if(flag==0){
            return -1;
        }
        /*flag 1 ile 13 arasindaysa ve cursor X ise flag return edilir*/
        else if(cursor=='X' && (flag==1 || flag==2 || flag==3 || flag==4 || flag==5 || flag==6 || flag==7 || flag==8 || flag==9 || flag==10 || flag==11 || flag==12 || flag==13)){
            return flag;
        }
        /*flag 1 ile 13 arasindaysa ve cursor O ise flag+13 return edilir*/

        else if(cursor=='O' && (flag==1 || flag==2 || flag==3 || flag==4 || flag==5 || flag==6 || flag==7 || flag==8 || flag==9 || flag==10 || flag==11 || flag==12 || flag==13)){
            return flag+13;
        }
        else{
            return -100;
        }
    }
    public int emptyMapControl(){  //
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j].getterCellType()=='.'){
                    return 1;
                }
            }
        }
        return 0;
    }
    public void lower(char cursor ,int flag){ // kazanma durumda X ise x olur O ise o olur cellType.
        // Bu sayede o taşlar için farklı bir graphic çizdirebliyorum ve kullanıcı hangi 4 lünün yan yana geldiğini görür.
        if(flag==1 || flag==14){

            if(board[playRow][playColumn+1].getterCellType()=='X'){
                board[playRow][playColumn+1].setterData('x');
                board[playRow][playColumn+2].setterData('x');
                board[playRow][playColumn+3].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow][playColumn+1].getterCellType()=='O'){
                board[playRow][playColumn+1].setterData('o');
                board[playRow][playColumn+2].setterData('o');
                board[playRow][playColumn+3].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==2 || flag==15){
            if(board[playRow][playColumn-1].getterCellType()=='X'){
                board[playRow][playColumn-1].setterData('x');
                board[playRow][playColumn+1].setterData('x');
                board[playRow][playColumn+2].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow][playColumn-1].getterCellType()=='O'){
                board[playRow][playColumn-1].setterData('o');
                board[playRow][playColumn+1].setterData('o');
                board[playRow][playColumn+2].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }


        if(flag==3 || flag==16){

            if(board[playRow][playColumn-2].getterCellType()=='X'){
                board[playRow][playColumn-2].setterData('x');
                board[playRow][playColumn-1].setterData('x');
                board[playRow][playColumn+1].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow][playColumn-2].getterCellType()=='O'){
                board[playRow][playColumn-2].setterData('o');
                board[playRow][playColumn-1].setterData('o');
                board[playRow][playColumn+1].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }
        if(flag==4 || flag==17){

            if(board[playRow][playColumn-3].getterCellType()=='X'){
                board[playRow][playColumn-3].setterData('x');
                board[playRow][playColumn-2].setterData('x');
                board[playRow][playColumn-1].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow][playColumn-3].getterCellType()=='O'){
                board[playRow][playColumn-3].setterData('o');
                board[playRow][playColumn-2].setterData('o');
                board[playRow][playColumn-1].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==5 || flag==18){
            if(board[playRow+1][playColumn].getterCellType()=='X'){
                board[playRow+1][playColumn].setterData('x');
                board[playRow+2][playColumn].setterData('x');
                board[playRow+3][playColumn].setterData('x');
                board[playRow][playColumn].setterData('x');
            }

            if(board[playRow+1][playColumn].getterCellType()=='O'){

                board[playRow+1][playColumn].setterData('o');
                board[playRow+2][playColumn].setterData('o');
                board[playRow+3][playColumn].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==6 || flag==19){

            if(board[playRow-3][playColumn-3].getterCellType()=='X'){
                board[playRow-3][playColumn-3].setterData('x');
                board[playRow-2][playColumn-2].setterData('x');
                board[playRow-1][playColumn-1].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow-3][playColumn-3].getterCellType()=='O'){
                board[playRow-3][playColumn-3].setterData('o');
                board[playRow-2][playColumn-2].setterData('o');
                board[playRow-1][playColumn-1].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==7 || flag==20){

            if(board[playRow-2][playColumn-2].getterCellType()=='X'){
                board[playRow-2][playColumn-2].setterData('x');
                board[playRow-1][playColumn-1].setterData('x');
                board[playRow][playColumn+3].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow-2][playColumn-2].getterCellType()=='O'){
                board[playRow-2][playColumn-2].setterData('o');
                board[playRow-1][playColumn-1].setterData('o');
                board[playRow+1][playColumn+1].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==8 || flag==21){

            if(board[playRow-1][playColumn-1].getterCellType()=='X'){
                board[playRow-1][playColumn-1].setterData('x');
                board[playRow+1][playColumn+1].setterData('x');
                board[playRow+2][playColumn+2].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow-1][playColumn-1].getterCellType()=='O'){
                board[playRow-1][playColumn-1].setterData('o');
                board[playRow+1][playColumn+1].setterData('o');
                board[playRow+2][playColumn+2].setterData('o');
                board[playRow][playColumn].setterData('o');

            }
        }

        if(flag==9 || flag==22){

            if(board[playRow+1][playColumn+1].getterCellType()=='X'){
                board[playRow+1][playColumn+1].setterData('x');
                board[playRow+2][playColumn+2].setterData('x');
                board[playRow+3][playColumn+3].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow+1][playColumn+1].getterCellType()=='O'){
                board[playRow+1][playColumn+1].setterData('o');
                board[playRow+2][playColumn+2].setterData('o');
                board[playRow+3][playColumn+3].setterData('o');
                board[playRow][playColumn].setterData('o');

            }
        }

        if(flag==10 || flag==23){

            if(board[playRow-3][playColumn+3].getterCellType()=='X'){
                board[playRow-3][playColumn+3].setterData('x');
                board[playRow-2][playColumn+2].setterData('x');
                board[playRow-1][playColumn+1].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow-3][playColumn+3].getterCellType()=='O'){
                board[playRow-3][playColumn+3].setterData('o');
                board[playRow-2][playColumn+2].setterData('o');
                board[playRow-1][playColumn+1].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==11 || flag==24){

            if(board[playRow+1][playColumn-1].getterCellType()=='X'){
                board[playRow+1][playColumn-1].setterData('x');
                board[playRow-1][playColumn+1].setterData('x');
                board[playRow-2][playColumn+2].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow+1][playColumn-1].getterCellType()=='O'){
                board[playRow+1][playColumn-1].setterData('o');
                board[playRow-1][playColumn+1].setterData('o');
                board[playRow-2][playColumn+2].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==12 || flag==25){

            if(board[playRow+2][playColumn-2].getterCellType()=='X'){
                board[playRow+2][playColumn-2].setterData('x');
                board[playRow][playColumn+2].setterData('x');
                board[playRow][playColumn+3].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow+2][playColumn-2].getterCellType()=='O'){
                board[playRow+2][playColumn-2].setterData('o');
                board[playRow][playColumn+2].setterData('o');
                board[playRow][playColumn+3].setterData('o');
                board[playRow][playColumn].setterData('o');
            }
        }

        if(flag==13 || flag==26){

            if(board[playRow+1][playColumn-1].getterCellType()=='X'){
                board[playRow+1][playColumn-1].setterData('x');
                board[playRow+2][playColumn-2].setterData('x');
                board[playRow+3][playColumn-3].setterData('x');
                board[playRow][playColumn].setterData('x');
            }
            if(board[playRow+1][playColumn-1].getterCellType()=='O'){
                board[playRow+1][playColumn-1].setterData('o');
                board[playRow+2][playColumn-2].setterData('o');
                board[playRow+3][playColumn-3].setterData('o');
                board[playRow][playColumn].setterData('o');

            }
        }
    }

}
