package com.demo.needmanage.Controller;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.dto.LoginRequest;
import com.demo.needmanage.dto.LoginResponse;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/dologin")
    public ResponeCode doLogin(@RequestBody LoginRequest loginRequest, HttpSession session){

        ResponeCode<LoginResponse> responeCode = this.loginService.dologin(loginRequest.getName(), loginRequest.getPassword(), loginRequest.getType());
        if (responeCode.getStatus()==200){
            session.setAttribute("user",responeCode.getData());

        }



        return responeCode;

    }

    @RequestMapping("/info")
    public ResponeCode getUserInfo(HttpSession session){

        LoginResponse user = (LoginResponse) session.getAttribute("user");
        if (user==null){
            return ResponeCode.newResponeCode(MessageCode.LOGIN_OUT);
        }else {
            ResponeCode<LoginResponse> responeCode  = ResponeCode.newResponeCode(MessageCode.LOGIN_IN);
            responeCode.setData(user);
            return responeCode;
        }
    }

    @GetMapping("/signout")
    public ResponeCode loginout(HttpSession session){

        LoginResponse loginResponse = (LoginResponse) session.getAttribute("user");
        if (loginResponse!=null){
            session.removeAttribute("user");
            return ResponeCode.newResponeCode(MessageCode.SIGNOUT_SUCCESS);
        }

        return ResponeCode.newResponeCode(MessageCode.SIGNOUT_SUCCESS);

    }

}
