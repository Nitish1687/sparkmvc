package com.nitish.mapper;

import com.nitish.Bean.Bean;
import com.nitish.model.Model;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public interface BasicMapper<L,R> {
    R mapToModel(Bean bean);
    L mapToBean(Model model);

}
