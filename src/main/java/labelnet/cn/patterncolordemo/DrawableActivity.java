package labelnet.cn.patterncolordemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import labelnet.cn.patterncolordemo.other.DrawableUtil;

public class DrawableActivity extends AppCompatActivity {


    TextView tv_drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        tv_drawable= (TextView) findViewById(R.id.tv_drawable);
        Drawable drawable = DrawableUtil.changedImageViewShape(getResources().getColor(R.color.js_one)
                , getResources().getColor(R.color.js_two));
        tv_drawable.setBackground(drawable);

    }
}
