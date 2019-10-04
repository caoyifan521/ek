package com.qfedu.ek.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class JsonResult {

    @ApiModelProperty(value = "返回数据状态编码，1正常返回，其他，表示异常")
    private int code;

    @ApiModelProperty(value = "返回的前端数据")
    private Object info;

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
