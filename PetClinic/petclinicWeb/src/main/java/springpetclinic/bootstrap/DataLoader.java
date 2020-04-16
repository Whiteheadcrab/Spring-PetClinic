package springpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springpetclinic.model.*;
import springpetclinic.services.OwnerService;
import springpetclinic.services.PetTypeService;
import springpetclinic.services.SpecialityService;
import springpetclinic.services.VetService;

import java.time.LocalDate;


@Component
@ComponentScan("springpetclinic.services")
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(PetTypeService petTypeService, OwnerService ownerService, VetService vetService, SpecialityService specialityService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDenristry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michal");
        owner1.setLastName("Andriev");
        owner1.setAddress("123 Brieckers street");
        owner1.setCity("Miami");
        owner1.setTelephone("1234567867");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setPetname("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anton");
        owner2.setLastName("Svirgov");
        owner2.setAddress("123 Brieckers street");
        owner2.setCity("Miami");
        owner2.setTelephone("1234567867");
        ownerService.save(owner2);

        Pet antonPet = new Pet();
        antonPet.setPetType(saveCatPetType);
        antonPet.setOwner(owner2);
        antonPet.setBirthDate(LocalDate.now());
        antonPet.setPetname("Fiora");
        owner2.getPets().add(antonPet);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sem");
        vet1.setLastName("Driv");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mikael");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(saveDenristry);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
