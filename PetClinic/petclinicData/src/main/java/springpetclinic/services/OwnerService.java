package springpetclinic.services;


import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner , Long>
{
    Owner findByLastName(String lastName);
}