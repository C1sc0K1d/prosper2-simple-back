package com.prosper.instrumentale.controllers;

import com.prosper.instrumentale.request.UserRequest;
import com.prosper.instrumentale.response.UserListResponse;
import com.prosper.instrumentale.response.UserResponse;
import com.prosper.instrumentale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired

    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Token", "13213729");
            this.service.login(userRequest);
            return new ResponseEntity<>(service.login(userRequest), headers, HttpStatus.OK);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("User don't exist!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addUser")
    public UserResponse addUser(@RequestBody UserRequest userRequest) {
        return service.addUser(userRequest);
    }

    @GetMapping()
    public UserListResponse getAll() { return service.getAllUsers(); }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        try {
            service.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("User Not Found!!");
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
