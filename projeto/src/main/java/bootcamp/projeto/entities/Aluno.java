package bootcamp.projeto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.*;
import javax.persistence.*;

@Getter
@Setter
@Table(name = "ALUNO")
@Entity(name = "ALUNO")
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @Column(nullable = false, length = 8, columnDefinition = "CHAR")
    private String matricula;

    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR", length = 8)
    @Pattern(regexp = "[0-9]", message = "O NIF só pode conter números")
    private String cpf;

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @Column(nullable = false, columnDefinition = "CHAR")
    private String sexo;

    @Min(6)
    @Max(16)
    private Integer idade;


    private int escolaridade;

}
