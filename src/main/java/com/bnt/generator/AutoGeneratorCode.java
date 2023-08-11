package com.bnt.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 代码生成器
 *
 * @author bnt
 * @version 1.0.0
 * @create 2022/11/23 14:42 bnt
 * @history
 */
public class AutoGeneratorCode {
    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://192.168.113.2:3306/mitapp?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false", "root", "RZVJR5k4c3WmbLcd");

    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("bnt")
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 覆盖已生成文件
                            .fileOverride()
                            // 指定输出目录
                            .outputDir("F://");
                })
                .packageConfig(builder -> {
                    // 设置包名
                    builder.parent("com.sinosoft")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .controller("controller");
                })
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder()
                        //开启生成实体时生成字段注解
                        .enableTableFieldAnnotation()
                        // 开启 lombok 模型
                        .enableLombok()
                        // 添加表字段填充
                        .addTableFills(new Column("create_date", FieldFill.INSERT))
                        .addTableFills(new Column("update_date", FieldFill.INSERT_UPDATE))
                        .addTableFills(new Column("del_flag", FieldFill.INSERT))
                        .idType(IdType.ID_WORKER_STR)
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .mapperBuilder()
                        .enableMapperAnnotation()
                        .build())

                // 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                .templateEngine(new FreemarkerTemplateEngine())
                // 执行
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


    /**
     * 执行 run
     */
    public static void main2(String[] args) throws SQLException {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("bnt")
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 覆盖已生成文件
                            .fileOverride()
                            // 指定输出目录
                            .outputDir("F://");
                })
                .packageConfig(builder -> {
                    // 设置包名
                    builder.parent("com.sinosoft")
                            .entity("entity")
                            .service("module.proposal.service")
                            .serviceImpl("module.proposal.service.impl")
                            .mapper("mapper")
                            .controller("module.proposal.controller");
                })
                .strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude("app_error_log");
                    builder.entityBuilder()
                            //开启生成实体时生成字段注解
                            .enableTableFieldAnnotation()
                            // 开启 lombok 模型
                            .enableLombok()
                            // 添加表字段填充
                            .addTableFills(new Column("create_date", FieldFill.INSERT))
                            .addTableFills(new Column("update_date", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("del_flag", FieldFill.INSERT))
                            .idType(IdType.ID_WORKER_STR);
                    builder.controllerBuilder()
                            .enableRestStyle();
                    builder.serviceBuilder()
                            .formatServiceFileName("%sService");
                    builder.mapperBuilder()
                            .enableMapperAnnotation();
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
