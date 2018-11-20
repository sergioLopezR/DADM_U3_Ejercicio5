package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {

    Imagen2 imgRed, imgBlue, imgGreen, textRed, textBlue, textGreen, imgNuevo, puntero;
    String titulo;
    private boolean acierto1, acierto2, acierto3;
    Main2Activity main;

    public Lienzo2(Context context) {
        super(context);
        titulo = "Arrastra el texto al color que corresponda";
        imgRed = new Imagen2(R.drawable.red, 200, 300, this);
        imgBlue = new Imagen2(R.drawable.blue, 200, 800, this);
        imgGreen = new Imagen2(R.drawable.green, 200, 1300, this);
        textBlue = new Imagen2(R.drawable.bluetext, 950, 400, this);
        textGreen = new Imagen2(R.drawable.greentext, 950, 900, this);
        textRed = new Imagen2(R.drawable.redtext, 950, 1400, this);
        imgNuevo = new Imagen2(R.drawable.nuevo, 600, 500, this);
        puntero = null;
        main = (Main2Activity)context;
        imgNuevo.hacerVisible(false);
    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(70);
        p.setColor(Color.BLACK);
        c.drawText(titulo, 190, 110, p);


        textRed.pintar(c, p);
        textBlue.pintar(c, p);
        textGreen.pintar(c, p);
        imgRed.pintar(c, p);
        imgBlue.pintar(c, p);
        imgGreen.pintar(c, p);
        imgNuevo.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (imgRed.estaEnArea(xp, yp)){
                    puntero = imgRed;
                }
                if (imgBlue.estaEnArea(xp, yp)){
                    puntero = imgBlue;
                }
                if (imgGreen.estaEnArea(xp, yp)){
                    puntero = imgGreen;
                }
                if (textRed.estaEnArea(xp, yp)){
                    puntero = textRed;
                }
                if (textBlue.estaEnArea(xp, yp)){
                    puntero = textBlue;
                }
                if (textGreen.estaEnArea(xp, yp)){
                    puntero = textGreen;
                }
                if (imgNuevo.estaEnArea(xp, yp)){
                    Intent pantalla = new Intent(main, Main2Activity.class);
                    main.startActivity(pantalla);
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    puntero.mover(xp, yp);
                    if(puntero.colision(imgRed) && puntero == textRed){
                        textRed.hacerVisible(false);
                        imgRed.hacerVisible(false);
                        acierto1 = true;
                    }

                    if(puntero.colision(imgBlue) && puntero == textBlue){
                        textBlue.hacerVisible(false);
                        imgBlue.hacerVisible(false);
                        acierto2 = true;
                    }

                    if(puntero.colision(imgGreen) && puntero == textGreen){
                        textGreen.hacerVisible(false);
                        imgGreen.hacerVisible(false);
                        acierto3 = true;
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                if (acierto1 == true && acierto2 == true && acierto3 == true){
                    titulo = "Felicidades (El juego a terminado)";
                    imgNuevo.hacerVisible(true);

                }
                puntero = null;
                break;
        }
        invalidate();
        return true;
    }



}
