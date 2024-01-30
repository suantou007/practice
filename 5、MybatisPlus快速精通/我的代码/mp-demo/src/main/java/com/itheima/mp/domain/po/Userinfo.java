package com.itheima.mp.domain.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Userinfo {
    private Integer age;
    private String intro;
    private String gender;
}
