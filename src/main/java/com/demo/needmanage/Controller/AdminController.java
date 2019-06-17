package com.demo.needmanage.Controller;
import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.dto.*;
import com.demo.needmanage.entity.*;
import com.demo.needmanage.entity.Class;
import com.demo.needmanage.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/admin")
public class AdminController {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private DepatmentService depatmentService;

    @Autowired
    private SpecialService specialService;

    @Autowired
    private ClassService classService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ApplyService applyService;

    /**
     * 修改管理员基本信息
     * @param admin
     * @param session
     * @return
     */
    @PutMapping("/info")
    public ResponeCode modifyInfo(@RequestBody Admin admin, HttpSession session){

        ResponeCode<LoginResponse<Admin>> responeCode = this.adminService.modifyInfo(admin);
        if (responeCode.getStatus()!=null&&responeCode.getStatus()==200){
            session.setAttribute("user",responeCode.getData());
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }

        return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);


    }

    /**
     * 修改管理员密码
     * @param adminDto
     * @return
     */
    @PutMapping("/password")
    public ResponeCode modifyPassword(@RequestBody AdminDto adminDto){

        return this.adminService.modifyPassword(adminDto);

    }


    //******************************管理公告模块开始***************************************8

    /**
     * 增加公告
     * @param notice
     * @return
     */
    @PostMapping("/notice/list")
    public ResponeCode addNotice(@RequestBody Notice notice) {



        return this.noticeService.addNotice(notice);

    }

    /**
     * 获得公告列表
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/notice/list")
    public ResponeCode<ListDto<Notice>> getNotices(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        logger.info("获得公告列表");

        return this.noticeService.getNotices(offset, limit);

    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @PutMapping("/notice/list")
    public ResponeCode modifyNotice(@RequestBody Notice notice){

        return this.noticeService.modifyNotice(notice);

    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @DeleteMapping("/notice/list/{id}")
    public ResponeCode DeleteNotice(@PathVariable("id") Integer id) {

        return this.noticeService.deleteNotice(id);

    }


    //**************************管理公告结束*****************************************************

    //**********************************管理系部开始*************************************************8

    @PostMapping("/depatment/list")
    public ResponeCode addDepatment(@RequestBody Depatment depatment) {

        return this.depatmentService.addDepatment(depatment);

    }

    @GetMapping("/depatment/list")
    public ResponeCode<ListDto<Depatment>> getDepatments(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.depatmentService.getDepatments(offset, limit);

    }

    @DeleteMapping("/depatment/list/{id}")
    public ResponeCode deleteDepatment(@PathVariable("id") Integer id) {

        return this.depatmentService.deleteDepatment(id);


    }

    @PutMapping("/depatment/list")
    public ResponeCode modifyDepatment(@RequestBody Depatment depatment){

        return this.depatmentService.modifyDepatment(depatment);

    }

    //**********************************管理系部结束*************************************************8

    //**********************************管理专业开始*************************************************8
    @PostMapping("/special/list")
    public ResponeCode addSpecial(@RequestBody Special special) {

        return this.specialService.addSpecial(special);

    }

    @GetMapping("/special/list")
    public ResponeCode<SpecialListDto> getSpecials(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.specialService.getSpecials(offset, limit);

    }

    @DeleteMapping("/special/list/{id}")
    public ResponeCode deleteSpecial(@PathVariable("id") Integer id) {

        return this.specialService.deleteSpecial(id);


    }

    @PutMapping("/special/list")
    public ResponeCode modifySpecial(@RequestBody Special special){

        return this.specialService.modifySpecial(special);

    }

    //**********************************管理专业结束*************************************************8



    //**********************************管理班级开始*************************************************8
    @PostMapping("/class/list")
    public ResponeCode addClass(@RequestBody Class cla) {

        return this.classService.addClass(cla);

    }

    @GetMapping("/class/list")
    public ResponeCode<ClassListDto> getClasses(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.classService.getClasses(offset, limit);

    }

    @DeleteMapping("/class/list/{id}")
    public ResponeCode deleteClass(@PathVariable("id") Integer id) {

        return this.classService.deleteClass(id);


    }

    @PutMapping("/class/list")
    public ResponeCode modifyClass(@RequestBody Class cla){

        return this.classService.modifyClass(cla);

    }

    //**********************************管理班级结束*************************************************8


    //**********************************管理辅导员开始*************************************************8
    @PostMapping("/instructor/list")
    public ResponeCode addInstructor(@RequestBody Instructor instructor) {

        return this.instructorService.addInsructor(instructor);

    }

    @GetMapping("/instructor/list")
    public ResponeCode<ListDto<Instructor>> getInstructors(@RequestParam Integer offset, @RequestParam(required = false) Integer limit,@RequestParam(required = false) String number) {

        return this.instructorService.getInstructors(offset, limit,number);

    }

    @DeleteMapping("/instructor/list/{id}")
    public ResponeCode deleteInstructor(@PathVariable("id") Integer id) {

        return this.instructorService.deleteInstructor(id);


    }

    @PutMapping("/instructor/list")
    public ResponeCode modifyInstructor(@RequestBody Instructor instructor){

        return this.instructorService.modifyInstructor(instructor);

    }

    //**********************************管理辅导员结束*************************************************8
    //******************************管理资助金类型模块开始***************************************8
    @PostMapping("/type/list")
    public ResponeCode addType(@RequestBody Type type) {

        return this.typeService.addType(type);

    }

    @GetMapping("/type/list")
    public ResponeCode<ListDto<Type>> getTypes(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.typeService.getTypes(offset, limit);

    }

    @PutMapping("/type/list")
    public ResponeCode modifyType(@RequestBody Type type){

        return this.typeService.modifyType(type);

    }

    @DeleteMapping("/type/list/{id}")
    public ResponeCode DeleteType(@PathVariable("id") Integer id) {

        return this.typeService.deleteType(id);

    }


    //**************************管理资助金结束*****************************************************
    //******************************管理审核标准类型模块开始***************************************8
    @PostMapping("/standard/list")
    public ResponeCode addStandard(@RequestBody Standard standard) {

        return this.standardService.addStandard(standard);

    }

    @GetMapping("/standard/list")
    public ResponeCode<ListDto<Standard>> getStandard(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.standardService.getStandards(offset, limit);

    }

    @PutMapping("/standard/list")
    public ResponeCode modifyStandard(@RequestBody Standard standard){

        return this.standardService.modifyStandard(standard);

    }

    @DeleteMapping("/standard/list/{id}")
    public ResponeCode DeleteStandard(@PathVariable("id") Integer id) {

        return this.standardService.deleteStandard(id);

    }


    //**************************管理资审核结束*****************************************************
    //******************************管理学生模块开始***************************************8
    @PostMapping("/student/list")
    public ResponeCode addStudent(@RequestBody Student student) {

        return this.studentService.addStudent(student);

    }

    @GetMapping("/student/list")
    public ResponeCode<StudentListDto> getStudent(@RequestParam Integer offset, @RequestParam(required = false) Integer limit) {

        return this.studentService.getStudents(offset, limit);

    }

    @PutMapping("/student/list")
    public ResponeCode modifyStudent(@RequestBody Student student){

        return this.studentService.modifyStudent(student);

    }

    @DeleteMapping("/student/list/{id}")
    public ResponeCode DeleteStudent(@PathVariable("id") Integer id) {

        return this.studentService.deleteStudent(id);

    }


    //**************************管理学生结束*****************************************************

    /**
     * 查看已经通过初审列表
     * @return
     */
    @GetMapping("/apply/list")
    public ResponeCode findApply(@RequestParam Integer offset, @RequestParam(required = false) Integer limit){

        return this.applyService.findApplyByStatus(1,offset,limit);

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
