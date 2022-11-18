package bootcamp.projeto.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "PROFESSOR")
@Entity
public class Professor {

    @Id
    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    private String cpf;

    @Column(name = "nome", nullable = false, columnDefinition = "CHAR")
    private String nome;

    @Column(name = "sexo", columnDefinition = "CHAR")
    private String sexo;

    @Column(name = "idade")
    private int idade;

    @Column(name = "tempo_ensino", columnDefinition = "CHAR")
    private int tempoEnsino;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @Column(name = "salario", columnDefinition = "CHAR")
    private BigDecimal salario;
}
