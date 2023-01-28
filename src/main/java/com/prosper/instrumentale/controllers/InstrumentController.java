package com.prosper.instrumentale.controllers;

import com.prosper.instrumentale.dto.InstrumentDto;
import com.prosper.instrumentale.entities.Instrument;
import com.prosper.instrumentale.request.InstrumentRequest;
import com.prosper.instrumentale.response.InstrumentListResponse;
import com.prosper.instrumentale.response.InstrumentResponse;
import com.prosper.instrumentale.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService service;

    @GetMapping
    public InstrumentListResponse findAll() { return service.findAll(); }

    @PostMapping("/add")
    public InstrumentResponse addInstrument(@RequestBody InstrumentRequest instrumentRequest) { return service.insertInstrument(instrumentRequest); }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstrument(@PathVariable Integer id) {
        try {
            this.service.deleteInstrument(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Instrument Not Found!!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    private class ErrorResponse {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
