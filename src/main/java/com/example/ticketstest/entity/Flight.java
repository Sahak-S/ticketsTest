package com.example.ticketstest.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    private String carrier;
    private String departure;
    private String arrival;
    private int flightTime;
    private int price;
}
