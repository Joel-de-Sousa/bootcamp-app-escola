package bootcamp.projeto.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "ALUNO")
@Entity(name = "ALUNO")
@NoArgsConstructor
public class Aluno {

    public Aluno(String matricula, String cpf, String nome, String sexo, Integer idade) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    @Id
    @Column(nullable = false, length = 8, columnDefinition = "CHAR")
    private String matricula;

    @Column(name = "cpf", nullable = false, unique = true, columnDefinition = "CHAR")
    private String cpf;

    private String nome;

    @Column(nullable = false, columnDefinition = "CHAR")
    private String sexo;

    Integer idade;

}
