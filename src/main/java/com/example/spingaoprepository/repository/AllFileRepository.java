package com.example.spingaoprepository.repository;

import com.example.spingaoprepository.model.AllFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AllFileRepository extends JpaRepository<AllFile, Long> {
    AllFile findByGuid(@Param("guid") String guid);
}
