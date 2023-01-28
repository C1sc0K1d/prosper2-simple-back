package com.prosper.instrumentale.response;

import com.prosper.instrumentale.dto.InstrumentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentResponse {
    private InstrumentDto instrument;
}
