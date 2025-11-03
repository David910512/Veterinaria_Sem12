package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetDTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exceptions.VetNotFoundException;
import com.tecsup.petclinic.mapper.VetMapper;
import com.tecsup.petclinic.repositories.VetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;
    private final VetMapper vetMapper = new VetMapper();

    @Override
    public VetDTO createVet(VetDTO vetDTO) {
        if (vetDTO == null) throw new IllegalArgumentException("VetDTO requerido.");

        Vet entity = vetMapper.mapToEntity(vetDTO);
        if (entity == null) entity = new Vet();

        entity.setId(null); // asegurar creación
        if (vetDTO.getFirstName() != null) entity.setFirstName(vetDTO.getFirstName());
        if (vetDTO.getLastName()  != null) entity.setLastName(vetDTO.getLastName());

        Vet saved = vetRepository.save(entity);
        return vetMapper.mapToDto(saved);
    }

    @Override
    public VetDTO updateVet(VetDTO vetDTO) {
        if (vetDTO == null || vetDTO.getId() == null) {
            throw new IllegalArgumentException("Id requerido para actualizar Vet.");
        }

        Vet current = vetRepository.findById(vetDTO.getId())
                .orElseThrow(() -> new VetNotFoundException("Vet no encontrado: " + vetDTO.getId()));

        // Merge mínimo (solo lo que tu DTO expone)
        if (vetDTO.getFirstName() != null) current.setFirstName(vetDTO.getFirstName());
        if (vetDTO.getLastName()  != null) current.setLastName(vetDTO.getLastName());

        Vet saved = vetRepository.save(current);
        return vetMapper.mapToDto(saved);
    }

    @Override
    public void delete(Integer id) throws VetNotFoundException {
        if (id == null || !vetRepository.existsById(id)) {
            throw new VetNotFoundException("Vet no encontrado: " + id);
        }
        vetRepository.deleteById(id);
    }
}

