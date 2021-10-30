package com.example.agriculture.utils;

import android.content.Context;
import android.util.Log;

import com.example.agriculture.DatabaseHandler;
import com.example.agriculture.models.AppModel;
import com.example.agriculture.models.UserModel;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVImporter {
    private Context context;
    private DatabaseHandler handler;
    public CSVImporter(Context context) {
        this.context = context;
        handler = new DatabaseHandler(context);
    }
    public void importModels(){
        handler.clearTable();
        Log.e("CSV Importer", "Clearing existing tables");


        importAppModels();


    }
    public void importUserModels() {
        // step 1
        // get the objects
        ArrayList<UserModel> userModelArrayList = getUserModels();

        // step 2
        // Call SQL query and add them to db
        for (UserModel model: userModelArrayList) {
            handler.addUser(model);
        }

    }

    public void importAppModels() {
        // step 1
        // get the objects
        ArrayList<AppModel> appModelObjects = getStateModels();

        // step 2
        // Call SQL query and add them to db
        for (AppModel model: appModelObjects) {
            handler.addData(model);
        }

    }


    public ArrayList<UserModel> getUserModels() {
        ArrayList<UserModel> models = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open("users.csv")));
            String[] nextLine;
            // skipping the first line as its header
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                UserModel model = new UserModel((nextLine[0]),nextLine[1],nextLine[2] );
                models.add(model);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return models;


    }
    public ArrayList<AppModel> getStateModels() {
        ArrayList<AppModel> models = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(context.getAssets().open("data.csv")));
            String[] nextLine;
            // skipping the first line as its header
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                AppModel model = new AppModel(Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), (nextLine[2]), nextLine[3],nextLine[4]);
                models.add(model);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return models;


    }

}
