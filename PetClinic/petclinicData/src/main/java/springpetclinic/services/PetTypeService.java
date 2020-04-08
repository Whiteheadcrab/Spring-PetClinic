package springpetclinic.services;

import org.springframework.stereotype.Service;
import springpetclinic.model.PetType;

@Service
public interface PetTypeService extends CrudService<PetType, Long>
{

}
