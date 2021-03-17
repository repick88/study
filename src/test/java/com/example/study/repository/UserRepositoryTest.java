package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    //Dependency Injection (DI) : 디자인패턴은 싱글톤
    @Autowired
    private UserRepository userRepository;

    @Test //test임을 알린다 왼쪽 화살표를 눌러서 해당 메소드를 실행시킨다
    public void create(){
        // String sql = insert into user (%s, %s, %d) value (account,email,age);
        User user = new User();
        user.setAccount("TestUser01");
        user.setPassword("aaa");
        user.setStatus("bbb");
        user.setPhoneNumber("010-3333-1798");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser01");

        System.out.println("user : " + user);
        User newUser = userRepository.save(user); //DB에 저장하고 입력한 값을 리턴한다.
        System.out.println("newUser : " + newUser);


    }

    @Test
    //public void read(@RequestParam Long id){
    public void read(){
        Optional<User> user = userRepository.findById(1L); //Optional은 있을수도있고 없을수도 있다는 뜻

        user.ifPresent(selectUser -> { //있으면 selectUser에 넣겠다.
            System.out.println("user:" + selectUser);
        });

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser ->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            //create도 save인데 id가 존재하면 Update이고 존재하지않으면 insert한다.
            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional /*Transactional 데이터베이스 작업을하고 최종적으로 commit하지않고 rollback한다. 어노테이션*/
    public void delete(){
        /*
        Optional<User> deleteUser1 = userRepository.findById(2L);

        if(deleteUser1.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser1.get());
        }else{
            System.out.println("데이터 없음");
        }
        */

        Optional<User> user = userRepository.findById(5L);
        //값이 없으면 Assertions을 통과하지 못하고 에러 발생
        Assertions.assertTrue(user.isPresent()); //ture이면 통과 //Assert => Assertions

        //삭제
        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser2 = userRepository.findById(5L);
        Assertions.assertFalse(deleteUser2.isPresent()); //false이면 통과 //Assert => Assertions
        /*
        if(deleteUser2.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser2.get());
        }else{
            System.out.println("데이터 없음");
        }
        */
    }

}
