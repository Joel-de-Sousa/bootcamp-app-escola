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
    @Size(min = 8,max = 8, message = "Matricula deve conter 8 caracteres")
    private String matricula;

    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR", length = 8)
    @Size(min = 8,max = 8, message = "Formato de NIF inválido")
    private String cpf;

    @NotEmpty(message = "O nome é obrigatório!")
    @Size(min = 5, max = 30, message = "O nome deve conter pelo menos 5 caracteres")
    private String nome;

    @Column(nullable = false, columnDefinition = "CHAR")
    @NotBlank(message = "Campo obrigatório")
    private String sexo;

    @Min(value = 6, message = "Idade mínima de inscrição são 6 anos")
    @Max(value = 17, message = "Idade máxima de inscrição sao 17 anos")
    private Integer idade;


    private int escolaridade;

}
