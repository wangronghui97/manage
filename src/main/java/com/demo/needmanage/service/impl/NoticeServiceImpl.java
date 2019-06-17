package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.NoticeMapper;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Notice;
import com.demo.needmanage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public ResponeCode addNotice(Notice notice) {

        if (notice==null|| StringUtils.isEmpty(notice.getTitle())||StringUtils.isEmpty(notice.getContent())){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

        int result = this.noticeMapper.insertSelective(notice);
        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

    }


    @Override
    public ResponeCode<ListDto<Notice>> getNotices(Integer offset, Integer limit) {

        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        Integer total = this.noticeMapper.selectAllNotice().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ListDto<Notice> listDto = new ListDto<>();
        listDto.setTotal(total);
        listDto.setEntitys(this.noticeMapper.selectByOffset(offset,limit));

        ResponeCode<ListDto<Notice>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;

    }

    @Override
    public ResponeCode deleteNotice(Integer id) {

        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }

        int code = this.noticeMapper.deleteByPrimaryKey(id);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }

    }


    @Override
    public ResponeCode modifyNotice(Notice notice) {

        if (notice==null||notice.getId()==null||StringUtils.isEmpty(notice.getTitle())||StringUtils.isEmpty(notice.getContent())){

            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);

        }

        int code = this.noticeMapper.updateByPrimaryKeySelective(notice);

        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

    }
}
