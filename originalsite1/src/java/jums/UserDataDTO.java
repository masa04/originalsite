package jums;

import java.sql.Timestamp;

public class UserDataDTO {
    private int userID;
    private String name;
    private String pass;
    private int age;
    private String sex;
    private int height;
    private Timestamp newDate;
    private int deleteFlg;
    private int recordID;
    private int weight;
    private int calorie;
    private Timestamp recordnewDate;
    
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age= age;
    }
    
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex= sex;
    }
    
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height= height;
    }
    
    public Timestamp getNewDate(){
        return newDate;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
    public int getDeleteFlg(){
        return deleteFlg;
    }
    public void setDeleteFlg(int deleteFlg){
        this.deleteFlg = deleteFlg;
    }
    
    public int getRecordID(){
        return recordID;
    }
    public void setRecordID(int recordID){
        this.recordID = recordID;
    }
    
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public int getCalorie(){
        return calorie;
    }
    public void setCalorie(int calorie){
        this.calorie = calorie;
    }
    
    public Timestamp getRecordnewDate(){
        return recordnewDate;
    }
    public void setRecordnewDate(Timestamp recordnewDate){
        this.recordnewDate = recordnewDate;
    }
}