/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class UsuarioLogic {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class.getName());


    

public UsuarioEntity createUsuario(UsuarioEntity usuarioEntity)    throws BusinessLogicException{
    
    LOGGER.log(Level.INFO, "Inicia el proceso de creación del usuario");
    LOGGER.log(Level.INFO, "Inicia el proceso de creación del usuario");
    
    return usuarioEntity;
    
}
    
    
}
