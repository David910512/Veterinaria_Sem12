package com.tecsup.petclinic.repositories;

import java.util.List;

import com.tecsup.petclinic.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Vet;

import javax.swing.event.ListDataEvent;

public interface VetRepository
        extends JpaRepository<Vet, Integer>{

    //Buscar por el nombre
    List<Vet> findByFirstName(String firstName);

    //Buscar por el Apellido
    List<Vet> findByLastName(String lastName);

    //Bucar por especialdad
    List<Vet> findBySpecialityId(String specialityId);

    //Traer todos
    @Override
    List<Vet> findAll();
}
