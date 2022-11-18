package bootcamp.projeto.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "AULA")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, length = 8, columnDefinition = "CHAR")
    private int id = 0;

    @ManyToOne
    @JoinColumn(name = "professor_cpf", columnDefinition = "CHAR")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_matricula", columnDefinition = "CHAR")
    private Aluno aluno;

    private LocalDate data;

    private BigDecimal media;

    private BigDecimal duracao;

    private BigDecimal valor;

    private String resultado;
}
