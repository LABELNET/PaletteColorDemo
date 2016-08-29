package labelnet.cn.patterncolordemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    int index=0;

    private int [] imageIds=new int[]{
            R.mipmap.icon_one,
            R.mipmap.icon_two,
            R.mipmap.icon_three,
            R.mipmap.icon_three,
            R.mipmap.icon_four,
            R.mipmap.icon_five,
            R.mipmap.icon_six,
            R.mipmap.icon_seven,
            R.mipmap.icon_enght,
            R.mipmap.icon_nine,
            R.mipmap.icon_ten,
            R.mipmap.icon_ten1,
            R.mipmap.icon_ten2,
            R.mipmap.icon_ten3,
            R.mipmap.icon_ten4,
            R.mipmap.icon_ten5,
            R.mipmap.icon_ten6
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        tv5= (TextView) findViewById(R.id.tv5);
        tv6= (TextView) findViewById(R.id.tv6);
        tv7= (TextView) findViewById(R.id.tv7);
        initTextView();
    }

    private void initTextView() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageIds[index]);
        initBackColor(bitmap);

        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index==imageIds.length){
                    index=0;
                }
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageIds[index]);
                initBackColor(bitmap);
                setTitle(getString(R.string.app_name)+" | "+index);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.test_palette){
            startActivity(new Intent(MainActivity.this,PatternUtilActivity.class));
        }else if(item.getItemId()==R.id.test_drawable){
            startActivity(new Intent(MainActivity.this,DrawableActivity.class));
        }
        return true;
    }

    private void initBackColor(Bitmap bitmap) {

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {

                //1
                Palette.Swatch a = palette.getVibrantSwatch();

                for(float f:a.getHsl()) {
                    Log.v("Main", " pop : " + f);
                }

                if(a!=null){
                    tv1.setBackgroundColor(a.getRgb());
                    tv1.setTextColor(a.getTitleTextColor());
                }else{
                    Log.v("Main","a 为 null");
                    tv1.setBackgroundColor(Color.WHITE);
                    tv1.setTextColor(Color.YELLOW);
                }

                //2
                Palette.Swatch b=palette.getLightVibrantSwatch();

                if(b!=null){

                    tv2.setBackgroundColor(b.getRgb());
                    tv2.setTextColor(b.getTitleTextColor());

                }else{
                    Log.v("Main","b 为 null");
                    tv2.setBackgroundColor(Color.WHITE);
                    tv2.setTextColor(Color.YELLOW);
                }



                //3
                Palette.Swatch c = palette.getDarkVibrantSwatch();
                if(c!=null){
                    tv3.setBackgroundColor(c.getRgb());
                    tv3.setTextColor(c.getTitleTextColor());
                }else{
                    Log.v("Main","c 为 null");
                    tv3.setBackgroundColor(Color.WHITE);
                    tv3.setTextColor(Color.YELLOW);
                }


                //4
                Palette.Swatch d = palette.getMutedSwatch();
                if(d!=null){

                    tv4.setBackgroundColor(d.getRgb());
                    tv4.setTextColor(d.getTitleTextColor());

                }else{
                    Log.v("Main","d 为 null");
                    tv4.setBackgroundColor(Color.WHITE);
                    tv4.setTextColor(Color.YELLOW);
                }

                //5
                Palette.Swatch e = palette.getLightMutedSwatch();
                if(e!=null){

                    tv5.setBackgroundColor(e.getRgb());
                    tv5.setTextColor(e.getTitleTextColor());

                }else{
                    Log.v("Main","e 为 null");
                    tv5.setBackgroundColor(Color.WHITE);
                    tv5.setTextColor(Color.YELLOW);

                }

                //6
                Palette.Swatch f = palette.getDarkMutedSwatch();
                if(f!=null){

                    tv6.setBackgroundColor(f.getRgb());
                    tv6.setTextColor(f.getTitleTextColor());

                }else{
                    Log.v("Main","f 为 null");
                    tv6.setBackgroundColor(Color.WHITE);
                    tv6.setTextColor(Color.YELLOW);
                }

                int two=0;
                if(b!=null){
                    two=b.getRgb();
                }

                 tv7.setBackgroundDrawable(changedImageViewShape(a.getRgb(),two));
                 tv7.setTextColor(a.getTitleTextColor());

            }
        });
    }


    /**
     * 创建Drawable对象
     * @param RGBValues
     * @param two
     * @return
     */
    private Drawable changedImageViewShape(int RGBValues,int two){
        if(two==0){
            two=colorEasy(RGBValues);
        }else {
            two = colorBurn(two);
        }
        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.TL_BR
                ,new int[]{RGBValues,two});
        shape.setShape(GradientDrawable.RECTANGLE);
        //设置渐变方式
        shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        //圆角
        shape.setCornerRadius(8);
        return shape;
    }


    /**
     * 颜色变浅处理
     * @param RGBValues
     * @return
     */
    private int colorEasy(int RGBValues) {
        int red = RGBValues >> 16 & 0xff;
        int green = RGBValues >> 8 & 0xff;
        int blue = RGBValues & 0xff;
        if(red==0){
            red=10;
        }
        if(green==0){
            green=10;
        }
        if(blue==0){
            blue=10;
        }
        Log.v("Main","Red : "+ red);
        Log.v("Main","Green : "+ green);
        Log.v("Main","Blue : "+ blue);
        red = (int) Math.floor(red * (1 + 0.1));
        green = (int) Math.floor(green * (1 + 0.1));
        blue = (int) Math.floor(blue * (1 + 0.1));
        return Color.rgb(red, green, blue);
    }

    /**
     * 颜色加深处理
     * @param RGBValues
     * @return
     */
    private int colorBurn(int RGBValues) {
        int red = RGBValues >> 16 & 0xff;
        int green = RGBValues >> 8 & 0xff;
        int blue = RGBValues & 0xff;
        Log.v("Main","Red : "+ red);
        Log.v("Main","Green : "+ green);
        Log.v("Main","Blue : "+ blue);
        red = (int) Math.floor(red * (1 - 0.1));
        green = (int) Math.floor(green * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, green, blue);
    }

}
