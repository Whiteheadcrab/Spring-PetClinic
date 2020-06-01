package springpetclinic.services.map;

import org.springframework.stereotype.Service;
import springpetclinic.model.Speciality;
import springpetclinic.model.Vet;
import springpetclinic.services.SpecialityService;
import springpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstactMapService<Vet , Long> implements VetService
{
    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService)
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
