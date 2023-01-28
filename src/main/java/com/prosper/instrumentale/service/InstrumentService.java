package com.prosper.instrumentale.service;

import com.prosper.instrumentale.dto.InstrumentDto;
import com.prosper.instrumentale.entities.Instrument;
import com.prosper.instrumentale.mapper.InstrumentMapper;
import com.prosper.instrumentale.repositories.InstrumentRepository;
import com.prosper.instrumentale.request.InstrumentRequest;
import com.prosper.instrumentale.response.InstrumentListResponse;
import com.prosper.instrumentale.response.InstrumentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;
    private final InstrumentMapper instrumentMapper;

    @Transactional(readOnly = true)
    public InstrumentListResponse findAll() {
        return this.instrumentMapper.toListResult(instrumentRepository.findAll());
    }

    public InstrumentResponse insertInstrument(InstrumentRequest instrumentRequest) {
        instrumentRequest.setQuantity(null);
        var instrument = instrumentMapper.toInstrument(instrumentRequest);
        instrumentRepository.save(instrument);
        return instrumentMapper.toSingleResult(instrument);
    }

    public void deleteInstrument(Integer id) {
        this.instrumentRepository.deleteById(id);
    }
}
