package com.example.entity;

import lombok.Data;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.entity
 * @Author: 周博义
 * @Date: Created in 2020/5/30 10:59
 */
@Data
public class MsTree {

    private String title;
    private int id;
    private String field;
    private boolean checked;
    private boolean spread;
    private String url;
    private List<MsTree> children;
}
