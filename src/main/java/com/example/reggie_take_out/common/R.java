package com.example.reggie_take_out.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZEYANG1
 */

@Data
public class R<T> {
    // 编码
    private Integer code;
    // 错误信息
    private String msg;
    // 数据
    private T date;
    // 动态数据
    private Map<String, Object> map = new HashMap<>();

    public static <T> R<T> success(T object) {
        R<T> r = new R<>();
        r.date = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
