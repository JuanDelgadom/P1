package co.edu.uniandes.dse.parcialprueba.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcialprueba.entities.CancionEntity;
import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@DataJpaTest
@Transactional
@Import(InterpreteService.class)
public class InterpreteServiceTest {

    @Autowired
    InterpreteService interpreteService;

    private PodamFactory factory = new PodamFactoryImpl();

    @Test
    public void createInterprete() throws IllegalOperationException{
        InterpreteEntity interpreteEntity = factory.manufacturePojo(InterpreteEntity.class);
        interpreteEntity.setNombre("efdfd");
        interpreteService.createInterprete(interpreteEntity);
    } 

    @Test
    public void CreateInterpreteWithInvalidName() throws IllegalOperationException{
        assertThrows(IllegalOperationException.class, () -> {
            InterpreteEntity interpreteEntity = factory.manufacturePojo(InterpreteEntity.class);
            interpreteEntity.setNombre("");
            interpreteService.createInterprete(interpreteEntity);
        });
    } 
    


}
