package co.edu.uniandes.dse.parcialprueba.repositories;

import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InterpreteRepository extends JpaRepository<InterpreteEntity, Long>{

}
