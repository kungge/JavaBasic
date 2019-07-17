package com.jdbcTool.jdbc.enums;

import com.jdbcTool.jdbc.config.PropertiesPlaceHolder;

/**
 * 定义获取数据库连接信息的枚举类
 */
public enum  DriverInfoEnum {
    DRIVER_CLASS{
        @Override
        public String getInfo(){
            return new PropertiesPlaceHolder().getProperty("jdbc.driver_class");
        }
    },
    URL{
        @Override
        public String getInfo(){
            return new PropertiesPlaceHolder().getProperty("jdbc.url");
        }
    },
    USERNAME{
        @Override
        public String getInfo(){
            return new PropertiesPlaceHolder().getProperty("jdbc.username");
        }
    },
    PASSWORD{
        @Override
        public String getInfo(){
            return new PropertiesPlaceHolder().getProperty("jdbc.password");
        }
    };

    public abstract String getInfo();
}
