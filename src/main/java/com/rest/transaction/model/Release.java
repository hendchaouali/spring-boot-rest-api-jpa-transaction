package com.rest.transaction.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "release")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELEASE_SEQ")
    @SequenceGenerator(name = "RELEASE_SEQ", sequenceName = "release_seq" ,allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "name ne doit pas être null ou vide")
    @Size(min = 3, max = 20, message = "name doit être compris entre 3 et 20 caractères")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "description ne doit pas être null ou vide")
    @Size(min = 3, max = 50, message = "description doit être compris entre 3 et 50 caractères")
    private String description;

    @Column(name = "release_date")
    @NotNull(message = "date ne doit pas être nulle")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
}
