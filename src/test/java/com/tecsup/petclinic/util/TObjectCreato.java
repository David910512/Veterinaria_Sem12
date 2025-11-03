package com.tecsup.petclinic.util;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;

import java.util.ArrayList;
import java.util.List;

public class TObjectCreato {

    public static Vet getVet(){
        return new Vet(1,"James", "Carter");
    };
    public static Vet newVet(){
        return new Vet(2, "Helen", "Leary");
    };

    public static Vet newVetCreated(){
        Vet vet = newVet();
        vet.setId(5);
        return vet;
    };

    public static Vet newVetForUpdate(){
        return new Vet(5, "Rafael", "Ortega");
    };

    public static Vet newVetCreatedForUpdate(){
        Vet vet = newVetForUpdate();
        vet.setId(5);
        return vet;
    };

    public static Vet newVetForDelete() {
        return  new Vet(1, "James", "Carter");
    };

    public static Vet newVetCreatedForDelete(){
        Vet vet = newVetForDelete();
        vet.setId(2000);
        return vet;
    };

    public static List<VetDTO> getAllVet(){
        List<Vet> vets = new ArrayList<Vet>();
        vets.add(new Vet(6,"David", "Carhuaz"));
        vets.add(new Vet(7, "Juan","Mendoza"));
        vets.add(new Vet(8,"Bet", "Silva"));
        return vets;
    };

    public static List<Vet> getVetsForFindByName() {
        List<Vet> vets  = new ArrayList<Vet>();
        vets.add(new Vet(10, "Edward", "Torres"));
        return vets;
    }

    public static List<Vet> getVetsForFindByTypeID(){
        List<Vet> vets = new ArrayList<Vet>();
        vets.add(new Vet(2,"Helen","Leary"));
        vets.add(new Vet(3,"Linda", "Doubglas"));
        return vets;
    };

    public static VetDTO getVetDTO(){
        return new VetDTO(1, "James","Cartier");
    };

    public static VetDTO newVetDTO() {
        return new VetDTO(10, "Mande", "Richard");
    };

    public static VetDTO newVetTOForDelete() {
        return new VetDTO(3, "Linda","Douglas");
    }
}
