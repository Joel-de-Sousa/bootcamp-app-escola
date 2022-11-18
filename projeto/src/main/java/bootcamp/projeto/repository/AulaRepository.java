package bootcamp.projeto.repository;

import bootcamp.projeto.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
}
