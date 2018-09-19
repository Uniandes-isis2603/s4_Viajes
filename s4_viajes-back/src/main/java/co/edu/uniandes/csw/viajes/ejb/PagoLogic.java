/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viajes.persistence.ComboPersistence;
import co.edu.uniandes.csw.viajes.persistence.PagoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
public class PagoLogic {
     private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());

    @Inject
    private PagoPersistence persistence;

    @Inject
    private ComboPersistence comboPersistence;

    /**
     * Guardar un nuevo pago
     *
     * @param pagoEntity La entidad de tipo PagoEntity del nuevo pago a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException tiene un combo invalido o ya existe en la
     * persistencia.
     */
    public PagoEntity createPago(PagoEntity pagoEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del pago");
        if(pagoEntity==null)
            throw new BusinessLogicException("Error en el formato.");

//        if (pagoEntity.getaPagar() == null || comboPersistence.find(pagoEntity.getaPagar().getId()) == null) {
//            throw new BusinessLogicException("El combo es del pago es invalido");
//        }
         if (pagoEntity.getaPagar() == null) {
            throw new BusinessLogicException("El pago es inválido");
        }
         if (pagoEntity.getaPagar().getActividades().isEmpty()
                 &&pagoEntity.getaPagar().getAlojamientos().isEmpty()
                 &&pagoEntity.getaPagar().getTransportesTerrestres().isEmpty()
                 &&pagoEntity.getaPagar().getVuelos().isEmpty()) {
            throw new BusinessLogicException("El combo que se desea pagar se encuentra vacio");
        }
         
         if(pagoEntity.isPagaConTarjeta())
         {
             String tarjeta=pagoEntity.getTarjeta();
             if(tarjeta.trim().equals(""))
                throw new BusinessLogicException("No introdujo ninguna tarjeta");
//              revisar resto reglas de negocio sobre una tarjeta
            if(tarjeta.length()!=16)
                throw new BusinessLogicException("Debe ingresar los 16 caracteres que componen la tarjeta");
            try
            {
                Integer.parseInt(tarjeta.substring(0,8));
                Integer.parseInt(tarjeta.substring(8));
            }
            catch(Exception e)
            {
                throw new BusinessLogicException("La tarjeta de credito tiene caracteres no permitidos");
            }
            
         }
//      pagoEntity = persistence.create(pagoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del pago");
        return pagoEntity;
    }

    /**
     * Devuelve todos los pagos que hay en la base de datos.
     *
     * @return Lista de entidades de tipo pago.
     */
    public List<PagoEntity> getPagos() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los pagos");
         List<PagoEntity> pagos =new  ArrayList<PagoEntity>();
//        List<PagoEntity> pagos = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los pagos");
        return pagos;
    }

    /**
     * Busca un pago por ID
     *
     * @param pagoId El id del pago a buscar
     * @return El pago encontrado, null si no lo encuentra.
     */
    public PagoEntity getPago(Long pagoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el pago con id = {0}", pagoId);
       PagoEntity pagoEntity =new PagoEntity();
//        PagoEntity pagoEntity = persistence.find(pagoId);
        if (pagoEntity == null) {
            LOGGER.log(Level.SEVERE, "El pago con el id = {0} no existe", pagoId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el pago con id = {0}", pagoId);
        return pagoEntity;
    }

    /**
     * Actualizar un libro por ID
     *
     * @param pagoId El ID del libro a actualizar
     * @param pagoEntity La entidad del libro con los cambios deseados
     * @return La entidad del libro luego de actualizarla
     * @throws BusinessLogicException Si el IBN de la actualización es inválido
     */
    public PagoEntity updatePago(Long pagoId, PagoEntity pagoEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el pago con id = {0}", pagoId);
          if(pagoEntity==null)
            throw new BusinessLogicException("Error en el formato.");

//        if (pagoEntity.getaPagar() == null || comboPersistence.find(pagoEntity.getaPagar().getId()) == null) {
//            throw new BusinessLogicException("El combo es del pago es invalido");
//        }
         if (pagoEntity.getaPagar() == null) {
            throw new BusinessLogicException("El pago es inválido");
        }
         if (pagoEntity.getaPagar().getActividades().isEmpty()
                 &&pagoEntity.getaPagar().getAlojamientos().isEmpty()
                 &&pagoEntity.getaPagar().getTransportesTerrestres().isEmpty()
                 &&pagoEntity.getaPagar().getVuelos().isEmpty()) {
            throw new BusinessLogicException("El combo que se desea pagar se encuentra vacio");
        }
         
         if(pagoEntity.isPagaConTarjeta())
         {
             String tarjeta=pagoEntity.getTarjeta();
             if(tarjeta.trim().equals(""))
                throw new BusinessLogicException("No introdujo ninguna tarjeta");
//              revisar resto reglas de negocio sobre una tarjeta
            if(tarjeta.length()!=16)
                throw new BusinessLogicException("Debe ingresar los 16 caracteres que componen la tarjeta");
            try
            {
                Integer.parseInt(tarjeta.substring(0,8));
                Integer.parseInt(tarjeta.substring(8));
            }
            catch(Exception e)
            {
                throw new BusinessLogicException("La tarjeta de credito tiene caracteres no permitidos");
            }
            
         }
//      PagoEntity newEntity = persistence.update(pagoEntity);
        PagoEntity newEntity = new PagoEntity();
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el pago con id = {0}", pagoEntity.getId());
        return newEntity;
    }

    /**
     * Eliminar un pago por ID
     *
     * @param pagoId El ID del pago a eliminar
     * @throws BusinessLogicException si el pago...
     */
    public void deletePago(Long pagoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el pago con id = {0}", pagoId);
        if(pagoId == null)
          throw new BusinessLogicException("Identificador del pago inexistente.");

//      persistence.delete(pagoId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el pago con id = {0}", pagoId);
    }


}
