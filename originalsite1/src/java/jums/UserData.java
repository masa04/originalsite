package jums;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UserData implements Serializable{
    private int userID;
    private String name;
    private String pass;
    private int age;
    private String sex;
    private int height;
    private Timestamp newDate;
    private int deleteFlg;
    private int weight;
    private int calorie;
    private Timestamp recordnewDate;
    
    public UserData(){
        this.userID = 0;
        this.name = "";
        this.pass = "";
        this.age = 0;
        this.sex = "";
        this.height = 0;
        this.deleteFlg = 0;
        this.weight = 0;
        this.calorie = 0;
    }
    
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID=userID;
        }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }
    
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        if(pass.trim().length()==0){
            this.pass = "";
        }else{
            this.pass = pass;
        }
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(String age){
        if(age.equals("")){
            this.age = 0;
        }else{
            this.age += Integer.parseInt(age);
        }
    }
    
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        if(sex.equals("")){
            this.sex = "";
        }else{
            this.sex += sex;
        }
    }
    
    public int getHeight(){
        return height;
    }
    public void setHeight(String height){
        if(height.equals("")){
            this.height = 0;
        }else{
            this.height += Integer.parseInt(height);
        }
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
    
    public int getWeight(){
        return weight;
    }
    public void setWeight(String weight){
        if(weight.equals("")){
            this.weight = 0;
        }else{
            this.weight = Integer.parseInt(weight);
        }
    }
    
    public int getCalorie() {
        return calorie;
    }
    public void setCalorie(String calorie) {
        if(calorie == null){
            this.calorie = 0;
        }else{
            this.calorie = Integer.parseInt(calorie);
        }
    }
    
    public Timestamp getRecordnewDate(){
        return newDate;
    }
    public void setRecordnewDate(Timestamp recordnewDate){
        this.recordnewDate = recordnewDate;
    }
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.pass.equals("")){
            chkList.add("pass");
        }
        if(this.age == 0){
            chkList.add("age");
        }
        if(this.height == 0){
            chkList.add("height");
        }
        return chkList;
    }
    
    public ArrayList<String> chkproperties2(){
        ArrayList<String> chkList2 = new ArrayList<String>();
        if(this.weight == 0){
            chkList2.add("weight");
        }
        if(this.calorie == 0){
            chkList2.add("calorie");
        }
        return chkList2;
    }

    public void UD2DTOMapping(UserDataDTO udd){
        udd.setUserID(this.userID);
        udd.setName(this.name);
        udd.setPass(this.pass);
        udd.setAge(this.age);
        udd.setSex(this.sex);
        udd.setHeight(this.height);
        udd.setNewDate(this.newDate);
        udd.setDeleteFlg(this.deleteFlg);
        udd.setWeight(this.weight);
        udd.setCalorie(this.calorie);
        udd.setRecordnewDate(this.recordnewDate);
    }
    
    public void UD2BeansMapping(UserDataDTO udd){
        this.userID=udd.getUserID();
        this.name=udd.getName();
        this.pass=udd.getPass();
        this.age=udd.getAge();
        this.sex=udd.getSex();
        this.height=udd.getHeight();
        this.newDate=udd.getNewDate();
        this.setDeleteFlg(udd.getDeleteFlg());
        this.weight=udd.getWeight();
        this.calorie=udd.getCalorie();
        this.recordnewDate=udd.getRecordnewDate();
    }
}