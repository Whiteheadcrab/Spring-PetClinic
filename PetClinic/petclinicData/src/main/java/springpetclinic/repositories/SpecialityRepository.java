package springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality , Long>
{

}
