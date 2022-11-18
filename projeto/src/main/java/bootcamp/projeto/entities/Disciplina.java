package bootcamp.projeto.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "DISCIPLINA")
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, length = 8, columnDefinition = "CHAR")
    private int id = 0;

    @Column(name = "titulo", nullable = false, columnDefinition = "CHAR")
    private String titulo = "";

    @Column(name = "area", nullable = false, columnDefinition = "CHAR")
    private String area = "";
}
