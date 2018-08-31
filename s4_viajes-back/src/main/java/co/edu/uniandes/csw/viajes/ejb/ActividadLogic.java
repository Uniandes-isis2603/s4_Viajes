/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.ActividadEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */

@Stateless
public class ActividadLogic {
     private static final Logger LOGGER = Logger.getLogger(ActividadLogic.class.getName());

    @Inject
    //private EditorialPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Crea una actividad en la persistencia.
     *
     * @param actividadEntity La entidad que representa la editorial a
     * persistir.
     * @return La entiddad de la editorial luego de persistirla.
     * @throws BusinessLogicException Si la editorial a persistir ya existe.
     */
    public ActividadEntity createActividad(ActividadEntity editorialEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la editorial");
        // Verifica la regla de negocio que dice que no puede haber dos editoriales con el mismo nombre
        /**if (persistence.findByName(editorialEntity.getName()) != null) {
            throw new BusinessLogicException("Ya existe una Editorial con el nombre \"" + editorialEntity.getName() + "\"");
        }
        // Invoca la persistencia para crear la editorial
        persistence.create(editorialEntity);**/
        LOGGER.log(Level.INFO, "Termina proceso de creación de la actividad");
        return editorialEntity;
    }

    /**
     * Borrar un editorial
     *
     * @param editorialsId: id de la editorial a borrar
     */
    public void deleteActividad(Long editorialsId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la editorial con id = {0}", editorialsId);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        //persistence.delete(editorialsId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la editorial con id = {0}", editorialsId);
    }

    public ActividadEntity getActividad(Long actividadId) {
        
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la editorial con id = {0}", actividadId);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        
        /**PERSISTENCIA
        //ActividadEntity editorialEntity = persistence.find(editorialsId);
        if (ActividadEntity == null) {
            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", actividadId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la editorial con id = {0}", actividadId);
        return editorialEntity;**/
        return new ActividadEntity();
        
    }
    
    public ActividadEntity modificarActividad(Long id, ActividadEntity actividadEntity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la actividad con id = {0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        /**PERSISTENCIA
        ActividadEntity newEntity = persistence.update(editorialEntity);**/
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la actividad con id = {0}", actividadEntity.getId());
        return new ActividadEntity();
    }

   
    
}
