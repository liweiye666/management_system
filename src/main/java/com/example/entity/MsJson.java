package com.example.entity;

import lombok.Data;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.entity
 * @Author: 利伟业
 * @Date: 2020/5/29 17:12
 */
@Data
public class MsJson {
    private int code;
    private String msg;
    private long count;
    private List<?> data;
}
