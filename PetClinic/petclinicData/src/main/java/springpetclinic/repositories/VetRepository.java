package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
