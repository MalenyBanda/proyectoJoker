/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanSosa
 */
public class Seccion {
     private DataBase db;
     private ResultSet rs;
     private CallableStatement procedure;    
    
    public Seccion()
    {
        this.db= new DataBase();
    }
    
    public boolean AgregarSeccion(Model.Seccion nombre)
    {
        try {
            db.Open();
            procedure = db.getConexion().prepareCall("call jc_sp_insert_seccion(?)");
            procedure.setString("seccionP",nombre.getSeccion());
            if (procedure.executeUpdate()>0){
                
            db.getConexion().commit();
            return true;
            }else{
            return false;
            }
           
        }catch(Exception error){
            return false;
        }
        finally{
        db.Close();
        }
        
    }
    
    public boolean EliminarSeccion(Model.Seccion seccion)
    {
        try{
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_delete_seccion(?);");
            procedure.setInt("idSeccionP",seccion.getSeccionId());
            if(procedure.executeUpdate()>0)
            {
                db.getConexion().commit();
                return true;
            }
            else
            {
                return false;
            }            
        }catch(Exception Error)
        {
             return false;          
        }finally
        {
            db.Close();
        }
       
    } 
    
    public List<Model.Seccion> TraerSecciones()
    {
        //Regresa una lista con todas las secciones almacenadas en la base de datos
        List<Model.Seccion> list= new ArrayList<Model.Seccion>();
        try
        {
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_select_seccion()");
            rs=procedure.executeQuery();
            if(rs.isBeforeFirst())
            {
                rs.next();
                while(!rs.isAfterLast())
                {                    
                    list.add(new Model.Seccion(
                            rs.getInt("idSeccion"),
                            rs.getString("seccion")));
                    rs.next();
                }   
                return list;
            }    
            else
            {
                return null;
            }            
        }
        catch(Exception ex)
        {
             return null;
        }
        finally
        {
            db.Close();
        }
    }
}
