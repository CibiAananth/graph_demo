package com.sathees.demo;

/**
 * Created by Sathees on 13-06-2016.
 */
public class User {
    int _id;
    String _name;
    String _salary;
    public User(){

    }
    public User(int id, String name, String _salary){
        this._id = id;
        this._name = name;
        this._salary = _salary;
    }
    public User(String name, String _salary){
        this._name = name;
        this._salary = _salary;
    }
    public int getID(){
        return this._id;
    }
    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getSalary(){
        return this._salary;
    }

    public void setSalary(String salary){
        this._salary = salary;
    }

    public float retSalary(){
        int y = Integer.parseInt(this._salary);
        return y;
    }
}
