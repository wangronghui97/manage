package com.demo.needmanage.service;

import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Notice;

public interface NoticeService {

    ResponeCode addNotice(Notice notice);

    ResponeCode<ListDto<Notice>> getNotices(Integer offset, Integer limit);

    ResponeCode deleteNotice(Integer id);

    ResponeCode modifyNotice(Notice notice);


}
