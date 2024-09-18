package co.edu.uniandes.dse.parcialprueba.entities;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.ArrayList;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class CancionEntity extends BaseEntity {

    @Id
    Long id;
    @NotBlank
    String titulo;
    @NotBlank
    Integer duracion;
    @NotBlank
    String genero;

    @ManyToMany
    @PodamExclude
    List<InterpreteEntity> interpretes = new ArrayList<>();
}
