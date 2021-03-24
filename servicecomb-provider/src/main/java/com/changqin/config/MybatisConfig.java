package com.changqin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.changqin.dao")
public class MybatisConfig {
}
