package com.wyhw.pmp.generator.executor;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.wyhw.pmp.generator.AbstractMainGenerator;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Map;

/**
 * Mybatis-plus 代码生成器，针对 3.5.1 之前的旧版本
 *
 * @author wanyanhw
 * @since 2021/12/15 16:01
 */
public class GeneratorExecutorOriginal extends AbstractMainGenerator {

	@Override
	public void execute() {
		Assert.notNull(tables, "未设置表名称");
		Assert.notNull(datasourceUrl, "未设置数据库连接");
		DataSourceConfig dataSourceConfig = new DataSourceConfig()
				.setDriverName(driver)
				.setUrl(datasourceUrl)
				.setUsername(username)
				.setPassword(password);
		GlobalConfig globalConfig = new GlobalConfig();
		if (fileOverride) {
			globalConfig.setFileOverride(true);
		}
		if (!openDir) {
			globalConfig.setOpen(false);
		}
		globalConfig.setAuthor(author)
				.setOutputDir(basePath)
				.setDateType(DateType.TIME_PACK)
				.setControllerName("%s" + controllerSuffix)
				.setEntityName("%s" + entitySuffix)
				.setServiceName("%s" + serviceSuffix)
				.setServiceImplName("%s" + serviceImplSuffix)
				.setMapperName("%s" + mapperSuffix)
				.setXmlName("%s" + mapperSuffix)
				.setBaseColumnList(true)
				.setBaseResultMap(true);

		PackageConfig packageConfig = new PackageConfig();
		Map<String, String> packagePathInfo = CollectionUtils.newHashMapWithExpectedSize(6);
		if (!disableController) {
			packagePathInfo.put(ConstVal.CONTROLLER_PATH, addPrefix(controllerPackageName));
		}
		if (!disableService) {
			packagePathInfo.put(ConstVal.SERVICE_PATH, addPrefix(servicePackageName));
		}
		if (!disableServiceImpl) {
			packagePathInfo.put(ConstVal.SERVICE_IMPL_PATH, addPrefix(serviceImplPackageName));
		}
		if (!disableEntity) {
			packagePathInfo.put(ConstVal.ENTITY_PATH, addPrefix(entityPackageName));
		}
		if (!disableMapper) {
			packagePathInfo.put(ConstVal.MAPPER_PATH, addPrefix(mapperPackageName));
		}
		if (!disableMapperXml) {
			packagePathInfo.put(ConstVal.XML_PATH, mapperXmlPath);
		}
		packageConfig.setParent(parentPackage).setPathInfo(packagePathInfo);

		StrategyConfig strategyConfig = new StrategyConfig();
		if (enableEntityLombok) {
			strategyConfig.setEntityLombokModel(true);
		}
		strategyConfig.setInclude(tables)
				.setRestControllerStyle(true)
				.setControllerMappingHyphenStyle(true)
				.setEntityTableFieldAnnotationEnable(true)
				.setLogicDeleteFieldName("deleted")
				.setNaming(NamingStrategy.underline_to_camel);

		TemplateConfig templateConfig = new TemplateConfig();
		if (disableController) {
			templateConfig.disable(TemplateType.CONTROLLER);
		}
		if (disableService) {
			templateConfig.disable(TemplateType.SERVICE);
		}
		if (disableEntity) {
			templateConfig.disable(TemplateType.ENTITY);
		}
		if (disableMapper) {
			templateConfig.disable(TemplateType.MAPPER);
		}
		if (disableMapperXml) {
			templateConfig.disable(TemplateType.XML);
		}

		AutoGenerator generator = new AutoGenerator();
		generator.setDataSource(dataSourceConfig)
				.setGlobalConfig(globalConfig)
				.setPackageInfo(packageConfig)
				.setStrategy(strategyConfig)
				.setTemplate(templateConfig)
				.execute();
	}

	private String addPrefix(String packageName) {
		String tem = parentPackage.replaceAll("\\.", "\\\\");
		packageName = packageName.replaceAll("\\.", "\\\\");
		return basePath + File.separator + tem + File.separator + packageName;
	}
}
