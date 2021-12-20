package com.rest.transaction.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SEQ")
    @SequenceGenerator(name = "TICKET_SEQ", sequenceName = "ticket_seq", allocationSize = 1)
    private Long id;

    @Column(name = "code")
    @NotBlank(message = "code ne doit pas être null ou vide")
    private String code;

    @Column(name = "title")
    @NotBlank(message = "title ne doit pas être null ou vide")
    @Size(min = 3, max = 20, message = "title doit être compris entre 3 et 20 caractères")
    private String title;

    @Column(name = "description")
    @NotBlank(message = "description ne doit pas être null ou vide")
    @Size(min = 3, max = 50, message = "description doit être compris entre 3 et 50 caractères")
    private String description;

    @Column(name = "date")
    @NotNull(message = "date ne doit pas être nulle")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "price")
    @NotNull(message = "price ne doit pas être null")
    private Long price;

    @Column(name = "sector")
    @NotBlank(message = "sector ne doit pas être null ou vide")
    private String sector;

    @Column(name = "row")
    @NotNull(message = "row ne doit pas être null")
    private Long row;

    @Column(name = "seat")
    @NotNull(message = "seat ne doit pas être null")
    private Long seat;
}
