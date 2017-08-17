package mView;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import kxkr.mimilottery.com.R;

/**
 * Created by zl on 2017/3/17.
 */

public class MyTouchListener implements OnTouchListener {
    private Context mContext;
    private Animation anim;

    public MyTouchListener(Context context) {
        mContext = context;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                 anim = AnimationUtils.loadAnimation(mContext, R.anim.anction_down);
                v.startAnimation(anim);
                break;
            case MotionEvent.ACTION_UP:
                anim = AnimationUtils.loadAnimation(mContext, R.anim.anction_up);
                v.startAnimation(anim);
                break;
        }
        return false;
    }
}
