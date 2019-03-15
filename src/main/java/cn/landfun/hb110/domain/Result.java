package cn.landfun.hb110.domain;

import lombok.Data;

import java.util.List;

@Data
public class Result {

    private int code;
    private String message;
    private List<String> data;


}
