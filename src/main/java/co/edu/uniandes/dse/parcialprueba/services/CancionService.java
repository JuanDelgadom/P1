package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.CancionEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.CancionRepository;
import jakarta.transaction.Transactional;

@Service
public class CancionService {

    @Autowired
    CancionRepository cancionRepository;

    @Transactional
    public CancionEntity CreateCancion(CancionEntity cancion) throws IllegalOperationException{
        if (cancion.getDuracion() <= 0)
            throw new IllegalOperationException("La duracion no es valida");
        return cancionRepository.save(cancion);
    }


    


}
