package labelnet.cn.patterncolordemo;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PatternUtilActivity extends AppCompatActivity {


    TextView tvPalette;
    ImageView ivPalette;
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
        setContentView(R.layout.activity_pattern_util);
        tvPalette= (TextView) findViewById(R.id.tv_palette);
        ivPalette= (ImageView) findViewById(R.id.iv_icon);

        initView(index);

        tvPalette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index==imageIds.length){
                    index=0;
                }
                initView(index);
            }
        });
    }

    private void initView(int index) {
        ivPalette.setImageResource(imageIds[index]);
        PaletteUtil.getInstance()
                .init(getResources()
                ,imageIds[index]
                ,new PaletteUtil.PatternCallBack() {
            @Override
            public void onCallBack(Drawable drawable, int titleColor) {
                tvPalette.setTextColor(titleColor);
                tvPalette.setBackgroundDrawable(drawable);
            }
        });

    }
}
