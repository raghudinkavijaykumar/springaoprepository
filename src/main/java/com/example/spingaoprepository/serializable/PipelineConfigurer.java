package com.example.spingaoprepository.serializable;

import com.example.spingaoprepository.repository.AllFileRepository;
import com.example.spingaoprepository.service.PipelineService;
import com.example.spingaoprepository.utils.ApplicationContextUtils;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

public class PipelineConfigurer {
    private ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
    private PipelineService pipelineService = applicationContext.getBean(PipelineService.class);

    public void initialize() {
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(pipelineService);
        AllFileRepository allFileRepository = (AllFileRepository) AopProxyUtils
                .getSingletonTarget(pipelineService.getAllFileRepository());
        allFileRepository.findByGuid("XY-123");
    }

}
