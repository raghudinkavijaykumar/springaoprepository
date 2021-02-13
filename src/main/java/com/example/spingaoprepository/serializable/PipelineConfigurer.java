package com.example.spingaoprepository.serializable;

import com.example.spingaoprepository.model.AllFile;
import com.example.spingaoprepository.service.PipelineService;
import com.example.spingaoprepository.utils.ApplicationContextUtils;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class PipelineConfigurer {

    public PipelineConfigurer() {

    }

    PipelineService pipelineService = new PipelineService();

    public void initialize() {
        AnnotationConfigApplicationContext applicationContext = (AnnotationConfigApplicationContext) ApplicationContextUtils
                .getApplicationContext();
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(pipelineService);
        JpaRepository<AllFile, Long> jpaRepository = (SimpleJpaRepository<AllFile, Long>) AopProxyUtils
                .getSingletonTarget(pipelineService.getAllFileRepository());

        // Here i want an object of interface AllFileRepository
        // jpaRepository.metadata is still a proxy. But i am not aware how to get object
        // of my defined repository

    }

}
