package com.demo.needmanage.Controller;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.UploadUtil;
import com.demo.needmanage.dto.*;
import com.demo.needmanage.entity.*;
import com.demo.needmanage.service.NoticeService;
import com.demo.needmanage.service.StandardService;
import com.demo.needmanage.service.StudentService;
import com.demo.needmanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/student")
public class StudentController {

    private String filePath="E:/manage/images/";

    @Autowired
    private StudentService studentService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private TypeService typeService;

    /**
     * 学生注册
     * @param student
     * @return
     */
    @PostMapping("/list")
    public ResponeCode addStudent(@RequestBody Student student) {

        return this.studentService.addStudent(student);

    }

    @GetMapping("/depatment")
    public ResponeCode findDepatment(){
        ResponeCode<StudentListDto> responeCode = this.studentService.getStudents(0,10);
        responeCode.getData().setEntitys(null);
        responeCode.getData().setTotal(null);
        return responeCode;
    }


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

    @PutMapping("/info")
    public ResponeCode modifyInfo(@RequestBody Student student, HttpSession session){

        ResponeCode<LoginResponse<Student>> responeCode = this.studentService.modifyStudentByStudent(student);
        if (responeCode.getStatus()!=null&&responeCode.getStatus()==200){
            session.setAttribute("user",responeCode.getData());
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }

        return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);


    }

    @PutMapping("/password")
    public ResponeCode modifyPassword(@RequestBody AdminDto adminDto){

        return this.studentService.modifyPassword(adminDto);

    }


    /**
     * 提交申请表
     * @param apply
     * @return
     */
    @PostMapping("/apply/list")
    public ResponeCode addApply(@RequestBody Apply apply){

        return this.studentService.addApply(apply);

    }

    @PutMapping("/apply/list")
    public ResponeCode modifyApply(@RequestBody Apply apply){

        return this.studentService.modifyApply(apply);
    }

    /**
     * 查看申请表
     * @param session
     * @return
     */
    @GetMapping("/apply/list")
    public ResponeCode getApply(HttpSession session){

        LoginResponse user = (LoginResponse) session.getAttribute("user");

        if (user==null){
            return ResponeCode.newResponeCode(MessageCode.LOGIN_OUT);
        }else {
            StudentDto studentDto = (StudentDto) user.getInfo();
            return this.studentService.findApplyByStudentNum(studentDto.getStudentNum());
        }

    }

    /**
     * 上传图片
     * @param
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponeCode upload(HttpServletRequest request, MultipartFile file){

        try{
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            UploadUtil.uploadFile(file.getBytes(),this.filePath,fileName);
            Apply apply = new Apply();
            apply.setImageAdd(fileName);
            ResponeCode<Apply> responeCode = ResponeCode.newResponeCode(MessageCode.UPLOAD_SUCCESS);
            responeCode.setData(apply);
            return responeCode;
        }catch (Exception e){

            return ResponeCode.newResponeCode(MessageCode.UPLOAD_FAIL);

        }




    }

}
