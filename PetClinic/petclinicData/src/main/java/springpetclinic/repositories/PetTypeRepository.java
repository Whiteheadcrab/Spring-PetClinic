package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType , Long>
{

}
