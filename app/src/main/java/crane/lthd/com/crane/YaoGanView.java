package crane.lthd.com.crane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by xs on 2016/7/4.
 */
public class YaoGanView extends View {
    //摇杆的X,Y坐标以及摇杆的半径
    public float SmallRockerCircleX;
    public float SmallRockerCircleY;
    public YaoGanView(Context context,float x,float y) {
        super(context);
        SmallRockerCircleX=x;
        SmallRockerCircleY=y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //根据图片生成位图对象
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(
        ), R.drawable.shoubing);
        Rect dst=new Rect();
        dst.left= (int) SmallRockerCircleX;
        dst.top=(int)SmallRockerCircleY;
        dst.right=(int)SmallRockerCircleX+96;
        dst.bottom=(int)SmallRockerCircleY+96;
        canvas.drawBitmap(bitmap,null,dst,paint);
    }
}