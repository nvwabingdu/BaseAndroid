package mUtils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

/**
 * Created by zl on 2017/5/8.
 */

public class ZoomButtonAnim {

    public void setAnim(View view) {
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX",
                1f, 1.2f, 1f);
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY",
                1f, 1.2f, 1f);
        ObjectAnimator ZoomAnim = ObjectAnimator.ofPropertyValuesHolder(view,pvhScaleX, pvhScaleY);
        ZoomAnim.setDuration(300);
        ZoomAnim.start();
    }
}
