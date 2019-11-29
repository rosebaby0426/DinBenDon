package com.christine.dinbendon.service.Member;

import com.christine.dinbendon.dao.MemberDao;
import com.christine.dinbendon.exception.ServiceException;
import com.christine.dinbendon.model.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * Christine 2019/11/28
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member login(Member member) {

        if(StringUtils.isEmpty(member.getAccount()) || StringUtils.isEmpty(member.getPassword())){
            throw new ServiceException("帳號或密碼不可为空");
        }

        Member mem = memberDao.login(member);

        if(mem == null){
            throw new ServiceException("帳號或密碼錯誤");
        }

        mem.setLastLoginTime(LocalDateTime.now());
        memberDao.updateLogin(mem);

        return mem;
    }
}
