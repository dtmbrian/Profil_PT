package com.example.b_corporation.ptanugerahgenerasibersama.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "DatabasePT.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static final String DB_PATH = "data/data/com.example.b_corporation.ptanugerahgenerasibersama/databases/";
    static final String TB_Name = "tbl_proyek";
    static final String DROP_TB = "DROP TABLE IF EXIST" + TB_Name;
    private final Context context;
    private SQLiteDatabase db;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TB);
        onCreate(db);
    }

    public SQLiteDatabase createDataBase() throws IOException {
        String mypath1 = DB_PATH + DATABASE_NAME;
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        boolean dbExist = checkDatabase();
        if (dbExist) {
            Log.i("tag", "dbExist" + dbExist);
        } else {
            Log.i("tag", "dbnotExist" + dbExist);
            this.getWritableDatabase();
            copyDatabase();
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
    }

    public SQLiteDatabase openDatabase() throws IOException {
        File dbFile = context.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            if (!dbFile.getParentFile().exists()) {
                dbFile.getParentFile().mkdir();
            } else {
                this.getWritableDatabase();
                copyDatabase();
            }
        }


        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    private void copyDatabase() throws IOException {
        InputStream is = context.getAssets().open(DATABASE_NAME);
        String outFile = DB_PATH + DATABASE_NAME;
        OutputStream os = new FileOutputStream(outFile);

        byte[] buffer = new byte[1024];
        int lenght;
        while ((lenght = is.read(buffer)) > 0) {
            os.write(buffer, 0, lenght);
        }

        os.flush();
        os.close();
        is.close();
    }

    private boolean checkDatabase() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }

    public SQLiteDatabase openDataBase() throws SQLException {
        String mypath = DB_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }
}
