package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.PetDTO;
import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.exceptions.VetNotFoundException;

import java.util.List;


/**
 *
 * @David Carhuaz
 *
 */

public interface VetService{


    /**
     *
     * @param vetDTO
     * @return
     */
    VetDTO createVet(VetDTO vetDTO);

    VetDTO updateVet(VetDTO vetDTO);

    void delete(Integer id) throws PetNotFoundException;

}
