package mUtils;


import android.graphics.Bitmap;
import android.widget.ImageView;

import CoreService.CallBacks;
import CoreService.SuperImageLoader;
import Model.GlobalModel;

/**
 * Created by zl on 2017/2/28.
 */

public class getImage{

    public void setImageIcon(String url, final ImageView imageView) {
        SuperImageLoader task = new SuperImageLoader(GlobalModel.getInstance().imageUrl, url, new CallBacks() {
            @Override
            public void OnResult(Object o) {
                if(o != null) {
                    Bitmap bitmap = (Bitmap) o;
                    imageView.setImageBitmap(bitmap);
                }
            }

            @Override
            public void OnFault(Object o) {

            }
        });
        task.doIt();
    }
}
