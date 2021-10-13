package com.example.agriculture.models;

public class AppModel {
    int _id;
    int parentId;
    String name;
    String type;
    String data;

    public AppModel(int _id, int parentId, String name, String type, String data) {
        this._id = _id;
        this.parentId = parentId;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
