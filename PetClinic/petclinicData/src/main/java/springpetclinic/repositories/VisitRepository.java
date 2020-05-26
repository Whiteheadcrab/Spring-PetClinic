package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
