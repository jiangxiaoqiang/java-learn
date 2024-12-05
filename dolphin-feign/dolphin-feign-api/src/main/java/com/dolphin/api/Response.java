package com.dolphin.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Data
@Schema
public class Response<T> {

    public static final String MSG_OK		= "ok";

    @Schema(title="业务处理代码", example="1000", required=false)
    private String resultCode = "200";

    @Schema(title="状态码", example="200", required=true)
    private String statusCode = "200";

    @Schema(title="状态描述", required=false)
    private String msg = MSG_OK;

    @Schema(title="业务模型对象", required=false)
    private T result;

    @Schema(title="参数校验错误列表", example="name is empty", required=false)
    private Map<String, List<String>> validationErrors;


    public Response(String msg, String statusCode, String resultCode) {
        this.msg = msg;
        this.statusCode = statusCode;
        this.resultCode = resultCode;
    }

    public Response(T result)
    {
        this.result = result;
    }

    public Response() {
    }
}
