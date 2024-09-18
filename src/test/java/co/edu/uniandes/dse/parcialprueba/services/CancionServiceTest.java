package co.edu.uniandes.dse.parcialprueba.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcialprueba.entities.CancionEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
@Import(CancionService.class)
public class CancionServiceTest {

    @Autowired
    CancionService cancionService;

    private PodamFactory factory = new PodamFactoryImpl();



    @Test
    public void CreateCancion() throws IllegalOperationException{
        CancionEntity cancionEntity = factory.manufacturePojo(CancionEntity.class);
        cancionEntity.setDuracion(10);
        cancionService.CreateCancion(cancionEntity);
    } 

    @Test
    public void CreateCancionWithInvalidDuracion() throws IllegalOperationException{
        assertThrows(IllegalOperationException.class, () -> {
            CancionEntity cancionEntity = factory.manufacturePojo(CancionEntity.class);
            cancionEntity.setDuracion(0);
            cancionService.CreateCancion(cancionEntity);
        });
    } 
}


