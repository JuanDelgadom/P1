package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.InterpreteRepository;
import jakarta.transaction.Transactional;

@Service
public class InterpreteService {

    @Autowired
    InterpreteRepository interpreteRepository;

    @Transactional
    public InterpreteEntity createInterprete(InterpreteEntity interprete) throws IllegalOperationException{

        if(interprete.getNombre().isEmpty()){
            throw new IllegalOperationException("El nombre esta vacio");
        }
        
        return interpreteRepository.save(interprete);
    }

}
