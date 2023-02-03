package com.prosper.instrumentale.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String userName;

    private String password;

    private Boolean isAdmin;

    private String email;

    private String phone;

    private String address;
}
