package com.tReAsures.demo.framework;


import com.tReAsures.demo.framework.enums.ResultEnum;

/**
 * 统一返回格式类
 * Created by ShuoLIANG
 */
public class ResponseModel {
    private int status;
    private Object result;
    private String errorMsg = "OK";

    public static ResponseModel ok(Object result){
        return  new ResponseModel(0,result);
    }
    
   
    public static ResponseModel exception(String errorMsg){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(ResultEnum.EXCEPTION_ERROR.getCode());
        responseModel.setResult("{}");
        responseModel.setErrorMsg(errorMsg);
        return responseModel;
    }

    public static ResponseModel error(ResultEnum resultEnum){
        return new ResponseModel(resultEnum.getCode(),"{}",resultEnum.getMsg());
    }

    public ResponseModel(int status, Object result, String errorMsg) {
        this.status = status;
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public ResponseModel(int status, Object result) {
        this.status = status;
        this.result = result;
    }
    public ResponseModel() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
