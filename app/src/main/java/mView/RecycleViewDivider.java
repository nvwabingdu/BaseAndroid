package mView;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zl on 2017/4/1.
 */

public class RecycleViewDivider extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //设定底部边距为1px
        outRect.set(0, 0, 0, 1);
    }
}
