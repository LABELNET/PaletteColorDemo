package labelnet.cn.patterncolordemo.other;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by yuan on 2016/8/29.
 * 生成Drawable背景资源
 */
public class DrawableUtil {

    public static Drawable changedImageViewShape(int RGBOne, int RGBTwo){
        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.TL_BR
                ,new int[]{RGBOne,RGBTwo});
        shape.setShape(GradientDrawable.RECTANGLE);
        //设置渐变方式
        shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        //圆角
        shape.setCornerRadius(8);
        return shape;
    }

}
