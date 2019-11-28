package com.christine.dinbendon.dao;

import com.christine.dinbendon.model.po.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Christine 2019/11/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberDaoTest {

    @Autowired
    private MemberDao memberDao;

    @Test
    public void testLogin(){
        Member member = memberDao.login("Admin","123456");

        if(member == null){
            System.out.println("Login Success");
        } else {
            System.out.println("Login Failure");
        }
    }

    @Test
    public void testUpdateLogin(){
        Member member = Member.builder().account("Admin").password("123456").build();

        member.setLastLoginTime(LocalDateTime.now());
        memberDao.updateLogin(member);
    }
}
