package springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springpetclinic.model.Owner;
import springpetclinic.model.PetType;
import springpetclinic.model.Vet;
import springpetclinic.services.OwnerService;
import springpetclinic.services.PetTypeService;
import springpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public  DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michal");
        owner1.setLastName("Andriev");
        owner1.setAddress("123 Brieckers street");
        owner1.setCity("1234567867");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anton");
        owner2.setLastName("Svirgov");
        owner2.setAddress("123 Brieckers street");
        owner2.setCity("1234567867");

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
