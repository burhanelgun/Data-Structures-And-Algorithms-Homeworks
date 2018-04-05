package com.connect.burhan.coonectfour;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * Created by burhan on 30.01.2018.
 * Ekrandaki oyun tahtasını gösteren class
 */

public class MyView extends View {

    public static Cell[][] board;

    /**
     *Constructor da board içindeki cellerin özellikleri set edilir board oluşturulur
     * @param context
     */
    public MyView(Context context) {

        super(context);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;


        board = new Cell[main.size][main.size];  //Cellerden oluşan iki boyutlu bir board oluşturdum

        for (int i = 0; i < main.size; i++) {
            for (int j = 0; j < main.size; j++) {
                board[i][j] = new Cell();
            }
        }

        for (int k = 0, l = 400; k < main.size; k++, l = l + (main.radius * 2) + 15) { // ve her bir cellin içine kullanılan gerekli dataları atadım
            for (int i = width / 2 - (main.size / 2 * 15 + (main.size - 1) * main.radius), j = 0; j < main.size; i = i + (main.radius * 2) + 15, j++) {
                board[k][j].setterxPos(i);
                board[k][j].setteryPos(l);
                board[k][j].setterData('.');
                board[k][j].setterColumn(j);
                board[k][j].setterRow(k);
            }
        }
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Board içindeki her bir cellin rengi ekrana bastırılır
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);


        Paint paint = new Paint();

        // paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.WHITE);

        canvas.drawPaint(paint);


        for (int i = 0; i < main.size; i++) {
            for (int j = 0; j < main.size; j++) {  // iki for döngüsünde her bir cellin cell tipine göre renkleri ekrana bastırdım

                if (board[i][j].getterCellType() == '.') {
                    paint.setColor(Color.parseColor("lightGray"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius, paint);
                }
                if (board[i][j].getterCellType() == 'X') {

                    paint.setColor(Color.parseColor("RED"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius, paint);

                }
                if (board[i][j].getterCellType() == 'O') {
                    paint.setColor(Color.parseColor("BLUE"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius, paint);

                }
                if (board[i][j].getterCellType() == 'o') {
                    paint.setColor(Color.parseColor("YELLOW"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius, paint);
                    paint.setColor(Color.parseColor("BLUE"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius - 10, paint);

                }
                if (board[i][j].getterCellType() == 'x') {
                    paint.setColor(Color.parseColor("YELLOW"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius, paint);
                    paint.setColor(Color.parseColor("RED"));
                    canvas.drawCircle(board[i][j].getterxPos(), board[i][j].getteryPos(), main.radius - 10, paint);

                }


            }
        }
        invalidate();

    }

}