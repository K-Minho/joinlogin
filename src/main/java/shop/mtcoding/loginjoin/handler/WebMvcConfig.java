package shop.mtcoding.loginjoin.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import shop.mtcoding.loginjoin.handler.intercept.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

      @Override
      public void addInterceptors(InterceptorRegistry registry) {

            LoginInterceptor loginIntercepter = new LoginInterceptor();
            registry.addInterceptor(loginIntercepter)
                        .addPathPatterns(loginIntercepter.loginEssential);
      }
}