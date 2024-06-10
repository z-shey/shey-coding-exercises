import bean.UserService;
import io.shey.beans.BeansException;
import io.shey.beans.factory.config.BeanDefinition;
import io.shey.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;


/**
 * @Project: spring-implement-learning
 * @File: ApiTest.java
 * @PACKAGE_NAME: PACKAGE_NAME
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: ApiTest.java
 **/

public class ApiTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        // 初始化BeanFactory接口
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 注册BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取Bean对象
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();

        // 再次获取Bean对象
        UserService userService1 = (UserService) defaultListableBeanFactory.getBean("userService");
        userService1.queryUserInfo();
    }
}
