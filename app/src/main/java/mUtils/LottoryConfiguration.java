package mUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kxkr.mimilottery.com.R;

/**
 * Created by zl on 2017/5/11.
 */

public class LottoryConfiguration {
    private List<HashMap<String,Object>> mList = new ArrayList<HashMap<String,Object>>();
    private String[] name ={"大乐透","福彩3D","双色球","时时彩","北京PK10","广东11选5","排列三","排列五","竞彩足球","竞彩篮球"};
    private int[] imageResource = {R.drawable.daletou,R.drawable.fucai,R.drawable.shuangseqiu,R.drawable.cqshishicai,R.drawable.beijingpk10,R.drawable.gd,R.drawable.pailiesan,R.drawable.pailiewu,R.drawable.jingcaizuqiu,R.drawable.jingcailanqiu};
    private int[] mLotteryIds = {1,2,3,4,5, 6, 7, 8, 9, 10};
    public List<HashMap<String,Object>> getItems() {

        for (int i=0;i<name.length;i++) {
            HashMap<String , Object> item = new HashMap<String,Object>();
            item.put(Constants.TXT_NAME,name[i]);
            item.put(Constants.TXT_ID,mLotteryIds[i]);
            item.put(Constants.IMAGE_NAME,imageResource[i]);
            item.put(Constants.TXT_ISSTOP,false);
            item.put(Constants.ISPLUS_AWARD,false);
            item.put(Constants.TXT_INTRO,"两元可中五百万");
            mList.add(item);
        }
        return mList;
    }
}
