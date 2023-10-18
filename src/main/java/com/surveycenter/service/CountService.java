package com.surveycenter.service;

import org.springframework.stereotype.Service;

@Service
public interface CountService {
    int updateCount(int sid);//更新统计数据

    int getNum(int sid);//获取问卷统计数据
}
