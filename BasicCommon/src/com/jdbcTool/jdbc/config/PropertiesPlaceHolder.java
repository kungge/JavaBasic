package com.jdbcTool.jdbc.config;

import java.io.InputStream;

import java.util.Properties;

import com.jdbcTool.jdbc.constant.ConfigConstant;


/**
 * 资源文件处理器
 */
public class PropertiesPlaceHolder extends Properties {
    private static final long serialVersionUID=1L;

    public PropertiesPlaceHolder(){
        String path=ConfigConstant.PROPERTIES_CONFIG_PATH.getPath();

        System.out.println("PropertiesPlaceHolder 获取 path="+path);

        try(
                InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream(path)
                ){
            this.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
