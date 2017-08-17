package mModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zl on 2017/2/24.
 */

public class GlobalModel {
    //    public String imageUrl = "https://htc-gw.kxkr.com";




    //单例模式
    private static GlobalModel single = null;
    private GlobalModel() {}
    public static synchronized GlobalModel getInstance() {
        if (single == null) {
            single = new GlobalModel();
        }
        return single;
    }
}
