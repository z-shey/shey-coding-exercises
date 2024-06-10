package bean;

/**
 * @Project: spring-implement-learning
 * @File: UserService.java
 * @PACKAGE_NAME: bean
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: UserService.java 用户服务
 **/
public class UserService {
    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
