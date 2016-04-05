package service;

import dao.FirstDao;
import domain.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

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
    public void insertTable(Table table){
        firstDao.insertTable(table);
    }
    public int insertOrUpdateTable(Table table){
        return firstDao.insertOrUpdateTable(table);
    }
    public int update(Table table){
        return firstDao.update(table);
    }
    public long testSqlDate(Date date){
        return firstDao.testSqlDate(date);
    }
}
