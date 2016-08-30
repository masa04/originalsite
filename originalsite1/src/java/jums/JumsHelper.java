package jums;

import java.util.ArrayList;

public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("name")){
                    output += "名前";
                }
                if(val.equals("pass")){
                    output +="パスワード";
                }
                if(val.equals("age")){
                    output +="年齢";
                }
                if(val.equals("sex")){
                    output +="性別";
                }
                if(val.equals("height")){
                    output +="身長";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    //体重、カロリーの未入力のチェックリスト
    public String chkinput2(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
                if(val.equals("weight")){
                    output += "体重";
                }
                if(val.equals("calorie")){
                    output +="カロリー";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
}

