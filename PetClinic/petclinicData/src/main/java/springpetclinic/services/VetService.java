package springpetclinic.services;

import org.springframework.stereotype.Service;
import springpetclinic.model.Vet;

@Service
public interface VetService extends CrudService<Vet , Long>
{
}
