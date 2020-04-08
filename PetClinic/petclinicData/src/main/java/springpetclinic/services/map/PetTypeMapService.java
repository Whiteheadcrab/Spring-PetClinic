package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.PetType;
import springpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeMapService extends  AbstactMapService<PetType, Long> implements PetTypeService
{
    @Override
    public Set<PetType> findAll()
    {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object)
    {
        return super.save(object.getId() , object);
    }

    @Override
    public void delete(PetType object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
