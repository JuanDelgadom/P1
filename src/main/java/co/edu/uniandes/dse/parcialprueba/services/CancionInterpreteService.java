package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.CancionEntity;
import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.repositories.CancionRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.InterpreteRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Slf4j
@Service
public class CancionInterpreteService {

    @Autowired
	private InterpreteRepository interpreteRepository;

	@Autowired
	private CancionRepository cancionRepository;

    public InterpreteEntity addInterpreteEntity(Long cancion, Long interprete) throws EntityNotFoundException {
		log.info("Inicia proceso de agregarle un estudiante al asesor con id = {0}", asesorId);
        Optional<InterpreteEntity> interpreteEntity = interpreteRepository.findById(interprete);

        Optional<CancionEntity> cancionEntity = cancionRepository.findById(cancion);
        cancionEntity.get().getInterpretes().add(interpreteEntity.get());
        log.info("Termina proceso de agregarle un estudiante al asesor con id = {0}", asesorId);
		return cancionEntity.get();
    }

}
