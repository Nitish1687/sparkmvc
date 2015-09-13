package com.nitish.model;

import lombok.Data;
import lombok.ToString;

/**
 * Created by nsm1211 on 11-09-2015.
 */

@Data
@ToString(includeFieldNames = true)
public class UserModel extends Model {

    private String userId;
    private String name;
    private String emailId;
}
