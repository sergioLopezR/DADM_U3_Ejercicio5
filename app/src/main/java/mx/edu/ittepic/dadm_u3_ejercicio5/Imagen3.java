package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen3 {

    Bitmap icono;
    float x, y;

    public  Imagen3(int recurso, float _x, float _y, Lienzo3 l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
    }

    public void pintar(Canvas c, Paint p){
            c.drawBitmap(icono, x, y, p);
    }

    public boolean estaEnArea(float xp, float yp){
        float x2, y2;

        x2 = x+icono.getWidth();
        y2 = y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }
        return false;
    }

}
