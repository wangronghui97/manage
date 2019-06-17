package com.demo.needmanage.service;

import com.demo.needmanage.dto.ResponeCode;

public interface LoginService {

    public ResponeCode dologin(String name,String password,String type);

}
