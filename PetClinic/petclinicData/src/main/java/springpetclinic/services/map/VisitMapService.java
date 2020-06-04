package springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springpetclinic.model.Visit;
import springpetclinic.repositories.VisitRepository;
import springpetclinic.services.VisitService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstactMapService<Visit , Long> implements VisitService
{
    private final VisitRepository visitRepository;

    public VisitMapService(VisitRepository visitRepository)
    {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
        || visit.getPet().getOwner().getId() == null)
        {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit.getId() , visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
