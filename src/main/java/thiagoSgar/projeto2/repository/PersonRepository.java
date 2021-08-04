package thiagoSgar.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thiagoSgar.projeto2.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
