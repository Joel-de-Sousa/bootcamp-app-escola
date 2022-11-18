package bootcamp.projeto.repository;

import bootcamp.projeto.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
