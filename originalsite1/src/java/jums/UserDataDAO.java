package jums;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化する処理
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user(name,password,age,sex,height,newDate,deleteFlg) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            st.setInt(3, ud.getAge());
            st.setString(4, ud.getSex());
            st.setInt(5, ud.getHeight());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7,ud.getDeleteFlg());
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザー名とパスワードによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを所持しているJavaBeans
     * @return 検索結果
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public UserDataDTO search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            ResultSet rs = st.executeQuery();
        
            UserDataDTO resultUd = new UserDataDTO();
            while(rs.next()){
            resultUd.setUserID(rs.getInt("userID"));
            resultUd.setName(rs.getString("name"));
            resultUd.setPass(rs.getString("password"));
            resultUd.setAge(rs.getInt("age"));
            resultUd.setSex(rs.getString("sex"));
            resultUd.setHeight(rs.getInt("height"));
            resultUd.setNewDate(rs.getTimestamp("newDate"));
            resultUd.setDeleteFlg(rs.getInt("deleteFlg"));
            }           
            System.out.println("search completed");
            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
   
    
    /**
     * ユーザー情報の更新処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 
     */
    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user SET name = ?, password = ?, age = ?, height = ? WHERE userID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            st.setInt(3, ud.getAge());
            st.setInt(4, ud.getHeight());
            st.setInt(5, ud.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの削除処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user SET name= ?, password= ?, age= ?, sex= ?, newDate= ?, deleteFlg=? WHERE userID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            st.setInt(3, ud.getAge());
            st.setString(4, ud.getSex());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, 1); //deleteFlgを1に変更して論理削除 ログイン判定がdeleteFlg=0でログイン可なのでログインできなくなる
            st.setInt(7, ud.getUserID());
            st.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
     /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void recordinsert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO record(userID,weight,calorie,recordnewDate) VALUES(?,?,?,?)");
            st.setInt(1, ud.getUserID());
            st.setInt(2, ud.getWeight());
            st.setInt(3, ud.getCalorie());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザーの体重とカロリー情報データの複数検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @return 
     * @throws SQLException 
     */
    public ArrayList<UserDataDTO> recordsearch(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "SELECT * FROM record WHERE userID = ?";
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            ResultSet rs = st.executeQuery();
        
            ArrayList<UserDataDTO>recordlist=new ArrayList<UserDataDTO>();
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt("userID"));
                resultUd.setWeight(rs.getInt("weight"));
                resultUd.setCalorie(rs.getInt("calorie"));
                recordlist.add(resultUd);
                System.out.println(resultUd.getWeight());
            }          
            System.out.println("recordlist completed");
            return recordlist;    
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
     /**
     * ユーザーの体重とカロリー情報データの複数検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @return 
     * @throws SQLException 
     */
    public UserDataDTO bmical(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "SELECT * FROM record WHERE userID = ?";
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            ResultSet rs = st.executeQuery();
        
            UserDataDTO resultUd = new UserDataDTO();
            while(rs.next()){
            resultUd.setUserID(rs.getInt("userID"));
            resultUd.setWeight(rs.getInt("weight"));
            }           
            System.out.println("search completed");
            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}

