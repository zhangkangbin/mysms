package com.example.engine;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDB extends SQLiteOpenHelper {
	 /**���ݿ�SQL��� ���һ����**/  

    private static final String NAME_TABLE_CREATE = "create table test("  

        + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + "address TEXT,"+"body INTEGER DEFAULT 100,"+ "date INTEGER DEFAULT 100,"  

        + "type INT);"; 


	public CreateDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	 public CreateDB(Context con, String name) {
		// TODO Auto-generated constructor stub
		 this(con,name,null, 1);
	}
	public void onCreate(SQLiteDatabase db) {     
         // TODO �������ݿ�󣬶����ݿ�Ĳ���     
		 /**����������ӱ�**/  

		    db.execSQL(NAME_TABLE_CREATE); 

     }     
     
     @Override    
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {     
         // TODO �������ݿ�汾�Ĳ���     
     }     
     
 @Override    
 public void onOpen(SQLiteDatabase db) {     
         super.onOpen(db);       
         // TODO ÿ�γɹ������ݿ�����ȱ�ִ��     
     }     

}
