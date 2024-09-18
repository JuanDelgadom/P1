package co.edu.uniandes.dse.parcialprueba.entities;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class InterpreteEntity {

    @Id
    Long id;
    @NotBlank
    String nombre;
    @NotBlank
    String instrumento;
    @NotBlank
    String biografia;

    @ManyToMany
    List<CancionEntity> canciones = new ArrayList<>();

}
