package shop.mtcoding.loginjoin.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

@MybatisTest
public class UserRepositoryTest {

      @Autowired
      private UserRepository userRepository;

      @Test
      public void insert_test() throws Exception {
            // given
            ObjectMapper om = new ObjectMapper();
            String username = "cos";
            String password = "1234";
            String email = "cos@naver.com";
            // when
            int insertUser = userRepository.insert(username, password, email);

            String responseBody = om.writeValueAsString(insertUser);
            System.out.println(responseBody);

            // then

      }

      @Test
      public void findAll_test() throws Exception {
            // given
            ObjectMapper om = new ObjectMapper();
            // when
            List<User> userList = userRepository.findAll();
            System.out.println("test size : " + userList.size());
            String responseBody = om.writeValueAsString(userList);
            System.out.println(responseBody);

            // then
            assertThat(userList.size()).isEqualTo(4);
            assertThat(userList.get(3).getUsername()).isEqualTo("peace");
      }
}
