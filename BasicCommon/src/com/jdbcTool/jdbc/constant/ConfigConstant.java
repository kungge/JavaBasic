package com.jdbcTool.jdbc.constant;

/**
 * 使用枚举定义常量
 */
public enum  ConfigConstant {
    PROPERTIES_CONFIG_PATH("BasicCommon\\resources\\dataSource.properties");

    private String path;

    private ConfigConstant(String path){
        this.path=path;
    }

    public String getPath(){
        return this.path;
    }
}
