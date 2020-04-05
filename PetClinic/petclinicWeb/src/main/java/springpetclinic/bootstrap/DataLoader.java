package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.Vet;
import springpetclinic.services.OwnerService;
import springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;

    public  DataLoader (OwnerService ownerService , VetService vetService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michal");
        owner1.setLastName("Andriev");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anton");
        owner2.setLastName("Svirgov");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sem");
        vet1.setLastName("Driv");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mikael");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
