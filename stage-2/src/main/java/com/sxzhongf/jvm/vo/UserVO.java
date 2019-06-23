package com.sxzhongf.jvm.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * UserVO for : TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/6/22
 */
@Data
@NoArgsConstructor
public class UserVO {

    private int id;
    private String username;

    public UserVO(int id,String username){
        this.id = id;
        this.username = username;
    }
}
