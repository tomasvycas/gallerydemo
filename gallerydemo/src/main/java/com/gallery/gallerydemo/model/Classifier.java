package com.gallery.gallerydemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Classifier {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Classifier name cannot be blank")
    private String name;
    private LocalDate createDate;
    private Boolean archived;

}
