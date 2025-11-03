package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;

public class VetMapper {


    /**
     * Convert DTO to Entity
     * @param dto
     * @return
     */
    public Vet mapToEntity(VetDTO dto) {
        if (dto == null) return null;
        return new Vet(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName()
        );
    }

    public VetDTO mapToDto(Vet entity) {
        if (entity == null) return null;
        return new VetDTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName()
        );
    }
}
