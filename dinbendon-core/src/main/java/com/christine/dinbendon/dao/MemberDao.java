package com.christine.dinbendon.dao;

import com.christine.dinbendon.model.po.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Christine 2019/11/28
 */
@Mapper
@Repository
public interface MemberDao {

    Member login(Member member);

    void updateLogin(Member member);

    void update(Member member);
}
