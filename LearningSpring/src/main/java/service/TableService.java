package service;

import dao.FirstDao;
import domain.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/29
 * Email: zhanghui20@meituan.com
 */
@Service
public class TableService {
    @Autowired
    private FirstDao firstDao;
    public Table getTable(int id){
        return firstDao.selectTable(id);
    }
}
