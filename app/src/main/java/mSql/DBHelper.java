package mSql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 建立数据库
 *
 * @author zl
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ssq(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table dlt(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table fc(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table ssc(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table gd(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table bj(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table gcq(_id integer primary key autoincrement,id text,useBase text,useSub text,maxStack text,validStart text,validEnd text,addtime text,title text,restrictType text,restrictId text,status text)");

        db.execSQL("create table carcost(_id integer primary key,info text)");

        db.execSQL("create table pls(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table plw(_id integer primary key autoincrement,balls text,type text,amount text,zs text,bs text,name text,listballs text,grouptype text)");
        db.execSQL("create table caiinfo(_id integer primary key autoincrement,name text,caiid integer,resourceid integer,intro text,isstop text,isaward text)");
        db.execSQL("create table bankinfo(_id integer primary key autoincrement,bankid text,bankname integer,banktype text,bankno text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
