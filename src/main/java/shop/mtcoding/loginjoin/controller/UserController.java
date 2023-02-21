package shop.mtcoding.loginjoin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.loginjoin.dto.UserReq.JoinReqDto;
import shop.mtcoding.loginjoin.dto.UserReq.LoginReqDto;
import shop.mtcoding.loginjoin.handler.ex.CustomException;
import shop.mtcoding.loginjoin.model.User;
import shop.mtcoding.loginjoin.service.UserService;

@Controller
public class UserController {

      @Autowired
      private UserService userService;

      @Autowired
      private HttpSession session;

      @GetMapping("/joinForm")
      public String joinForm() {
            return "joinForm";
      }

      @PostMapping(value = "/join")
      public String join(JoinReqDto joinReqDto) throws Exception {
            if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
                  throw new CustomException("username을 작성해주세요");
            }
            if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
                  throw new CustomException("password를 작성해주세요");
            }
            if (joinReqDto.getEmail() == null || joinReqDto.getEmail().isEmpty()) {
                  throw new CustomException("email을 작성해주세요");
            }
            userService.join(joinReqDto);
            return "redirect:/loginForm";
      }

      @GetMapping("/loginForm")
      public String loginForm() {
            return "loginForm";
      }

      @PostMapping(value = "/login")
      public String login(LoginReqDto loginReqDto) throws Exception {
            if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty()) {
                  throw new CustomException("username을 작성해주세요");
            }

            if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty()) {
                  throw new CustomException("password를 작성해주세요");
            }

            User principal = userService.login(loginReqDto);
            if (principal == null) {
                  throw new CustomException("유저이름 또는 비밀번호가 잘못 입력되었습니다.");
            }
            session.setAttribute("principal", principal);
            return "redirect:/main";
      }

      @GetMapping("/main")
      public String mainpage() {
            return "main";
      }
}
