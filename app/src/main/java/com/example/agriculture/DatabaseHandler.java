package com.example.agriculture;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.agriculture.models.AppModel;
import com.example.agriculture.models.UserModel;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String dataBaseName="Database";
    private static final String tableName="tables";
    private static final String userTableName="users";


    public DatabaseHandler(@Nullable Context context) {
        super(context, dataBaseName, null, 1);
    }

    public void addData (AppModel appModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("parentId" , appModel.getParentId() );
        contentValues.put("name" , appModel.getName() );
        contentValues.put("type" , appModel.getType() );
        contentValues.put("data" , appModel.getData() );
        Log.i("sqlitxxe",contentValues.toString());
        db.insert(tableName, null, contentValues);

    }
    public void addUser (UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name" , userModel.getName() );
        contentValues.put("email" , userModel.getEmail() );
        contentValues.put("password" , userModel.getPassword() );

        Log.i("sqlitxxe",contentValues.toString());
        db.insert(userTableName, null, contentValues);

    }
    public ArrayList<UserModel> getAllUsers(){
        ArrayList<UserModel> userModels = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + userTableName ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
//

                userModels.add(new UserModel(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return userModels;

    }
    public ArrayList<AppModel> getModelsbyID(int id){
        ArrayList<AppModel> appModels= new ArrayList<AppModel>();
        String selectQuery = "SELECT  * FROM " + tableName +" WHERE parentId='"+id+"'" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                appModels.add(new AppModel(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return appModels;

    }
    public ArrayList<AppModel> getParentModels(){
        ArrayList<AppModel> appModels = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + tableName +" WHERE parentId='"+0+"'" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
//

                appModels.add(new AppModel(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return appModels;

    }

    public ArrayList<AppModel> getAllData(){
        ArrayList<AppModel> appModels = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + tableName ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
//

                appModels.add(new AppModel(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return appModels;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    String tableExec ="CREATE TABLE "+tableName+ " (_id INTEGER PRIMARY KEY , parentId INTEGER, name TEXT , type TEXT, data TEXT)";
        db.execSQL(tableExec);
        String usertableExec ="CREATE TABLE "+userTableName+ " ( name TEXT , email TEXT, password TEXT)";
        db.execSQL(usertableExec);
    }
    public void clearTable() {
     
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + tableName);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);

        onCreate(db);

    }
}
