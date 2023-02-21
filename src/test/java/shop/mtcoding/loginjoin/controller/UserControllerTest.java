package shop.mtcoding.loginjoin.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.loginjoin.model.User;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class UserControllerTest {
      @Autowired
      private MockMvc mvc;

      @Autowired
      private MockHttpSession session;

      @BeforeEach
      public void setUp() {
            User user = new User();
            user.setUsername("ssar");
            user.setPassword("1234");
            user.setEmail("ssar@nate.com");

            session = new MockHttpSession();
            session.setAttribute("principal", user);
      }

      @Test
      public void join_test() throws Exception {
            // given
            String requestBody = "username=cos&password=1234&email="; // 이메일이 null 인 상태

            // when
            ResultActions resultActions = mvc.perform(post("/join").content(requestBody)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
            // then
            resultActions.andExpect(status().is3xxRedirection());
            // resultActions.andExpect(status().is4xxClientError());

      }

      @Test
      public void login_test() throws Exception {
            // given
            String requestBody = "username=ssar&password=1234";

            // when
            ResultActions resultActions = mvc.perform(post("/login").content(requestBody)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
            HttpSession session = resultActions.andReturn().getRequest().getSession();

            User principal = (User) session.getAttribute("principal");
            System.out.println(principal.getUsername());

            // then
            assertThat(principal.getUsername()).isEqualTo("ssar");
            resultActions.andExpect(status().is3xxRedirection());
      }

      @Test
      public void mainpage_test() throws Exception {
            // given

            // when
            ResultActions resultActions = mvc.perform(get("/main"));
            // then

            resultActions.andExpect(status().is4xxClientError()); // 로그인을 해야만 갈수 있음

      }
}
