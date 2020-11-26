package com.example.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Text_Database extends SQLiteOpenHelper {

    public Text_Database(Context context) {
        super(context, "text_db", null, 1);
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table text(id integer primary key autoincrement," +
                "title varchar(20),name varchar(20) NOT NULL  DEFAULT '1',context varchar(100),date Date)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //删除
    public void delete(SQLiteDatabase sqLiteDatabase, int id) {
        sqLiteDatabase.delete("text", "id=?", new String[]{id + ""});
        sqLiteDatabase.close();
    }

    //查找

    public List<textBean> querydata(SQLiteDatabase sqLiteDatabase)
    {
        Cursor cursor=sqLiteDatabase.query("text",null,null,null,null,null,"id ASC");
        List<textBean> list=new ArrayList<textBean>();
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String title=cursor.getString(1);
            String name=cursor.getString(2);
            String context=cursor.getString(3);
            String date=cursor.getString(4);
            list.add(new textBean(id,title,name,context,date));
        }
        cursor.close();
        sqLiteDatabase.close();
        //返回查询的记事本集合
        return list;
    }
    //增加、更新
    public void adddata(SQLiteDatabase sqLiteDatabase,String title,String name,String context,String date)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",title);
        contentValues.put("name",name);
        contentValues.put("context",context);
        contentValues.put("date",date);
        sqLiteDatabase.insert("text",null,contentValues);
        sqLiteDatabase.close();
    }
    //根据ID号更新表
    public boolean Update( SQLiteDatabase sqLiteDatabase,int id,String title,String name,String context,String date)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",title);
        contentValues.put("name",name);
        contentValues.put("context",context);
        contentValues.put("date",date);
        sqLiteDatabase.update("text",contentValues,"id=?",new String[]{id+""});
        sqLiteDatabase.close();
        return true;
    }
}
