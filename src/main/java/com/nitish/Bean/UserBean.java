package com.nitish.Bean;

import lombok.Data;
import lombok.ToString;

/**
 * Created by nsm1211 on 10-09-2015.
 */
@Data
@ToString
public class UserBean extends  Bean implements BeanValidator{
    private int userId;
    private String name;
    private String emailId;

    @Override
    public boolean isValid() {
        return userId > 0 && null != name && null != emailId;
    }
}
