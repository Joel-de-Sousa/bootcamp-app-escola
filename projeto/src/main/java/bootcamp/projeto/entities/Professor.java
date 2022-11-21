package bootcamp.projeto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "PROFESSOR")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    @Size(min = 8,max = 8, message = "Formato de NIF inválido")
    private String cpf;

    @Column(name = "nome", nullable = false, columnDefinition = "CHAR")
    @NotEmpty(message = "O nome é obrigatório!")
    @Size(min = 5, max = 30, message = "O nome deve conter pelo menos 5 caracteres")
    private String nome;

    @Column(name = "sexo", columnDefinition = "CHAR")
    @NotBlank(message = "Campo obrigatório")
    private String sexo;

    @Column(name = "idade")
    @Min(value = 18, message = "Idade inválida")
    @Max(value = 70, message = "Idade inválida")
    private int idade;

    @Column(name = "tempo_ensino", columnDefinition = "CHAR")
    @Min(value = 1, message = "Campo obrigatório")
    private int tempoEnsino;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    @NotNull(message = "Campo obrigatório")
    private Disciplina disciplina;

    @Column(name = "salario", columnDefinition = "CHAR")
    @Min(value = 705,message = "Valor mínimo de 705€")
    private BigDecimal salario;
}
