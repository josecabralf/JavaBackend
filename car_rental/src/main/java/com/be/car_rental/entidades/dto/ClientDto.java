package com.be.car_rental.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDateTime birthDate;
    private Long company;

    public Long getBirthDateAsUnixTimestamp() {
        Instant instant = birthDate.toInstant(ZoneOffset.UTC);
        return instant.toEpochMilli();
    }

    public void setBirthDateFromUnixTimestamp(long unixTimestamp) {
        Instant instant = Instant.ofEpochMilli(unixTimestamp);
        this.birthDate = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }
}
