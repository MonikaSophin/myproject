package com.mybatis.mapper_scan.self;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
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

        if (CollectionUtils.isEmpty(annotationAttributes)) {
            return;
        }

        List<String> basePackages = Arrays.stream(annotationAttributes.getStringArray("value"))
                .filter(Objects::nonNull).collect(Collectors.toList());
        List<String> packages = Arrays.stream(annotationAttributes.getStringArray("basePackages"))
                .filter(Objects::nonNull).collect(Collectors.toList());
        basePackages.addAll(packages);

        basePackages.stream().filter(Objects::nonNull).forEach(basePackage -> {
            ClassPathResource classPathResource = new ClassPathResource("/" + basePackage.replace(".", "/"));
            try {
                File file = classPathResource.getFile();
                Class[] classes = getFiles(basePackage, file);
                Arrays.stream(classes).filter(Objects::nonNull).forEach(clazz -> {
                    Object o = Proxy.newProxyInstance(MyMapperScannerRegistrar.class.getClassLoader(), new Class[]{clazz}, new MyInvokeHandler());
                    registry.registerBeanDefinition(o.getClass().getSimpleName(), create(o.getClass()));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private BeanDefinition create(Class clazz) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        return beanDefinitionBuilder.getBeanDefinition();
    }

    private Class[] getFiles(String basePackage, File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
             return Arrays.stream(files).filter(Objects::nonNull).map(f -> {
                if (f.isDirectory()) {
                    getFiles((basePackage + "." + f.getName()), f);
                } else {
                    if (StringUtils.contains(f.getName(), ".class")) {
                        String clazzName = basePackage + "." + f.getName().split(".class")[0];
                        try {
                            Class<?> aClass = MyMapperScannerRegistrar.class.getClassLoader().loadClass(clazzName);
                            if (aClass.isInterface() && !aClass.isAnnotation()) {
                                return aClass;
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }).filter(Objects::nonNull).toArray(Class[]::new);
        } else {
            return null;
        }
    }
}
