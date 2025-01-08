package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Db {
    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;
    private int ok;

    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection
                    (
                        Constantes.URL,
                        Constantes.USER,
                        Constantes.PASSWORD
                    );
        }catch (Exception e){
            System.out.println("Erreur de connexion á la BD : " + e.getMessage());
        }
    }

    public void initPrepar(String sql){
        try{
            connect();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeSelect(){
        rs = null;
        try{
            rs = pstm.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public int executeMaj(){
        try{
            ok = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    public void closeConnection(){
        try{
            if (cnx != null)
                cnx.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}
