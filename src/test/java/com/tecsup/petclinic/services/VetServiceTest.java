package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {
        Vet vet = new Vet();
        vet.setFirstName("Carlos");
        vet.setLastName("Ramirez");

        Vet createdVet = vetService.create(vet);
        assertNotNull(createdVet.getId());
        assertEquals("Carlos", createdVet.getFirstName());
    }

    @Test
    public void testUpdateVet() {
        Vet vet = new Vet();
        vet.setFirstName("Ana");
        vet.setLastName("Torres");
        Vet createdVet = vetService.create(vet);

        createdVet.setLastName("Gonzales");
        vetService.update(createdVet);

        Vet updatedVet = vetService.findById(createdVet.getId());
        assertEquals("Gonzales", updatedVet.getLastName());
    }

    @Test
    public void testFindVetById() {
        Vet vet = new Vet();
        vet.setFirstName("Miguel");
        vet.setLastName("Santos");
        Vet createdVet = vetService.create(vet);

        Vet foundVet = vetService.findById(createdVet.getId());
        assertEquals("Miguel", foundVet.getFirstName());
    }

    @Test
    public void testDeleteVet() {
        Vet vet = new Vet();
        vet.setFirstName("Laura");
        vet.setLastName("Quispe");
        Vet createdVet = vetService.create(vet);

        vetService.delete(createdVet.getId());

        assertThrows(VetNotFoundException.class, () -> {
            vetService.findById(createdVet.getId());
        });
    }
}




