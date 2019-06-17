package com.demo.needmanage.service;

import com.demo.needmanage.dto.AdminDto;
import com.demo.needmanage.dto.LoginResponse;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Admin;

public interface AdminService {

    public ResponeCode<LoginResponse<Admin>> modifyInfo(Admin admin);

    public ResponeCode modifyPassword(AdminDto adminDto);

}
