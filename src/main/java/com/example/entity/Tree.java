package com.example.entity;

import lombok.Data;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.entity
 * @Author: 周博义
 * @Date: Created in 2020/6/1 15:18
 */
@Data
public class Tree {
    private String title;
    private int id;
    private boolean checked;
    private boolean spread;
    private String url;
    private List<MsTree> children;
}
