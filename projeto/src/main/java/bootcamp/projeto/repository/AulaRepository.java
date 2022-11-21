package bootcamp.projeto.repository;

import bootcamp.projeto.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AulaRepository extends JpaRepository<Aula, Integer>{
}
