package spring.web.aspectj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SessionCheckAdvice {
	
	
	@Around("execution(public * spring.web.controller.UserProductController.*Aop(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("around");
		// 세션 유무를 체크
		Object[] methodParams = point.getArgs();
		HttpServletRequest request = (HttpServletRequest)methodParams[0];
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("email"));
		if(session.getAttribute("email") == null) {
			System.out.println("로그인을 안했다");
			// 오류발생
			request.setAttribute("errorMsg", "로그인하고 오세요!");
			throw new Exception();
		}
		System.out.println("?????");
		Object obj = point.proceed(); // 실제 타겟대상을 호출
		return obj;
	}
}
