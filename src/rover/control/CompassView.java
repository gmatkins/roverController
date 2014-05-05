package rover.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.util.AttributeSet;
import android.view.LayoutInflater;
public class CompassView extends View {
    Paint paint = new Paint();
    View view;
    public CompassView(Context context, AttributeSet attr) {
        super(context, attr);
    }
    public CompassView(Context context) {
      super(context);
      
      paint.setColor(0xff00ff00);
      paint.setStyle(Style.STROKE);
      paint.setStrokeWidth(2);
      paint.setAntiAlias(true);
    }
    protected void onDraw(Canvas canvas) {
      int width = getWidth();
      int height = getHeight();
      int centerx = width/2;
      int centery = height/2;
      canvas.drawLine(centerx, 0, centerx, height, paint);
      canvas.drawLine(0, centery, width, centery, paint);
      // Rotate the canvas with the azimut      
      //if (MainActivity.azimut != null) {
      //  canvas.rotate(-MainActivity.azimut*360/(2*3.14159f), centerx, centery);
      //}
      paint.setColor(0xff0000ff);
      canvas.drawLine(centerx, -1000, centerx, +1000, paint);
      canvas.drawLine(-1000, centery, 1000, centery, paint);
      canvas.drawText("N", centerx+5, centery-10, paint);
      canvas.drawText("S", centerx-10, centery+15, paint);
      paint.setColor(0xff00ff00);
    }
}
