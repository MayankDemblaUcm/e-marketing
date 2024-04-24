package com.ucm.adbms.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserModel {


    private String email;
    private String password;
    private String family_name ;

    private String profile_pic ;

}
