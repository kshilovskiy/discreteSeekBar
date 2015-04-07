package org.adw.library.widgets.discreteseekbar.internal.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Draws the specified drawable in equally distributed along the width.
 */
public class HorizontalScaleDrawable extends Drawable {
    private Drawable mDrawable;
    private int mCount;

    public HorizontalScaleDrawable(Drawable drawable, int count) {
        if(drawable == null){
            throw new IllegalArgumentException("Drawable can not be null");
        }

        this.mDrawable = drawable;
        this.mCount = count;
        mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
    }

    @Override
    public void draw(Canvas canvas) {
        Rect rect = getBounds();
        int width = rect.right - rect.left;
        int step = width / (mCount - 1);
        canvas.save();
        canvas.translate(rect.left, rect.top);

        for (int i = 0; i < mCount; i++) {
            mDrawable.draw(canvas);
            canvas.translate(step, 0);
        }

        canvas.restore();
    }

    @Override
    public void setAlpha(int alpha) {
        mDrawable.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mDrawable.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public int getIntrinsicItemWidth(){
        return mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicItemHeight(){
        return mDrawable.getIntrinsicWidth();
    }
}
