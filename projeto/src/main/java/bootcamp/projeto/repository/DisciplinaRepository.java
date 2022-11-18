package bootcamp.projeto.repository;

import bootcamp.projeto.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
