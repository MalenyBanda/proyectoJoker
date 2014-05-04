/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author JuanSosa
 */
public class Seccion {
    private int seccionId;
    private String seccion;
    private int ordenId;
    
    public Seccion(){}
    public Seccion(int seccionId,String seccion)
    {
        this.setSeccion(seccion);
        this.setSeccionId(seccionId);
    }
    public Seccion(int seccionId,String seccion,int ordenId)
    {
        this.setSeccion(seccion);
        this.setSeccionId(seccionId);
        this.setOrdenId(ordenId);
    }

    /**
     * @return the seccionId
     */
    public int getSeccionId() {
        return seccionId;
    }

    /**
     * @param seccionId the seccionId to set
     */
    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return the ordenId
     */
    public int getOrdenId() {
        return ordenId;
    }

    /**
     * @param ordenId the ordenId to set
     */
    public void setOrdenId(int ordenId) {
        this.ordenId = ordenId;
    }
    
    
    
}
