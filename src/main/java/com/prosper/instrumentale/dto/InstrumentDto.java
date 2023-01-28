package com.prosper.instrumentale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentDto {

    private Integer id;

    private String name;

    private  String image;

    private Double price;

    private Integer quantity;

    private String type;
}
