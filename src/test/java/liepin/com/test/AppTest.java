package liepin.com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import liepin.com.pojo.User;
import liepin.com.service.UserService;

/**
 * 
 * @author liujinxin
 *
 */
public class AppTest {
    private ApplicationContext ct = null;
    private UserService us = null;

    @Before
    public void init() {
        ct = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-servlet.xml");
        us = (UserService) ct.getBean("userService");

    }

    public void insertUser() {
        User user = new User();
        user.setAge(1);
        user.setName("kkkk");
        user.setSex("F");
        us.insertUser(user);
    }

    public void deleteUser() {
        User user = new User();
        user.setUid(3L);
        us.deleteUser(user);
    }

    public void updateUser() {
        User user = new User();
        user.setAge(18);
        user.setName("oooo");
        user.setSex("M");
        user.setUid(1L);
        us.updateUser(user);
    }

    public void selectAllUser() {
        List<User> users = us.selectUserByLimit(2);
        for (User u : users) {
            System.out.println(u.getUid());
        }
    }

    @Test
    public void selectUserCount() {
        System.out.println(us.selectUserCount());
    }
}
