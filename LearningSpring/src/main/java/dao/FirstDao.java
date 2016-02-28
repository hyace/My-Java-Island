package dao;

import domain.Table;
import org.apache.ibatis.annotations.Param;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/29
 * Email: zhanghui20@meituan.com
 */
public interface FirstDao {
    public Table selectTable(@Param("id")int id);
}
