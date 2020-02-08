package springpetclinic.services;

import whiteheadcrab.java.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService
{

    whiteheadcrab.java.springpetclinic.model.Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
