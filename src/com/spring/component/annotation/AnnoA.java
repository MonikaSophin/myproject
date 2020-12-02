package com.spring.component.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author XueYing.Cao
 * @date 2020/6/17
 */
@Component("a")
//@Component()
//@Service("a")
//@Repository("a")
public class AnnoA {

    public AnnoA() {
    }

    @Bean(name = {"a1, a2, a3"})
    public AnnoA annoA() {
        return new AnnoA();
    }
}
