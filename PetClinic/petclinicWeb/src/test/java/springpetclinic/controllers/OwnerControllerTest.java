package springpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springpetclinic.model.Owner;
import springpetclinic.services.OwnerService;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    static OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners = new HashSet<>();;

    MockMvc mockMvc;

    @BeforeEach
    void SetUp()
    {
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());


        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void listOwners() throws Exception
    {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));

    }

    @Test
    void listOwnersbyIndex() throws Exception
    {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));

    }

    @Test
    void findOwner() throws Exception
    {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);
    }
}