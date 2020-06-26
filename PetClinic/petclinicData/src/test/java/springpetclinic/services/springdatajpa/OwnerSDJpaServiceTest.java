package springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springpetclinic.model.Owner;
import springpetclinic.repositories.OwnerRepository;
import springpetclinic.repositories.PetRepository;
import springpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    static String LAST_Name;
    static Owner returnOwner;

    @BeforeAll
    static void SetUp()
    {
        LAST_Name = "Smith";
        returnOwner = Owner.builder().id(1l).lastName(LAST_Name).build();
    }

    @Test
    void findByLastName()
    {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerSDJpaService.findByLastName(LAST_Name);

        assertEquals(LAST_Name,owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll()
    {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1l).build());
        ownerSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById()
    {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(1l);

        assertNotNull(owner);
    }

    @Test
    void save()
    {
        Owner ownerToSave = Owner.builder().id(1l).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete()
    {
        ownerSDJpaService.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById()
    {
        ownerSDJpaService.deleteById(1l);

        verify(ownerRepository).deleteById(anyLong());
    }
}