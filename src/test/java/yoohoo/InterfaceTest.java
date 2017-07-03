package yoohoo;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.quest.entity.User;
import com.quest.exception.PasswordWrongException;
import com.quest.exception.UserNotExistException;
import com.quest.service.UserService;

@ContextConfiguration("classpath:base.xml")
public class InterfaceTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private UserService userService;
	public void test(){
		String username = "admin";
		String password = "888888";
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		try {
			System.out.println(userService.login(user));
		} catch (UserNotExistException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (PasswordWrongException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
