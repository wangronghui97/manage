package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.ClassMapper;
import com.demo.needmanage.dao.DepatmentMapper;
import com.demo.needmanage.dao.SpecialMapper;
import com.demo.needmanage.dao.StudentMapper;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.dto.SpecialListDto;
import com.demo.needmanage.entity.Depatment;
import com.demo.needmanage.entity.Special;
import com.demo.needmanage.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialMapper specialMapper;

    @Autowired
    private DepatmentMapper depatmentMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResponeCode addSpecial(Special special) {

        if (special==null|| StringUtils.isEmpty(special.getName())||special.getDepatmentId()==null){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

        Special special1 = this.specialMapper.selectBySelective(special);
        if (special!=null){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_SPECIAL);
        }

        int result = this.specialMapper.insertSelective(special);

        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

    }

    @Override
    public ResponeCode<SpecialListDto> getSpecials(Integer offset, Integer limit) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        Integer total = this.specialMapper.selectAllSpecial().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        SpecialListDto listDto = new SpecialListDto();
        listDto.setTotal(total);
        listDto.setEntitys(this.specialMapper.selectByOffset(offset,limit));
        listDto.setDepatments(this.depatmentMapper.selectAllDepatment());

        ResponeCode<SpecialListDto> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;
    }

    @Override
    public ResponeCode deleteSpecial(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
        int code = this.specialMapper.deleteByPrimaryKey(id);
        if (code>0){
            //删除班级
            List<Integer> list = this.classMapper.selectBySpecialId(id);
            for (Integer integer:list){
                //删除班级
                this.classMapper.deleteByPrimaryKey(integer);
                //删除班级的学生
                this.studentMapper.deleteByClass(integer);
            }

            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
    }

    @Override
    public ResponeCode modifySpecial(Special special) {

        if (special==null||special.getId()==null||special.getDepatmentId()==null||StringUtils.isEmpty(special.getName())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

        int code = this.specialMapper.updateByPrimaryKeySelective(special);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
    }
}
