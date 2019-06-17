package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.AdminMapper;
import com.demo.needmanage.dto.AdminDto;
import com.demo.needmanage.dto.LoginResponse;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Admin;
import com.demo.needmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResponeCode<LoginResponse<Admin>> modifyInfo(Admin admin) {

        if (admin==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

        int code = this.adminMapper.updateByPrimaryKeySelective(admin);

        if (code>0){
            LoginResponse<Admin> loginResponse = new LoginResponse<>();
            loginResponse.setType("admin");
            loginResponse.setInfo(this.adminMapper.selectByPrimaryKey(admin.getId()));
            ResponeCode<LoginResponse<Admin>> loginResponseResponeCode = ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
            loginResponseResponeCode.setData(loginResponse);
            return loginResponseResponeCode;
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);

        }

    }

    @Override
    public ResponeCode modifyPassword(AdminDto adminDto) {

        if (adminDto==null||adminDto.getId()==null||StringUtils.isEmpty(adminDto.getPassword())||StringUtils.isEmpty(adminDto.getOldpassword())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);
        }
        Admin admin = this.adminMapper.selectByPrimaryKey(adminDto.getId());
        if (admin==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);
        }
        if (!adminDto.getOldpassword().equals(admin.getPassword())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL_OLD);
        }
        admin.setPassword(adminDto.getPassword());
        int code = this.adminMapper.updateByPrimaryKeySelective(admin);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);

        }


    }
}
