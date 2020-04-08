package springpetclinic.services;

import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;

@Service
public interface OwnerService extends CrudService<Owner , Long>
{
    Owner findByLastName(String lastName);
}
