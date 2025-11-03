package com.tecsup.petclinic.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VetDTO {

    private Integer id;

    private String firstName;

    private String lastName;

}
