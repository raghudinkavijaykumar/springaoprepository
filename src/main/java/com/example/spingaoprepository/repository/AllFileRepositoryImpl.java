package com.example.spingaoprepository.repository;

import com.example.spingaoprepository.model.AllFile;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AllFileRepositoryImpl extends SimpleJpaRepository<AllFile, Long> implements AllFileRepository {
  public AllFileRepositoryImpl(EntityManager em) {
    super(AllFile.class, em);
  }

  @Override
  public AllFile findByGuid(String guid) {
    System.out.println("Finding AllFile by GUID " + guid);
    return null;
  }
}
