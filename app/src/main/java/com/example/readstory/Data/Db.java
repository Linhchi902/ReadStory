package com.example.readstory.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Db {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public static String DB_NAME = "truyencuoi";

    public Db(Context context) {
        this.context = context;
        copyExApp();
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void copyExApp(){
        //lấy đường dẫn
        String path = Environment.getDataDirectory().getPath() + "/data/" +
                context.getPackageName() + "/db";
        if(new File(path + DB_NAME).exists()){
            return;
        }

        try {
            InputStream in = context.getAssets().open(DB_NAME);
            new File(path).mkdir();//tạo thư mục
            OutputStream out = new FileOutputStream(path + DB_NAME);
            byte[] b = new byte[1024];
            int l = in.read(b);
            while (l > -1){
                out.write(b,0,l);
                l = in.read(b);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDb(){
        if(sqLiteDatabase == null || sqLiteDatabase.isOpen() == false){
            String path =Environment.getDataDirectory().getPath() + "/data/" +
                    context.getPackageName() + "/db";
            sqLiteDatabase = SQLiteDatabase.openDatabase(path + DB_NAME,
                    null,SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public void closeDb(){
        if(sqLiteDatabase == null || sqLiteDatabase.isOpen()== false){
            return;
        }
        sqLiteDatabase.close();
        sqLiteDatabase = null;
    }
}
