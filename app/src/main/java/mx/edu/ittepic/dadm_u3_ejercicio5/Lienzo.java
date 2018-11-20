package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    String titulo1, titulo2;
    Imagen imagen1, imagen2, imagen3;
    MainActivity main;

    public Lienzo(Context context) {
        super(context);

        titulo1 = "Bienvenido/Welcome";
        titulo2 = "ColorPlay";
        imagen1 = new Imagen(R.drawable.carita, 170, 750, this);
        imagen2 = new Imagen(R.drawable.start, 900, 700, this);
        imagen3 = new Imagen(R.drawable.playgame, 850, 1200, this);
        main = (MainActivity) context;
    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(100);
        p.setColor(Color.BLACK);
        c.drawText(titulo1, 330, 300, p);

        p.setTextSize(80);
        p.setColor(Color.BLACK);
        c.drawText(titulo2, 640, 400, p);
        imagen1.pintar(c, p);
        imagen2.pintar(c, p);
        imagen3.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (imagen2.estaEnArea(xp, yp)){
                    cambioPantalla1();
                }
                if (imagen3.estaEnArea(xp, yp)){
                    cambioPantalla2();
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

    public void cambioPantalla1(){
        Intent pantalla = new Intent(main, Main2Activity.class);
        main.startActivity(pantalla);
    }

    private void cambioPantalla2() {
        Intent pantalla = new Intent(main, Main3Activity.class);
        main.startActivity(pantalla);
    }


}
