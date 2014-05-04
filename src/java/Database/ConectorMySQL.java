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
 * Clase para realizar una concexion xon servio MYSQL
 *
 * @author JuanSosa
 */
public class ConectorMySQL {

    private static String database="nuevofcfm";
    private static String server="localhost:3306";
    private static String user="root";
    private static String password="123456789";
    private Connection conexion;

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

    public ConectorMySQL() {
         try {
            // The newInstance() call is a work around for some
            // broken Java implementations
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            //open();
            //conexion.
            
        } catch (Exception ex) {
            // handle the error
            System.out.print("No es posible cerrar la Conexion");
        }
    }
    private void open()
    {
        try
        {
            //"jdbc:mysql://localhost/test"
            conexion=DriverManager.getConnection("jdbc:mysql://"+server+"/"+database, user, password);
            conexion.setAutoCommit(false);
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
    }
    
    public ResultSet ExecProcedure(String procedurename)
    {
        try
        {     
            open();
            CallableStatement procedure = conexion.prepareCall("{call "+ procedurename+"(?)}");
            //procedure.setInt("seccion", null);
            procedure.setNull("_seccionId",0);
            return procedure.executeQuery();
            
        }
        catch(SQLException ex)
        {
            return null;
        }
        finally
        {
            try
            {
                conexion.close();
            }
            catch(SQLException ex )
            {}
        }  
    }
    
    public ResultSet ExecProcedure(String procedurename,List<Parametro> params)
    {
         try
        {     
            String s_procedure="{call "+ procedurename+"(";
            open();
            for(int i=0;i<params.size();i++)
            {
                if(i==params.size()-1)
                {s_procedure+="?)}";}
                else{s_procedure+="?,";}
            }
            CallableStatement procedure = conexion.prepareCall(s_procedure);
            for(Parametro pr : params)
            {
               procedure.setObject(pr.getNombre(), pr.getValor());
            };
            
            return procedure.executeQuery();
            
        }
        catch(SQLException ex)
        {
            return null;
        }
        finally
        {
            try
            {
                conexion.close();
            }
            catch(SQLException ex )
            {}
    }

    }
}
