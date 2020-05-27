package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
    Owner findByLastName(String lastName);
}
