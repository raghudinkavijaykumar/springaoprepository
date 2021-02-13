package com.example.spingaoprepository.service;

import java.io.Serializable;

import com.example.spingaoprepository.repository.AllFileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class PipelineService implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    AllFileRepository allFileRepository;
}