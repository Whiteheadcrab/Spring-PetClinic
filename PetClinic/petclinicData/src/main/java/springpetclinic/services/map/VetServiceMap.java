package springpetclinic.services.map;

import springpetclinic.model.Speciality;
import springpetclinic.model.Vet;
import springpetclinic.services.CrudService;
import springpetclinic.services.SpecialityService;

import java.util.Set;

public class VetServiceMap extends AbstactMapService<Vet , Long> implements CrudService<Vet, Long>
{
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService)
    {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll()
    {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id)
    {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object)
    {
        if(object.getSpecialities().size() > 0 )
        {
            object.getSpecialities().forEach(
                    speciality ->
                    {
                        if(speciality.getId() == null)
                        {
                            Speciality saveSpeciality = specialityService.save(speciality);
                            speciality.setId(saveSpeciality.getId());
                        }
                    });
        }
        return super.save(object.getId() , object);
    }

    @Override
    public void delete(Vet object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
