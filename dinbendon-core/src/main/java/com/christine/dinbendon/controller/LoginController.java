package com.christine.dinbendon.controller;

import com.christine.dinbendon.model.po.Member;
import com.christine.dinbendon.service.Member.MemberService;
import com.christine.dinbendon.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Christine 2019/11/28
 */
@Controller
public class LoginController {

    @Autowired
	private MemberService memberService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Member member, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            model.addAttribute("errorMsg", "");
//			String ip = RequestUtils.getFisrtRemoteHost(request);
            member = memberService.login(member);
			session.setAttribute(RequestUtils.SESSION_LOGIN_ATTR, member);
        } catch (RuntimeException e) {
            model.addAttribute("errorMsg", "帐号密码错误");
            return "login";
        } catch (Exception e) {
            model.addAttribute("errorMsg", "错误");
            return "login";
        }

        return "redirect:/index";
    }

    @RequestMapping("logOut")
    public String logOut(HttpSession session) {
        session.removeAttribute(session.getId());
        return "redirect:/";
    }

}
