package com.prosper.instrumentale.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentRequest {

    private Integer id;

    private String name;

    private String image;

    private Double price;

    private Integer quantity;

    private String type;
}
