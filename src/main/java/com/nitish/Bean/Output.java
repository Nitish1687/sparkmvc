package com.nitish.Bean;

public class Output {

    public Output(int code) {
        this.code = code;
        this.body = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Output output = (Output) o;

        if (code != output.code) return false;
        if (body != null ? !body.equals(output.body) : output.body != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Output(code=" + code + ", body=" + body + ")";
    }

    public String getBody() {
        return body;
    }

    public int getCode() {
        return code;
    }

    private int code;
    private String body;

    public Output(int code, String body){
        this.code = code;
        this.body = body;
    }

    public static Output ok(String body) {
        return new Output(200, body);
    }

    public static Output badRequest(String body) {
        return new Output(400, body);
    }

    public static Output NotFound(String body) {
        return new Output(404, body);
    }
}
