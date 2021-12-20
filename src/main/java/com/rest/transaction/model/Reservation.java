package com.rest.transaction.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Reservation {
    @NotNull(message = "ticket ne doit pas être null")
    private Ticket ticket;
    @NotNull(message = "release ne doit pas être nulle")
    private Release release;
}
