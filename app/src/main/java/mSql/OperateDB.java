package mSql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import Bean.BackCard;
//import Bean.BuyTickets;
//import Model.GlobalModel;
//import Utils.Constants;

/**
 * Created by zl on 2017/4/10.
 */

public class OperateDB {
    private Context context;

    public OperateDB(Context context) {
        this.context = context;
    }

    /**
     * 时时彩删除数据全部
     * @param id
     */
    public void deleteSscItem(int id) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from ssc where _id>"+id+"");
        db.close();
    }

    /**
     * 删除大乐透数据全部
     * @param id
     */
    public void deleteDltItem(int id) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from dlt where _id>"+id+"");
        db.close();
    }

    /**
     * 删除数据全部
     * @param id
     */
    public void deleteFItem(int id) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from fc where _id>"+id+"");
        db.close();
    }

    /**
     * 删除双色球数据全部
     * @param id
     */
    public void deleteSsqItem(int id) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from ssq where _id>"+id+"");
        db.close();
    }

    /**
     * 删除11x5数据全部
     * @param id
     */
    public void deleteGdItem(int id) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from gd where _id>"+id+"");
        db.close();
    }
    /**
     * 删除PK10数据全部
     * @param id
     */
    public void deleteBjItem(int id) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from bj where _id>"+id+"");
        db.close();
    }

//    public void insertGCQ(List<BuyTickets> mList) {
//        SQLiteDatabase db = new MyDatabase(context).getsDB1();
//        for (int i=0;i<mList.size();i++) {
//            BuyTickets item = mList.get(i);
//            ContentValues values = new ContentValues();
//            values.put("id", item.getId());
//            values.put("useBase", item.getUseBase());
//            values.put("useSub",item.getUseSub());
//            values.put("maxStack",item.getMaxStack());
//            values.put("validStart",item.getValidStart());
//            values.put("validEnd",item.getValidEnd());
//            values.put("addtime", item.getAddtime());
//            values.put("title", item.getTitle());
//            values.put("restrictType",item.getRestrictType());
//            values.put("restrictId",item.getRestrictId());
//            values.put("status",item.getStatus());
//            db.insert("gcq","id,useBase,useSub,maxStack,validStart,validEnd,addtime,title,restrictType,restrictId,status",values);
//        }
//        db.close();
//    }

    /*
    *删除数据库
     */
    public void deleteAll() {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from bj where _id>0");
        db.execSQL("delete from gd where _id>0");
        db.execSQL("delete from ssc where _id>0");
        db.execSQL("delete from dlt where _id>0");
        db.execSQL("delete from ssq where _id>0");
        db.execSQL("delete from fc where _id>0");
        db.execSQL("delete from pls where _id>0");
        db.execSQL("delete from plw where _id>0");
        db.execSQL("delete from bankinfo where _id>0");
        db.close();
    }

    /*
   *删除数据库彩种
    */
    public void deleteAllLottery() {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from bj where _id>0");
        db.execSQL("delete from gd where _id>0");
        db.execSQL("delete from ssc where _id>0");
        db.execSQL("delete from dlt where _id>0");
        db.execSQL("delete from ssq where _id>0");
        db.execSQL("delete from fc where _id>0");
        db.execSQL("delete from pls where _id>0");
        db.execSQL("delete from plw where _id>0");
        db.close();
    }
    /**
     * 删除银行卡信息
     */
    public void deleteBankInfo() {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from bankinfo where _id>0");
        db.close();
    }

    /**
     * 插入银行卡信息
     * @param item
     */
//    public void InsertBankInfo(BackCard item) {

//        SQLiteDatabase db = new MyDatabase(context).getsDB1();
//        db.execSQL("delete from bankinfo where _id>0");
//        ContentValues values = new ContentValues();
//        values.put("bankid", item.getId());
//        values.put("bankname",item.getBankname());
//        values.put("banktype",item.getCardtype());
//        values.put("bankno",item.getNo());
//        db.insert("bankinfo","bankid,bankname,banktype,bankno",values);
//        db.close();

//    }

    /**
     * 设置银行卡信息
     */
    public void getBankInfo() {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        Cursor cursor = db.query("bankinfo",null,null,null,null,null,null);
        while (cursor.moveToNext()) {
//            BackCard backCard = new BackCard();
//            backCard.setId(cursor.getString(cursor.getColumnIndex("bankid")));
//            backCard.setBankname(cursor.getInt(cursor.getColumnIndex("bankname")));
//            backCard.setCardtype(cursor.getString(cursor.getColumnIndex("banktype")));
//            backCard.setNo(cursor.getString(cursor.getColumnIndex("bankno")));
//            backCard.setDefault(true);
//            backCard.setSelect(true);
//            if (GlobalModel.getInstance().mBackCards == null) {
//                GlobalModel.getInstance().mBackCards = new ArrayList<BackCard>();
//            }
//            GlobalModel.getInstance().mBackCards.clear();
//            GlobalModel.getInstance().mBackCards.add(backCard);
        }
        db.close();
    }
    /**
     *  插入首页彩种顺序信息
     * @param mList
     */
    public void InsertCaiType(List<HashMap<String, Object>> mList) {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from caiinfo where _id>0");
        for (int i=0;i<mList.size();i++) {
//            ContentValues values = new ContentValues();
//            values.put("name", (String) mList.get(i).get(Constants.TXT_NAME));
//            values.put("caiid",(int)mList.get(i).get(Constants.TXT_ID));
//            values.put("resourceid",(int)mList.get(i).get(Constants.IMAGE_NAME));
//            values.put("intro",(String) mList.get(i).get(Constants.TXT_INTRO));
//            if((boolean)mList.get(i).get(Constants.TXT_ISSTOP)) {
//                values.put("isstop","true");
//            }else {
//                values.put("isstop",false);
//            }
//            if((boolean)mList.get(i).get(Constants.ISPLUS_AWARD)) {
//                values.put("isaward","true");
//            }else {
//                values.put("isaward","false");
//            }

//            db.insert("caiinfo","name,caiid,resourceid,intro,isstop,isaward",values);
        }
        db.close();
    }

    public void DeleteCaiType() {
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        db.execSQL("delete from caiinfo where _id>0");
        db.close();
    }

    public List<HashMap<String,Object>> getCaiInfo() {
        List<HashMap<String,Object>> mList = new ArrayList<HashMap<String,Object>>();
        SQLiteDatabase db = new MyDatabase(context).getsDB1();
        Cursor cursor = db.query("caiinfo",null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            HashMap<String , Object> item = new HashMap<String,Object>();
//            item.put(Constants.TXT_NAME,cursor.getString(cursor.getColumnIndex("name")));
//            item.put(Constants.TXT_ID,cursor.getInt(cursor.getColumnIndex("caiid")));
//            item.put(Constants.IMAGE_NAME,cursor.getInt(cursor.getColumnIndex("resourceid")));
//            item.put(Constants.TXT_INTRO,cursor.getString(cursor.getColumnIndex("intro")));
//            if(cursor.getString(cursor.getColumnIndex("isstop")).equals("true")) {
//                item.put(Constants.TXT_ISSTOP,true);
//            }else {
//                item.put(Constants.TXT_ISSTOP,false);
//            }
//            if(cursor.getString(cursor.getColumnIndex("isaward")).equals("true")) {
//                item.put(Constants.ISPLUS_AWARD,true);
//            }else {
//                item.put(Constants.ISPLUS_AWARD,false);
//
//            }
            mList.add(item);
        }

        db.close();
        return mList;
    }


}
