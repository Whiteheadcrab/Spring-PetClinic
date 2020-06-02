package springpetclinic.services;

import org.springframework.stereotype.Service;
import springpetclinic.model.Visit;

@Service
public interface VisitService extends CrudService<Visit , Long>
{

}
