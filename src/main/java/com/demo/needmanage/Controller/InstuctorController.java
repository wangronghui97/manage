package com.demo.needmanage.Controller;

import com.demo.needmanage.comment.MessageCode;

import com.demo.needmanage.dto.*;
import com.demo.needmanage.entity.*;
import com.demo.needmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/instructor")
public class InstuctorController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private ApplyService applyService;

    /**
     * 浏览公告
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/notice/list")
    public ResponeCode<ListDto<Notice>> getNotices(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.noticeService.getNotices(offset, limit);

    }

    /**
     * 查看审核标准
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/standard/list")
    public ResponeCode<ListDto<Standard>> getStandard(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.standardService.getStandards(offset, limit);

    }

    @GetMapping("/type/list")
    public ResponeCode<ListDto<Type>> getTypes(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.typeService.getTypes(offset, limit);

    }

    /**
     * 查看贫困生信息
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/student/list")
    public ResponeCode<StudentListDto> getStudent(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.studentService.getStudents(offset, limit);

    }

    @PutMapping("/info")
    public ResponeCode modifyInfo(@RequestBody Instructor instructor, HttpSession session){

        ResponeCode<LoginResponse<Instructor>> responeCode = this.instructorService.modifyInstructorByInstructor(instructor);
        if (responeCode.getStatus()!=null&&responeCode.getStatus()==200){
            session.setAttribute("user",responeCode.getData());
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }

        return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);


    }

    @PutMapping("/password")
    public ResponeCode modifyPassword(@RequestBody AdminDto adminDto){

        return this.instructorService.modifyPassword(adminDto);

    }

    /**
     * 查看贫困申请表
     * @return
     */
    @GetMapping("/apply/list")
    public ResponeCode findApply(@RequestParam Integer offset, @RequestParam(required = false) Integer limit){

        return this.applyService.findApplyByStatus(0,offset,limit);

    }


    /**
     * 更改状态
     * @param apply
     * @return
     */
    @PostMapping("/apply/status")
    public ResponeCode changStatus(@RequestBody Apply apply){

        if (apply.getId()==null||apply.getStatus()==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
        return this.applyService.changeStatus(apply.getStatus(),apply.getId());


    }


}
