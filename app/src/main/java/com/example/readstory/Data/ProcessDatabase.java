package com.example.readstory.Data;

import android.content.Context;
import android.database.Cursor;

import com.linhchi.object.GenresName;
import com.linhchi.object.Story;
import java.util.ArrayList;
import java.util.List;

public class ProcessDatabase {

    private Context context;
    private Db db;

    public ProcessDatabase(Context context) {
        this.context = context;
        db = new Db(context);
    }

    public List<GenresName> getAllGenresName(){
        List<GenresName> listName = new ArrayList<>();
        db.openDb();

        Cursor c = db.getSqLiteDatabase().rawQuery("select * from categories",null);
        c.moveToFirst();//lấy phần tử đầu tiên

        int indexID = c.getColumnIndex("id");
        int indexName = c.getColumnIndex("name");
        c.getInt(indexID);//lấy theo id

        while (!c.isAfterLast()){
            int id = c.getInt(indexID);
            String name = c.getString(indexName);
            //chuyển đến dòng tiếp theo
            listName.add(new GenresName(id,name));
            c.moveToNext();
        }
        db.closeDb();
        return listName;
    }

    public List<Story> getNameStoryByCat(int id_cat){
        List<Story> list = new ArrayList<>();
        db.openDb();

        Cursor mCursor = db.getSqLiteDatabase().rawQuery("Select id,name,content from stories where cat_id="+id_cat,null);
        mCursor.moveToNext();
        int in_story = mCursor.getColumnIndex("id");
        int indexName = mCursor.getColumnIndex("name");
        int indexContent = mCursor.getColumnIndex("content");

        while (!mCursor.isAfterLast()){
            int id = mCursor.getInt(in_story);
            String name = mCursor.getString(indexName);
            String content = mCursor.getString(indexContent);
            list.add(new Story(id,name,content));
            mCursor.moveToNext();
        }
        db.closeDb();
        return list;
    }


}
