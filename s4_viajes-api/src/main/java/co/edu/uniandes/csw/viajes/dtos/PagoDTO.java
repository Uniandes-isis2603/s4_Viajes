/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ComboEntity;
import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author estudiante
 */
public class PagoDTO {
   
    private ReservaDTO aPagar;
    private Long id;
    private boolean pagaConTarjeta;
    private String tarjeta;
    private long idReservaAPagar;
    
    /**
     * Constructor vacio.
     */ 
    public PagoDTO(){}

    /**
     * Constructor por defecto.
     * @param pagoEntity Entidad del pago. 
     */ 
    public PagoDTO(PagoEntity pagoEntity){
        if(pagoEntity!=null)
        {
            if(pagoEntity.getaPagar()!=null)
                aPagar=new ReservaDTO(pagoEntity.getaPagar());
            else
                aPagar=null;
            id=pagoEntity.getId();
            pagaConTarjeta=pagoEntity.isPagaConTarjeta();
            tarjeta=pagoEntity.getTarjeta();
        }
    }

    public ReservaDTO getaPagar() {
        return aPagar;
    }

    public void setaPagar(ReservaDTO aPagar) {
        this.aPagar = aPagar;
    }

    public Long getPagoId() {
        return id;
    }

    public void setPagoId(Long pagoId) {
        this.id = pagoId;
    }

    public boolean isPagaConTarjeta() {
        return pagaConTarjeta;
    }

    public void setPagaConTarjeta(boolean pagaConTarjeta) {
        this.pagaConTarjeta = pagaConTarjeta;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
    public long getId() {
        return idReservaAPagar;
    }

    public void setId(long idReservaAPagar) {
        this.idReservaAPagar = idReservaAPagar;
    }
    
    /**
     * Método para transformar el DTO a una entidad.
     * @return La entidad del DTO asociado.
     */
      public PagoEntity toEntity() throws BusinessLogicException, Exception 
    {
        PagoEntity pagoEntity = new PagoEntity();
        pagoEntity.setPagaConTarjeta(pagaConTarjeta);
        pagoEntity.setIdReservaAPagar(idReservaAPagar);
        if(pagaConTarjeta)
            pagoEntity.setTarjeta(tarjeta);
        return pagoEntity; 
    }
      
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
