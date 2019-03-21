package com.wxiip.util;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月14日  11：16
 * @Description: 响应码
 */
public enum ResponseCode {
    success("操作成功上链或查询成功","151000"),
    failed("上链失败","151001"),
    lackOfSourceSystem("缺少来源系统","151002"),
    lackOfSign("缺少公钥或公钥签名","151003"),
    pubKeySignFailedVerified("公钥签名未通过验签","151004"),
    importPubKeyRepeatedly("重复导入公钥","151005"),
    readFailure("读取失败","151006"),
    dataSignFailedVerified("数据签名未通过验签","151007"),
    lackOfDataSign("缺少数据签名","151008"),
    injectPubKeyFailed("注入公钥失败","151009"),
    lackOfIndexHash("缺少indexHash","151010"),
    lackOfBrief("缺少brief","151011"),
    lackOfUserId("缺少userId","151012"),
    notFoundDataOnChain("未找到链上数据","151013"),
    requestParamLackBatchData("请求参数缺少批量数据","151014"),
    paramOverrun("参数超限，参数最大长度","151015"),
    userDontExist("用户不存在","151016");

    private String code;
    private String instructions;

    ResponseCode(String code, String instructions) {
        this.code = code;
        this.instructions = instructions;
    }

    public static String getResponseInstruction(String code){
        for(ResponseCode rc:ResponseCode.values()){
            if(rc.getCode().equals(code)){
                return rc.getInstructions();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
