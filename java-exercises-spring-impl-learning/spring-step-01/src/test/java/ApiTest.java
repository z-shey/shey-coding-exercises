import bean.UserService;
import io.shey.BeanDefinition;
import io.shey.BeanFactory;
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
    public void testBeanFactory() {
        // 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 注册BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取Bean对象
        UserService userService = (UserService) beanFactory.getBean("userService");

        // 调用Bean方法
        userService.queryUserInfo();
    }
}
