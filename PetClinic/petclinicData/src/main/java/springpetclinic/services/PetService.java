package springpetclinic.services;

import org.springframework.stereotype.Service;
import springpetclinic.model.Pet;


@Service
public interface PetService extends CrudService<Pet , Long>
{

}
