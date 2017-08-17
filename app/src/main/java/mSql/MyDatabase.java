package mSql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabase {
	private Context context;
	
	public MyDatabase(Context context) {
		super();
		this.context = context;
	}

	public SQLiteDatabase getsDB1() {
		
		DBHelper helper = new DBHelper(context, "kxkr.db", null, 1);
		SQLiteDatabase db = helper.getReadableDatabase();
		return db;
	}
	
	public SQLiteDatabase getsDB2() {
		DBHelper helper = new DBHelper(context, "kxkr.db", null, 1);
		SQLiteDatabase db = helper.getWritableDatabase();
		return db;
		
	}

//	/**
//	 * 删除缴费记录
//	 */
//	private void deletePayCost() {
//		SQLiteDatabase db = getDB1();
//		db.execSQL("delete from paycost where _id>0");
//		db.close();
//	}

}
