package springpetclinic.services;

import springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner , Long>
{
    Owner findByLastName(String lastName);
}
