package shop.mtcoding.loginjoin.handler.intercept;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import shop.mtcoding.loginjoin.handler.ex.CustomException;
import shop.mtcoding.loginjoin.model.User;

@Component
public class LoginInterceptor implements AsyncHandlerInterceptor {

      public List loginEssential = Arrays.asList("/main");

      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                  throws Exception {
            User principal = (User) request.getSession().getAttribute("principal");
            if (principal == null) {
                  throw new CustomException("로그인이 필요한 페이지입니다.", HttpStatus.FORBIDDEN);
            }

            return true;
      }
}
