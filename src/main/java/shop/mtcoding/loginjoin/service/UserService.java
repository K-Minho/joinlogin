package shop.mtcoding.loginjoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.loginjoin.dto.UserReq.JoinReqDto;
import shop.mtcoding.loginjoin.dto.UserReq.LoginReqDto;
import shop.mtcoding.loginjoin.handler.ex.CustomException;
import shop.mtcoding.loginjoin.model.User;
import shop.mtcoding.loginjoin.model.UserRepository;
import shop.mtcoding.loginjoin.util.Sha;

@Service
public class UserService {

      @Autowired
      private UserRepository userRepository;

      @Transactional
      public void join(JoinReqDto joinReqDto) throws Exception {
            User sameUser = userRepository.findByUsername(joinReqDto.getUsername());
            if (sameUser != null) {
                  throw new CustomException("동일한 username이 존재합니다");
            }
            String passwordHash = Sha.sha256(joinReqDto.getPassword());
            int result = userRepository.insert(joinReqDto.getUsername(), passwordHash,
                        joinReqDto.getEmail());
            if (result != 1) {
                  throw new CustomException("회원가입실패");
            }
      };

      @Transactional(readOnly = true)
      public User login(LoginReqDto loginReqDto) throws Exception {
            String passwordHash = Sha.sha256(loginReqDto.getPassword());
            User principal = userRepository.findByUsernameAndPassword(loginReqDto.getUsername(),
                        passwordHash);

            return principal;
      }
}
