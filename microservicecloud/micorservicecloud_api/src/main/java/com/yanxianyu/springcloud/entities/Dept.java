package com.yanxianyu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

//@Data

//@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptno;//主键
    private String dname;//部门名称;
    private String db_source;//来自不同的数据库



}
