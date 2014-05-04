/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JuanSosa
 */
public class Usuario {
    private DataBase db;
    private ResultSet rs;
    CallableStatement procedure;
    
    public Usuario()
    {
        this.db= new DataBase(); 
    }
    
    public boolean RegistrarUsuario(Model.Usuario usr)
    {       
        try
        {
            
            db.Open();
            Connection conexion= db.getConexion();           
            procedure = conexion.prepareCall("{Call jc_sp_insert_usuario"+"(?,?,?,?,?,?,?,?,?)}");
            procedure.setInt("idTipoUsuarioP", usr.getIdTipoUsuario());
            procedure.setString("sexoP", usr.getSexo());
            procedure.setString("correoP", usr.getCorreo());
            procedure.setString("contrasenaP", usr.getContraseña());
            procedure.setString("nombreP", usr.getNombre());
            procedure.setString("apellido1P", usr.getApellidoPaterno());
            procedure.setString("apellido2P", usr.getApellidoMaterno());
            procedure.setString("nicknameP", usr.getNickname());
            procedure.setString("telefonoP",usr.getTelefono());
            if(procedure.executeUpdate()>0)
            {
                db.getConexion().commit();
                return true;
            } 
            else
            {
                return false;
            }
        }
        catch(Exception ex)
        {
            String r = ex.getMessage();            
            return false;
        }
        finally
        {
            db.Close();
        }
    }
    
    public  void LogIn(Model.Usuario usr)
    {}
    
    public  boolean EliminarUsuario(Model.Usuario usr)
    {
        try{
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_delete_usuario(?)");
            procedure.setInt("idUsuarioP", usr.getIdUsuario());
            if (procedure.executeUpdate()>0){
            db.getConexion().commit();
            return true;
            }else{
                return false;
            }
        }catch(Exception error){
        return false;
        }finally{db.Close();}
    }
    
    public Model.Usuario TraerInfoUsuario(Model.Usuario usr)
    {
        //Realiza un select en la tabla usuario de los datos en base al id del usuario
        try
        {
            db.Open();
            this.procedure=db.getConexion().prepareCall("call jc_sp_select_usuario(?);");
            procedure.setInt("idUsuarioP", usr.getIdUsuario());
            rs=procedure.executeQuery();
            int rows=rs.getFetchSize();
            if(rs.isBeforeFirst())
            {
                rs.next();
                return new Model.Usuario(rs.getInt("IdUsuario"),
                        rs.getInt("idTipoUsuario"),
                        rs.getString("tipoUsuario"),
                        rs.getString("sexo"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("nickname"),
                        rs.getString("telefono"));                
            }          
             return null;
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
    
    public  boolean ActualizarUsuario(Model.Usuario usr)
    {
            try{
            db.Open();
            procedure= db.getConexion().prepareCall("call jc_sp_update_usuario(?,?,?,?,?,?,?,?,?)");
            procedure.setInt("idUsuarioP", usr.getIdUsuario());
            procedure.setInt("idTipoUsuarioP", usr.getIdTipoUsuario());
            procedure.setString("sexoP", usr.getSexo());
            procedure.setString("correoP", usr.getCorreo());
            procedure.setString("contrasenaP", usr.getContraseña());
            procedure.setString("nombreP", usr.getNombre());
            procedure.setString("apellido1P", usr.getApellidoPaterno());
            procedure.setString("apellido2P", usr.getApellidoMaterno());
            procedure.setString("nicknameP", usr.getNickname());
            procedure.setString("telefonoP",usr.getTelefono());
            if (procedure.executeUpdate()>0){
            db.getConexion().commit();
            return true;
            }else{
                return false;
            }
        }catch(Exception error){
        return false;
        }finally{db.Close();}
    }
}
