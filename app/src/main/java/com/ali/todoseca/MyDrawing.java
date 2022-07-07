package com.ali.todoseca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyDrawing extends View {

    public MyDrawing(Context context, @Nullable AttributeSet attrs) {
        super(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);

        canvas.drawCircle(150,150,100,paint);


    }
}
