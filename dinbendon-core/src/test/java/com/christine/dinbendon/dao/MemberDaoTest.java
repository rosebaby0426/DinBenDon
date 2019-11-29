package com.christine.dinbendon.dao;

import com.christine.dinbendon.model.po.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.time.LocalDateTime;

/**
 * Christine 2019/11/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberDaoTest {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testLogin(){
        Member member = Member.builder().account("Admin").password("123456").build();
        System.out.println(member.getPassword());
        member = memberDao.login(member);
        if(member == null){
            System.out.println("Login Failure");
        } else {
            System.out.println("Login Success");
        }
    }

    @Test
    public void testUpdateLogin(){
        Member member = Member.builder().account("Admin").password("123456").build();

        member.setLastLoginTime(LocalDateTime.now());
        memberDao.updateLogin(member);
    }

    @Test
    public void testUpdate(){
        Member member = Member.builder().account("Admin").build();

        member.setPassword("123456");
        memberDao.update(member);

    }

    //查看當前的連接的數據源
    @Test
    public void testDataSource(){
        System.out.println(dataSource.getClass());//class com.zaxxer.hikari.HikariDataSource
    }
}
