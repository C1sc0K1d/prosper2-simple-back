package com.prosper.instrumentale.mapper;

import com.prosper.instrumentale.dto.InstrumentDto;
import com.prosper.instrumentale.entities.Instrument;
import com.prosper.instrumentale.request.InstrumentRequest;
import com.prosper.instrumentale.response.InstrumentListResponse;
import com.prosper.instrumentale.response.InstrumentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InstrumentMapper {

    public Instrument toInstrument(@Valid InstrumentRequest instrumentRequest) {
        return Instrument.builder()
                .id(instrumentRequest.getId())
                .name(instrumentRequest.getName())
                .image(instrumentRequest.getImage())
                .quantity(instrumentRequest.getQuantity())
                .type(instrumentRequest.getType())
                .price(instrumentRequest.getPrice()).build();
    }

    public InstrumentDto toInstrumentDto(Instrument instrument) {
        return InstrumentDto.builder()
                .id(instrument.getId())
                .name(instrument.getName())
                .image(instrument.getImage())
                .quantity(instrument.getQuantity())
                .type(instrument.getType())
                .price(instrument.getPrice()).build();
    }

    public List<InstrumentDto> toInstrumentListDto(List<Instrument> instruments) {
        return instruments.stream().map(this::toInstrumentDto).collect(Collectors.toList());
    }

    public InstrumentResponse toSingleResult(Instrument instrument) {
        return InstrumentResponse.builder().instrument(this.toInstrumentDto(instrument)).build();
    }

    public InstrumentListResponse toListResult(List<Instrument> instruments) {
        return InstrumentListResponse.builder().instruments(this.toInstrumentListDto(instruments)).build();
    }
}
