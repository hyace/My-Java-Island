package domain;

import java.util.Date;

/**
 * Author: 张晖
 * MIS: zhanghui20
 * Date: 16/2/29
 * Email: zhanghui20@meituan.com
 */
public class Table {
    int id;
    String value;
    Date dt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
}
