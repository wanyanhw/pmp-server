//package com.wyhw.pmp.generator.executor;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.config.TemplateType;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
//import com.wyhw.pmp.generator.AbstractMainGenerator;
//import org.springframework.util.Assert;
//
//import java.util.Collections;
//
///**
// * Mybatis-plus 代码生成器，针对 3.5.1 及之后的新版本
// *
// * @author wanyanhw
// * @since 2021/12/15 15:56
// */
//public class GeneratorExecutorLatest extends AbstractMainGenerator {
//
//	@Override
//	public void execute() {
//		Assert.notNull(tables, "未设置表名称");
//		Assert.notNull(datasourceUrl, "未设置数据库连接");
//		FastAutoGenerator generator = FastAutoGenerator.create(datasourceUrl, username, password);
//		generator.globalConfig(builder -> {
//			if (!openDir) {
//				// 创建完成后禁止打开文件所在目录
//				builder.disableOpenDir();
//			}
//			if (fileOverride) {
//				// 运行重新覆盖已生成的文件
//				builder.fileOverride();
//			}
//			builder.author(author)
//					// 文件输出目录
//					.outputDir(basePath)
//					// 注释的日期格式
//					.commentDate(dateFormat)
//					// 数据库时间类型 到 实体类时间类型 对应策略
//					.dateType(DateType.TIME_PACK)
//					.build();
//		})
//				.packageConfig(builder -> {
//					builder.parent(parentPackage)
//							.entity(entityPackageName)
//							.controller(controllerPackageName)
//							.service(servicePackageName)
//							.serviceImpl(serviceImplPackageName)
//							.mapper(mapperPackageName)
//							// 文件路径配置，优先级最高，以上entity、controller、service、mapper文件均可以通过添加到配置Map，实现在配置的路径下生成对应的文件
//							.pathInfo(Collections.singletonMap(OutputFile.mapperXml, mapperXmlPath))
//							.build();
//				})
//				.strategyConfig(builder -> {
//					builder.addInclude(tables)
//							// controller 策略
//							.controllerBuilder()
//							// 生成 @RestController
//							.enableRestStyle()
//							// 格式化 Controller 文件名称-添加"Controller"后缀
//							.formatFileName("%s" + controllerSuffix)
//
//							// service 策略
//							.serviceBuilder()
//							// 格式化 Service 文件名称-添加"Service"后缀
//							.formatServiceFileName("%s" + serviceSuffix)
//							// 格式化 ServiceImpl 文件名称-添加"ServiceImpl"后缀
//							.formatServiceImplFileName("%s" + serviceImplSuffix)
//
//							// mapper 策略
//							.mapperBuilder()
//							// 格式化 Mapper.java 文件名称-添加"Mapper"后缀
//							.formatMapperFileName("%s" + mapperSuffix)
//							// 格式化 Mapper.xml 文件名称-添加"Mapper"后缀
//							.formatXmlFileName("%s" + mapperSuffix)
//							// 开启 @Mapper 注解
//							.enableMapperAnnotation()
//							// 开启 Mapper.xml 文件 baseResultMap
//							.enableBaseResultMap()
//							// 开启 Mapper.xml 文件 baseColumnList
//							.enableBaseColumnList()
//
//							// entity策略
//							.entityBuilder()
//							// 格式化 Entity.java 文件名称-添加"Entity"后缀
//							.formatFileName("%s" + entitySuffix)
//							// 开启生成实体时生成字段注解
//							.enableTableFieldAnnotation()
//							.build();
//				})
//				.templateEngine(new VelocityTemplateEngine())
//				.templateConfig(builder -> {
//					if (disableController) {
//						builder.disable(TemplateType.CONTROLLER);
//					}
//					if (disableService) {
//						builder.disable(TemplateType.SERVICE);
//					}
//					if (disableServiceImpl) {
//						builder.disable(TemplateType.SERVICEIMPL);
//					}
//					if (disableEntity) {
//						builder.disable(TemplateType.ENTITY);
//					}
//					if (disableMapper) {
//						builder.disable(TemplateType.MAPPER);
//					}
//					if (disableMapperXml) {
//						builder.disable(TemplateType.XML);
//					}
//				})
//				.execute();
//	}
//}
