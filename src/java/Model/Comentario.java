/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author JuanSosa
 */
public class Comentario {
    private int idComentario;
    private int idNoticia;
    private int idUsuario;
    private String correo;
    private String alias;
    private Date fecha;

    public Comentario(){}
    public Comentario(
            int idComentario,
            int idNoticia,
            int idUsuario,
            String correo,
            String alias,
            Date fecha
            )
    {
        this.setIdComentario(idComentario);
        this.setIdNoticia(idNoticia);
        this.setIdUsuario(idUsuario);
        this.setCorreo(correo);
        this.setAlias(alias);
        this.setFecha(fecha);
        
        
    }
    /**
     * @return the idComentario
     */
    public int getIdComentario() {
        return idComentario;
    }

    /**
     * @param idComentario the idComentario to set
     */
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    /**
     * @return the idNoticia
     */
    public int getIdNoticia() {
        return idNoticia;
    }

    /**
     * @param idNoticia the idNoticia to set
     */
    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
