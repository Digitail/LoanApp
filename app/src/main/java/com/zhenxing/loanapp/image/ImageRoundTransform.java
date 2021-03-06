package com.zhenxing.loanapp.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.squareup.picasso.Transformation;
import com.zhenxing.loanapp.R;

public class ImageRoundTransform implements Transformation {

    private Context mContext;

    private int radius;

    public ImageRoundTransform(Context context, int radius) {

        mContext = context;
        this.radius = radius;
    }

    @Override
    public Bitmap transform(Bitmap source) {

        int widthLight = source.getWidth();
        int heightLight = source.getHeight();
        //int radius = DensityUtil.dp2px(mContext, 8); // 圆角半径

        Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        Paint paintColor = new Paint();
        paintColor.setFlags(Paint.ANTI_ALIAS_FLAG);
        paintColor.setColor(mContext.getResources().getColor(R.color.white));

        RectF rectF = new RectF(new Rect(0, 0, widthLight, heightLight));

        canvas.drawRoundRect(rectF, radius, radius, paintColor);
        //        canvas.drawRoundRect(rectF, widthLight / 5, heightLight / 5, paintColor);

        Paint paintImage = new Paint();
        paintImage.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(source, 0, 0, paintImage);
        source.recycle();
        return output;
    }

    @Override
    public String key() {
        return "roundcorner";
    }
}