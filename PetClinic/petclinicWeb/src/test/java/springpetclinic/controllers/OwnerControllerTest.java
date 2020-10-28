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

/*    @Test
    void listOwners() throws Exception
    {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attribute("owners",hasSize(2)));

    }*/

 /*   @Test
    void listOwnersbyIndex() throws Exception
    {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));

    }*/

    @Test
    public void findOwner() throws Exception
    {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/findOwner"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    public void displayOwner() throws Exception
    {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/findOwner"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    void processFindFormReturnMany() throws Exception
    {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception
    {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1l).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception
    {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        mockMvc.perform(get("/owners")
                .param("lastName",""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));;
    }

}