/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;


/**
 *
 * @author n.segura
 */
@Entity
public class UsuarioEntity extends BaseEntity implements Serializable{
    
    private int edad;
    private String documento;
    private String nombre;
    private String userName;
    private String password;
    
    
    @PodamExclude
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PagoEntity> pagos = new ArrayList<PagoEntity>();
    
    @PodamExclude
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComboEntity> combos = new ArrayList<ComboEntity>();
    
    
    @PodamExclude
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EntradaEntity> entradas = new ArrayList<EntradaEntity>();
    
    @PodamExclude
    @OneToMany
    private List<MedallaEntity> medallas = new ArrayList<MedallaEntity>();
    
      /**
     * Devuelve la edad del usuario.
     *
     * @return the edad
     */
    public int getEdad()
    {
        return edad;
    }
     /**
     * Devuelve el documento del usuario.
     *
     * @return the documento
     */
    public String getDocumento()
    {
        return documento;
    }
    
     /**
     * Devuelve la contraseña del usuario.
     *
     * @return the documento
     */
    public String getPassword() {
        return password;
    }

     /**
     * Modifica la contraseña del usuario.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
     /**
     * Devuelve el nombre del usuario.
     *
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }
     /**
     * Devuelve el user name del usuario.
     *
     * @return the user name
     */
    
    public String getUserName()
    {
        return userName;
    }
    
     /**
     * Devuelve la lista de pagos del usuario.
     *
     * @return the user name
     */
    
    public List<PagoEntity> getPagos()
    {
        return pagos;
    }
    
    
    
     /**
     * Devuelve la lista de combos del usuario.
     *
     * @return the list of combos
     */
    
    public List<ComboEntity> getCombos()
    {
        return combos;
    }
    
      /**
     * Devuelve la lista de entradas del usuario.
     *
     * @return lista de entradas
     */
    
    public List<EntradaEntity> getEntradas()
    {
        return entradas;
    }
    
          /**
     * Devuelve la lista de medalla del usuario.
     *
     * @return lista de medallas
     */
    
    public List<MedallaEntity> getMedallas()
    {
        return medallas;
    }
    
      /**
     * Actualiza la lista de entradas del usuario con la que entra por parametro.
     *
     * @param pEntradas nueva lista de entradas
     */
    
    public void setEntradas(List<EntradaEntity> pEntradas)
    {
        this.entradas = pEntradas;
    }
    
    
     /**
     * Actualiza la lista de combos del usuario con la que entra por parametro.
     *
     * @param pCombos nueva lista de combos
     */
    
    public void setCombos(List<ComboEntity> pCombos)
    {
        this.combos = pCombos;
    }
    
    
     /**
     * Actualiza la lista de medallas del usuario con la que entra por parametro.
     *
     * @param pMedallas nueva lista de medallas
     */
    
    public void setMedallas(List<MedallaEntity> pMedallas)
    {
        this.medallas = pMedallas;
    }
    
         /**
     *  Cambia la lista de pagos
     * @param pagos la lista de pagos con la que se actualiza la informacion.
     */
    public void setPagos(List<PagoEntity> pagos)
            
    {
        this.pagos = pagos;
        
    }
    
     /**
     * Modifica la edad del usuario.
     *
     * @param pEdad
     */
     public void setEdad(int pEdad)
    {
        this.edad = pEdad;
    }
    
     /**
     * Modifica el documento del usuario.
     *
     * @param pDocumento
     */
    public void setDocumento(String pDocumento)
    {
       this.documento = pDocumento;
    }
    
     /**
     * Modifica el UserName del usuario.
     *
     * @param pUserName 
     */
    public void setUserName(String pUserName)
    {
       this.userName= pUserName;
    }
    
    
     /**
     * Modifica el nombre del usuario.
     *
     * @param pNombre 
     */  
     public void setNombre(String pNombre)
    {
       this.nombre= pNombre;
    } 
    
}
