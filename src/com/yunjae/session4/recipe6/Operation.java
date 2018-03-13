package com.yunjae.session4.recipe6;

import lombok.Data;

import java.util.Date;

@Data
public class Operation {
    private String user;
    private String operation;
    private Date time;
}
