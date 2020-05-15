package com.mybatis.mapper_scan.self;

import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author XueYing.Cao
 * @date 2020/5/15
 */
public class MyMapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        resourceLoader = this.resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName(), true));
        ClassPathMapperScanner scanner = new ClassPathMapperScanner(registry);
        if (CollectionUtils.isEmpty(annotationAttributes)) {
            return;
        }

        List<String> basePackages = Arrays.stream(annotationAttributes.getStringArray("value"))
                .filter(Objects::nonNull).collect(Collectors.toList());
        List<String> packages = Arrays.stream(annotationAttributes.getStringArray("basePackages"))
                .filter(Objects::nonNull).collect(Collectors.toList());
        basePackages.addAll(packages);

        scanner.registerFilters();
        scanner.doScan(StringUtils.toStringArray(basePackages));
    }

}
