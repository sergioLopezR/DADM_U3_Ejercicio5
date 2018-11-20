package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {

    Imagen3 imgRed, imgBlue, imgGreen, imgBlack, imgPink, imgYellow;
    String titulo;
    MediaPlayer mediaPlayer;
    String textRed, textBlue, textGreen, textBlack, textPink, textYellow;
    Main3Activity main;

    public Lienzo3(Context context) {
        super(context);
        titulo = "Toca el color y escucha su pronunciacion";
        imgRed = new Imagen3(R.drawable.red, 100, 500, this);
        imgBlue = new Imagen3(R.drawable.blue, 600, 500, this);
        imgGreen = new Imagen3(R.drawable.green, 1100, 500, this);
        imgBlack = new Imagen3(R.drawable.black, 100, 1050, this);
        imgPink = new Imagen3(R.drawable.pink, 600, 1050, this);
        imgYellow = new Imagen3(R.drawable.yellow, 1100, 1050, this);
        mediaPlayer = new MediaPlayer();
        textRed = "RED";
        textBlue = "BLUE";
        textGreen = "GREEN";
        textBlack = "BLACK";
        textPink = "PINK";
        textYellow = "YELLOW";
        main = (Main3Activity) context;
    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(70);
        p.setColor(Color.BLACK);
        c.drawText(titulo, 160, 110, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(textRed, 200, 920, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(textBlue, 680, 920, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(textGreen, 1160, 920, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(textBlack, 160, 1470, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(textPink, 690, 1470, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(textYellow, 1150, 1470, p);

        imgRed.pintar(c, p);
        imgBlue.pintar(c, p);
        imgGreen.pintar(c, p);
        imgBlack.pintar(c, p);
        imgPink.pintar(c, p);
        imgYellow.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (imgRed.estaEnArea(xp, yp)){
                    escucharRed();
                }
                if (imgBlue.estaEnArea(xp, yp)){
                    escucharBlue();
                }
                if (imgGreen.estaEnArea(xp, yp)){
                    escucharGreen();
                }
                if (imgBlack.estaEnArea(xp, yp)){
                    escucharBlack();
                }
                if (imgPink.estaEnArea(xp, yp)){
                    escucharPink();
                }
                if (imgYellow.estaEnArea(xp, yp)){
                    escucharYellow();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    private void escucharRed() {
        mediaPlayer = MediaPlayer.create(main, R.raw.red);
        mediaPlayer.start();
    }

    private void escucharBlue() {
        mediaPlayer = MediaPlayer.create(main, R.raw.blue);
        mediaPlayer.start();
    }

    private void escucharGreen() {
        mediaPlayer = MediaPlayer.create(main, R.raw.green);
        mediaPlayer.start();
    }

    private void escucharBlack() {
        mediaPlayer = MediaPlayer.create(main, R.raw.black);
        mediaPlayer.start();
    }

    private void escucharPink() {
        mediaPlayer = MediaPlayer.create(main, R.raw.pink);
        mediaPlayer.start();
    }

    private void escucharYellow() {
        mediaPlayer = MediaPlayer.create(main, R.raw.yellow);
        mediaPlayer.start();
    }


}
