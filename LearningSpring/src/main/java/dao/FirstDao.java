package dao;

import domain.Table;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/29
 * Email: zhanghui20@meituan.com
 */
public interface FirstDao {
    public Table selectTable(@Param("id")int id);
    public int insertOrUpdateTable(@Param("table")Table table);
    public int insertTable(@Param("table")Table table);
    public int update(Table table);
    public Long testSqlDate(@Param("date")Date date);
}
