/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoticiasFCFM;

/**
 *
 * @author JuanSosa
 */
public class Parametro {
    private String _nombre;
    private String _tipo;
    private String _valor;

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @return the _tipo
     */
    public String getTipo() {
        return _tipo;
    }
    
    public Parametro(String nombre,String valor,String tipo)
    {
        this._nombre=nombre;
        this._tipo=tipo;
        this._valor=valor;
    }

    /**
     * @return the _valor
     */
    public String getValor() {
        return _valor;
    }
}
