package com.example.spingaoprepository.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AllFile implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String guid;
}
