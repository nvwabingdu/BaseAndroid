package mUtils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.EditText;

/**
 * Created by zl on 2017/2/24.
 */

public class LineEditText extends EditText {
    private Paint paint;
    public LineEditText(Context context) {
        super(context);
        //设置画笔的属性
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        //可以自定义画笔的颜色，我这里设置成黑色
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, this.getHeight()-2, this.getWidth()-2, this.getHeight()-2, paint);
    }
}
