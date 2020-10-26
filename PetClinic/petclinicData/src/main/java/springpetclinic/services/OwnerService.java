package springpetclinic.services;


import org.springframework.stereotype.Service;
import springpetclinic.model.Owner;

import java.util.List;


@Service
public interface OwnerService extends CrudService<Owner , Long>
{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}