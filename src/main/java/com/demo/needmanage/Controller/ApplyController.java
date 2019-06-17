package com.demo.needmanage.Controller;

import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/apply")
@RestController
public class ApplyController {

    @Autowired
    private ApplyService applyService;


    @RequestMapping("/list")
    public ResponeCode getApplySuccess(@RequestParam Integer offset, @RequestParam(required = false)Integer limit){

        return this.applyService.getApplySuccess(offset, limit);

    }

    @RequestMapping("/total")
    public ResponeCode getTotal(){

        return this.applyService.getTotal();

    }

}
