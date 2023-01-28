package com.prosper.instrumentale.response;

import com.prosper.instrumentale.dto.InstrumentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentListResponse {
    private List<InstrumentDto> instruments;
}
