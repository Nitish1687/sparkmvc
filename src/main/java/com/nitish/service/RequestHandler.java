package com.nitish.service;

import com.nitish.Bean.BeanValidator;
import com.nitish.Bean.Output;

import java.util.Map;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public interface RequestHandler<V extends BeanValidator> {
    Output process(V value, Map<String, String> urlParams, boolean isHtmlNeeded);
}
