package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet , Long>
{

}
