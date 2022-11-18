package bootcamp.projeto.repository;

import bootcamp.projeto.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {


}
