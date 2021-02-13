package com.example.spingaoprepository.serializable;

import javax.persistence.EntityManager;

import com.example.spingaoprepository.model.AllFile;
import com.example.spingaoprepository.repository.AllFileRepository;
import com.example.spingaoprepository.service.PipelineService;
import com.example.spingaoprepository.utils.ApplicationContextUtils;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class PipelineConfigurer {

    public PipelineConfigurer() {

    }

    PipelineService pipelineService = new PipelineService();

    public void initialize() {
        AnnotationConfigApplicationContext applicationContext = (AnnotationConfigApplicationContext) ApplicationContextUtils
                .getApplicationContext();
        // AutowireCapableBeanFactory autowireCapableBeanFactory =
        // applicationContext.getAutowireCapableBeanFactory();
        EntityManager em = applicationContext.getBean(EntityManager.class);
        AllFileRepository allFileRepository = new JpaRepositoryFactory(em).getRepository(AllFileRepository.class);
        allFileRepository.findByGuid(""); // Method is accessible here but the object is proxy
        SimpleJpaRepository<AllFile, Long> simpleJpaRepository = (SimpleJpaRepository<AllFile, Long>) (AopProxyUtils
                .getSingletonTarget(allFileRepository)); // But proxy resolution yeilds SimpleJpaRepository cannot
                                                         // explicitly cast to AllFileRepository
        ((AllFileRepository) simpleJpaRepository).findByGuid(""); // class
                                                                  // org.springframework.data.jpa.repository.support.SimpleJpaRepository
                                                                  // cannot be cast to class
                                                                  // com.example.spingaoprepository.repository.AllFileRepository
                                                                  // (org.springframework.data.jpa.repository.support.SimpleJpaRepository
                                                                  // and
                                                                  // com.example.spingaoprepository.repository.AllFileRepository
                                                                  // are in unnamed module of loader 'app'

    }

}
