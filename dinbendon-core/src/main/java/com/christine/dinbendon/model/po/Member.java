package com.christine.dinbendon.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    /**
     * 自增主鍵
     */
    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 建立时间
     */
    private LocalDateTime createTime;
    /**
     * 最后登入时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 登入失敗次數
     */
    private Integer loginFailureTimes;
    /**
     * 狀態，NORMAL:可登入  LOCK:鎖定
     */
    private String status;


}
