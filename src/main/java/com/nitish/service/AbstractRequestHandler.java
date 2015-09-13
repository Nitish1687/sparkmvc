package com.nitish.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitish.Bean.BeanValidator;
import com.nitish.Bean.Output;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public abstract class AbstractRequestHandler<V extends BeanValidator> implements RequestHandler<V>, Route {

    private Class<V> valueClass;
    protected UserDao userDao;

    private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e){
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }

    public AbstractRequestHandler(Class<V> valueClass, UserDao userDao){
        this.valueClass = valueClass;
        this.userDao = userDao;
    }

    public final Output process(V value, Map<String, String> urlParams, boolean shouldReturnHtml) {
            return processImpl(value, urlParams, shouldReturnHtml);
    }

    protected abstract Output processImpl(V value, Map<String, String> urlParams, boolean shouldReturnHtml);


    @Override
    public Object handle(Request request, Response response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String verb = request.requestMethod();
        V value = null;
        if (!verb.equalsIgnoreCase("GET")) {
            value = objectMapper.readValue(request.body(), valueClass);
        }
        Output output = process(value, request.params(), shouldReturnHtml(request));
        response.status(output.getCode());
        if (shouldReturnHtml(request)) {
            response.type("text/html");
        } else {
            response.type("application/json");
        }
        response.body(output.getBody());
        return output.getBody();
    }

}
