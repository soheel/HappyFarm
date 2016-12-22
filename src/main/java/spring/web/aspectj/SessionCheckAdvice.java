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
		// ���� ������ üũ
		Object[] methodParams = point.getArgs();
		HttpServletRequest request = (HttpServletRequest)methodParams[0];
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("email"));
		if(session.getAttribute("email") == null) {
			System.out.println("�α����� ���ߴ�");
			// �����߻�
			request.setAttribute("errorMsg", "�α����ϰ� ������!");
			throw new Exception();
		}
		System.out.println("?????");
		Object obj = point.proceed(); // ���� Ÿ�ٴ���� ȣ��
		return obj;
	}
}
