package springpetclinic.services;

import whiteheadcrab.java.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService
{
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
