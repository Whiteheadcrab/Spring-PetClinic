package springpetclinic.services.map;

import springpetclinic.model.Owner;
import springpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstactMapService<Owner, Long> implements CrudService<Owner , Long>
{
    @Override
    public Set<Owner> findAll()
    {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object)
    {
        return super.save(object.getId() , object);
    }

    @Override
    public void delete(Owner object)
    {
        this.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        this.deleteById(id);
    }
}
