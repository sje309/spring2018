package bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/** @Author: shuyizhi @Date: 2018-07-27 10:20 @Description: */
public class MyTestBeanTest {
    @Test
    public void testBean() {
        // BeanFactory方式
        BeanFactory beanFactory =
                new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println(bean.getTestStr());

        // DefaultListableBeanFactory方式
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        MyTestBean bean1 = (MyTestBean) factory.getBean("myTestBean");
        System.out.println(bean1.getTestStr());

        // FileSystemXmlApplicationContext方式
        //ApplicationContext context =
        //        new FileSystemXmlApplicationContext("src\\main\\resources\\applicationContext.xml");

        ApplicationContext context=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

        ((FileSystemXmlApplicationContext) context).refresh();
        // context.getResource("src\\main\\resources\\applicationContext.xml");
        MyTestBean bean2 = (MyTestBean) context.getBean("myTestBean");
        System.out.println(bean2.getTestStr());
    }
}
