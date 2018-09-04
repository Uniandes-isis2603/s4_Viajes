/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.test.persistence;

import co.edu.uniandes.csw.viajes.entities.VueloEntity;
import co.edu.uniandes.csw.viajes.persistence.VueloPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de persistencia de Vuelo
 *
 * @author jf.torresp
 */
@RunWith(Arquillian.class)
public class VueloPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase VueloPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private VueloPersistence vueloPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    /**
     * Lista que tiene los datos de prueba.
     */
    private List<VueloEntity> data = new ArrayList<VueloEntity>();
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Vuelo, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VueloEntity.class.getPackage())
                .addPackage(VueloPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from VueloEntity").executeUpdate();
    }
    
        /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {

            VueloEntity entity = factory.manufacturePojo(VueloEntity.class);

            em.persist(entity);

            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Vuelo.
     */
    @Test
    public void createVueloTest() {
        PodamFactory factory = new PodamFactoryImpl();
        VueloEntity newEntity = factory.manufacturePojo(VueloEntity.class);
        VueloEntity result = vueloPersistence.create(newEntity);

        Assert.assertNotNull(result);

        VueloEntity entity = em.find(VueloEntity.class, result.getNumero());

        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
    }
    
        /**
     * Prueba para consultar la lista de Vuelos.
     *
     *
     */
    @Test
    public void getVuelosTest() {
        List<VueloEntity> list = vueloPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (VueloEntity ent : list) {
            boolean found = false;
            for (VueloEntity entity : data) {
                if (ent.getNumero().equals(entity.getNumero())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Vuelo.
     *
     *
     */
    @Test
        public void getVueloTest() {
        VueloEntity entity = data.get(0);
        VueloEntity newEntity = vueloPersistence.find(entity.getNumero());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
    }

    /**
     * Prueba para eliminar un Vuelo.
     *
     *
     */
    @Test
    public void deleteVueloTest() {
        VueloEntity entity = data.get(0);
        vueloPersistence.delete(entity.getNumero());
        VueloEntity deleted = em.find(VueloEntity.class, entity.getNumero());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Vuelo.
     *
     *
     */
    @Test
    public void updateVueloTest() {
        VueloEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VueloEntity newEntity = factory.manufacturePojo(VueloEntity.class);

        newEntity.setNumero(entity.getNumero());

        vueloPersistence.update(newEntity);

        VueloEntity resp = em.find(VueloEntity.class, entity.getNumero());

        Assert.assertEquals(newEntity.getNumero(), resp.getNumero());
    }

    
}
