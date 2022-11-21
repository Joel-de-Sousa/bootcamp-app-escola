package bootcamp.projeto.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "AULA")
@AllArgsConstructor
@NoArgsConstructor
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, length = 8, columnDefinition = "CHAR")
    private int id = 0;

    @ManyToOne
    @JoinColumn(name = "professor_cpf", columnDefinition = "CHAR")
    @NotNull(message = "Campo obrigatório")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_matricula", columnDefinition = "CHAR")
    @NotNull(message = "Campo obrigatório")
    private Aluno aluno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    //@Pattern(regexp = "^\\d\\d+(\\.[5])?$")
    @Max(value = 7, message = "Máximo número de horas: 7")
    @Min(value = 1, message = "Mínimo número de horas: 1")
    private BigDecimal duracao;

    @Max(value = 70, message = "Máximo: 70")
    @Min(value = 10, message = "Mínimo: 10")
    private BigDecimal valor;

}
