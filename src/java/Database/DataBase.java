/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import NoticiasFCFM.Parametro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author JuanSosa
 */
public class DataBase {
    private static String database="jcfcfmnew";
    private static String server="192.168.0.7";//"localhost:3306";
    private static String user="root";
    private static String password="123456789";    
    private Connection conexion;  
    
    public DataBase()
    {
         try {

             Class.forName("com.mysql.jdbc.Driver").newInstance();         
            
        } catch (Exception ex) {
            // handle the error
            System.out.print("No es posible cerrar la Conexion");
        }
    }
    
    public void Open()
    {
         try
        {
            //"jdbc:mysql://localhost/test"
            conexion=DriverManager.getConnection("jdbc:mysql://"+getServer()+"/"+getDatabase(), getUser(), getPassword());
            conexion.setAutoCommit(false);
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
    }
    public void Close()
    {
        try
        {
            conexion.close();
        }
        catch(SQLException ex)
        {}
    }
    /**
     * @return the database
     */
    public static String getDatabase() {
        return database;
    }

    /**
     * @param aDatabase the database to set
     */
    public static void setDatabase(String aDatabase) {
        database = aDatabase;
    }

    /**
     * @return the server
     */
    public static String getServer() {
        return server;
    }

    /**
     * @param aServer the server to set
     */
    public static void setServer(String aServer) {
        server = aServer;
    }

    /**
     * @return the user
     */
    public static String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(String aUser) {
        user = aUser;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }
    

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        //Open();
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}
