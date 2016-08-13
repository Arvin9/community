package site.nebulas.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import site.nebulas.beans.LogLogin;
import site.nebulas.beans.User;
import site.nebulas.service.LogLoginService;
import site.nebulas.service.UserService;
import site.nebulas.util.DateUtil;


/**
 * @author Caihonghui
 * @version 0.1
 * 20160811 添加登陆日志
 * @version 0.2	
 * 20160813 登陆成功loginState为1,密码错误为2
 */
@Controller
public class ShiroController {

	Logger log=LoggerFactory.getLogger(getClass());
	@Resource
	UserService userService;
	@Resource
	LogLoginService logLoginService;
	
	@RequestMapping("loginIn")
	public String loginIn(Model model,User user){
		LogLogin logLogin = new LogLogin();
		String userAccount = user.getUserAccount();
		String password = user.getPassword();
		
		log.info(userAccount + " " + password);
		
		if(userAccount != null && password != null){
			UsernamePasswordToken token = new UsernamePasswordToken(userAccount,password);
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(); 
			
			try {
				 subject.login(token);
				 logLogin.setUserAccount(userAccount);
				 logLogin.setLoginIp(session.getHost());//用户登录ip
				 logLogin.setLoginState(1); //登陆成功
				 logLogin.setLoginTime(DateUtil.getCurrentSysDate());
				 logLoginService.insert(logLogin);
//				 System.out.println("用户是否是通过验证登陆："+subject.isAuthenticated());
//				 System.out.println("用户是否是通过记住我登陆："+subject.isRemembered());
			}catch(UnknownAccountException uae){
	            System.out.println("对用户[" + userAccount + "]进行登录验证..验证未通过,未知账户");  
	            model.addAttribute("message", "no");
	            return "login";
	        }catch(IncorrectCredentialsException ice){  
	            System.out.println("对用户[" + userAccount + "]进行登录验证..验证未通过,错误的凭证");  
	            model.addAttribute("message", "error");
	            logLogin.setUserAccount(userAccount);
				logLogin.setLoginIp(session.getHost());//用户登录ip
				logLogin.setLoginState(2); //密码错误
				logLogin.setLoginTime(DateUtil.getCurrentSysDate());
				logLoginService.insert(logLogin);
	            return "login";
	        }catch(LockedAccountException lae){  
	            System.out.println("对用户[" + userAccount + "]进行登录验证..验证未通过,账户已锁定");  
//	            request.setAttribute("message_login", "账户已锁定");  
	            return "login";
	        }catch(ExcessiveAttemptsException eae){  
	            System.out.println("对用户[" + userAccount + "]进行登录验证..验证未通过,错误次数过多");
	            model.addAttribute("message", "error");
	            return "login";
	        }catch(AuthenticationException ae){  
	            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
	            System.out.println("对用户[" + userAccount + "]进行登录验证..验证未通过,堆栈轨迹如下");  
	            ae.printStackTrace(); 
	            model.addAttribute("message", "error");
	            return "login";
	        }  
			return "index";
		}
		return "login";
	}
	
}




