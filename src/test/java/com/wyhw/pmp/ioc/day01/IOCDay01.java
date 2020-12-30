package com.wyhw.pmp.ioc.day01;

import com.wyhw.pmp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class IOCDay01   {

    @Test
    void testXmlIoC() {
        ClassPathResource resource = new ClassPathResource("xml-ioc-bean.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        UserService service = beanFactory.getBean("userService", UserService.class);
        System.out.printf("class %s hashcode %s\n",service.getClass().getSimpleName(), service.hashCode());
    }

    @Test
    void testApplicationIoC() {
        System.out.println((char) 58);
    }
}
