package mView;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by zl on 2017/3/9.
 */

public class ViewAnimation {

    public TranslateAnimation mShowAnim;
    public TranslateAnimation HiddenAmin;

    public TranslateAnimation Show() {
        mShowAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF
                ,-1.0f, Animation.RELATIVE_TO_SELF,0.0f);
        mShowAnim.setDuration(500);
        return mShowAnim;
    }

    public TranslateAnimation Hide() {
        HiddenAmin = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF
                ,0.0f, Animation.RELATIVE_TO_SELF,-1.0f);
        HiddenAmin.setDuration(500);
        return HiddenAmin;
    }
}
