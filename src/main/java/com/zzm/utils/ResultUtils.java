package com.zzm.utils;

import com.zzm.exception.BizExceptionEnum;

public class ResultUtils {

    /**
     * 返回成功消息
     *
     * @param object 传入的对象
     * @return
     */
    public static ResultDTO success(Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(BizExceptionEnum.SUCCESS.getCode());
        resultDTO.setMessage(BizExceptionEnum.SUCCESS.getMessage());
        resultDTO.setData(object);
        return resultDTO;
    }

    /**
     * 成功不返回信息
     *
     * @return
     */
    public static ResultDTO success() {
        return success(null);
    }


    /**
     * 自定义成功消息
     *
     * @param code 状态码
     * @param msg  返回消息
     * @return
     */
    public static ResultDTO messages(int code, String msg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(msg);
        return resultDTO;
    }

    public static ResultDTO messages(BizExceptionEnum msg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(msg.getCode());
        resultDTO.setMessage(msg.getMessage());
        return resultDTO;
    }

    public static ResultDTO messages(BizExceptionEnum msg, Object data) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(msg.getCode());
        resultDTO.setMessage(msg.getMessage());
        resultDTO.setData(data);
        return resultDTO;
    }

    public static ResultDTO errorMessage() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(BizExceptionEnum.SERVER_EXCEPTION.getCode());
        resultDTO.setMessage(BizExceptionEnum.SERVER_EXCEPTION.getMessage());
        return resultDTO;
    }


    /**
     * 自定义成功消息
     *
     * @param msg    返回消息
     * @param object 返回数据
     * @return
     */
    public static ResultDTO customSuccess(String msg, Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(BizExceptionEnum.SERVER_EXCEPTION.getCode());
        resultDTO.setMessage(msg);
        resultDTO.setData(object);
        return resultDTO;
    }

    /**
     * 返回失败消息
     *
     * @param code 传入的编码
     * @param msg  信息
     * @return
     */
    public static ResultDTO error(int code, String msg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(msg);
        return resultDTO;
    }

    /**
     * @param code   传入的编码
     * @param msg    信息
     * @param object 传入的对象
     * @return
     */
    public static ResultDTO result(int code, String msg, Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(msg);
        resultDTO.setData(object);
        return resultDTO;
    }

}
