package com.wyhw.pmp.generator;

import com.baomidou.mybatisplus.generator.config.TemplateType;

/**
 *
 * @author wanyanhw
 * @since 2021/12/14 19:41
 */
public abstract class AbstractMainGenerator {

	// 作者
	protected String author = "zk";

	// 日期格式
	protected String dateFormat = "yyyy-MM-dd";

	// 生成文件后，默认打开文件位置
	protected boolean openDir = true;

	// 生成文件后，默认打开文件位置（默认false）
	protected boolean fileOverride;

	// Entity 文件是否使用 Lombok 插件（默认false）
	protected boolean enableEntityLombok;

	// 输出路径
	protected String basePath = "E:\\space\\idea\\generator\\src\\main\\java";

	// Mapper.xml输出路径
	protected String mapperXmlPath = "E:\\space\\idea\\generator\\src\\main\\resources\\mapper";

	protected String parentPackage = "com.example.generator";
	protected String controllerPackageName = "controller";
	protected String servicePackageName = "service";
	protected String serviceImplPackageName = "service.impl";
	protected String entityPackageName = "entity";
	protected String mapperPackageName = "mapper";

	protected String controllerSuffix = "Controller";
	protected String serviceSuffix = "Service";
	protected String serviceImplSuffix = "ServiceImpl";
	protected String entitySuffix = "";
	protected String mapperSuffix = "Mapper";

	protected boolean disableController;
	protected boolean disableService;
	protected boolean disableServiceImpl;
	protected boolean disableEntity;
	protected boolean disableMapper;
	protected boolean disableMapperXml;

	// 数据源
	protected String datasourceUrl = "jdbc:mysql://localhost:3306/pmp?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
	protected String driver = "com.mysql.cj.jdbc.Driver";
	protected String username = "root";
	protected String password = "Zkong_1234";

	// 数据库表名称集合（不允许为NULL）
	protected String[] tables;

	/**
	 * 设置数据源
	 * @param driver 数据库驱动
	 * @param url 数据源连接
	 * @param username 用户名
	 * @param password 密码
	 * @return this
	 */
	public AbstractMainGenerator dataSource(String driver, String url, String username, String password) {
		this.driver = driver;
		this.datasourceUrl = url;
		this.username = username;
		this.password = password;
		return this;
	}

	/**
	 * 设置作者
	 * @param author 作者
	 * @return this
	 */
	public AbstractMainGenerator author(String author) {
		this.author = author;
		return this;
	}

	/**
	 * 注释日期格式
	 * @param dateFormat 目标日期格式
	 * @return this
	 */
	public AbstractMainGenerator dateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		return this;
	}

	/**
	 * 设置代码执行完成后是否打开文件位置
	 * @param openDir 标识，true-是，false-否
	 * @return this
	 */
	public AbstractMainGenerator openDir(boolean openDir) {
		this.openDir = openDir;
		return this;
	}

	/**
	 * 设置执行代码时，是否覆盖上次生成的文件
	 * @param fileOverride 标识，true-是，false-否
	 * @return this
	 */
	public AbstractMainGenerator fileOverride(boolean fileOverride) {
		this.fileOverride = fileOverride;
		return this;
	}

	/**
	 * 设置 Entity 是否启用 lombok 插件
	 * @param enable 标识，true-是，false-否
	 * @return this
	 */
	public AbstractMainGenerator enableEntityLombok(boolean enable) {
		this.enableEntityLombok = enable;
		return this;
	}

	/**
	 * 设置表名称
	 * @param tableNames 表名称数组
	 * @return this
	 */
	public AbstractMainGenerator includeTable(String... tableNames) {
		this.tables = tableNames;
		return this;
	}

	/**
	 * 设置文件生成所在目录（绝对路径），例如："E:\\space\\idea\\generator\\src\\main\\java"
	 * @param baseOutDir 路径地址
	 * @return this
	 */
	public AbstractMainGenerator basePath(String baseOutDir) {
		this.basePath = baseOutDir;
		return this;
	}

	/**
	 * 设置代码文件包的父级包名，例如："com.example.generator"
	 * @param parentPackage 父包名称
	 * @return this
	 */
	public AbstractMainGenerator parentPackagePath(String parentPackage) {
		this.parentPackage = parentPackage;
		return this;
	}

	/**
	 * 设置 Controller 层包名称
	 * @param name 名称
	 * @return this
	 */
	public AbstractMainGenerator controllerPackageName(String name) {
		this.controllerPackageName = name;
		return this;
	}

	/**
	 * 设置 Entity 层包名称
	 * @param name 名称
	 * @return this
	 */
	public AbstractMainGenerator entityPackageName(String name) {
		this.entityPackageName = name;
		return this;
	}

	/**
	 * 设置 Mapper 层包名称
	 * @param name 名称
	 * @return this
	 */
	public AbstractMainGenerator mapperPackageName(String name) {
		this.mapperPackageName = name;
		return this;
	}

	/**
	 * 设置 Mapper Xml 文件路径（绝对路径），例如："E:\\space\\idea\\generator\\src\\main\\resources\\mapper"
	 * @param path 路径
	 * @return this
	 */
	public AbstractMainGenerator mapperXmlPath(String path) {
		this.mapperXmlPath = path;
		return this;
	}

	/**
	 * 设置 Service 层包名称
	 * @param name 名称
	 * @return this
	 */
	public AbstractMainGenerator servicePackageName(String name) {
		this.servicePackageName = name;
		return this;
	}

	/**
	 * 设置 ServiceImpl 层包名称
	 * @param name 名称
	 * @return this
	 */
	public AbstractMainGenerator serviceImplPackageName(String name) {
		this.serviceImplPackageName = name;
		return this;
	}

	/**
	 * 设置禁用生成相应包
	 * @param templateTypes 包枚举数组
	 * @return this
	 */
	public AbstractMainGenerator disablePackage(TemplateType... templateTypes) {
		for (TemplateType templateType : templateTypes) {
			switch (templateType) {
				case CONTROLLER:
					this.disableController();
					break;
				case SERVICE:
					this.disableService();
					break;
				// mybatis-plus-generator 3.5.1 及之后版本才会有 SERVICEIMPL，低于此版本的生成器，需注释掉此 case
//				case SERVICEIMPL:
//					this.disableServiceImpl();
//					break;
				case ENTITY:
					this.disableEntity();
					break;
				case MAPPER:
					this.disableMapper();
					break;
				case XML:
					this.disableMapperXml();
					break;
				default:
					break;
			}
		}
		return this;
	}

	/**
	 * 设置禁止生成 Controller 层
	 * @return this
	 */
	public AbstractMainGenerator disableController() {
		this.disableController = true;
		return this;
	}

	/**
	 * 设置禁止生成 Service 层
	 * @return this
	 */
	public AbstractMainGenerator disableService() {
		this.disableService = true;
		this.disableServiceImpl = true;
		return this;
	}

	/**
	 * 设置禁止生成 ServiceImpl 层
	 * @return this
	 */
	public AbstractMainGenerator disableServiceImpl() {
		this.disableServiceImpl = true;
		return this;
	}

	/**
	 * 设置禁止生成 Entity 层
	 * @return this
	 */
	public AbstractMainGenerator disableEntity() {
		this.disableEntity = true;
		return this;
	}

	/**
	 * 设置禁止生成 Mapper 层
	 * @return this
	 */
	public AbstractMainGenerator disableMapper() {
		this.disableMapper = true;
		return this;
	}

	/**
	 * 设置禁止生成 Mapper xml 层
	 * @return this
	 */
	public AbstractMainGenerator disableMapperXml() {
		this.disableMapperXml = true;
		return this;
	}

	/**
	 * 代码执行器，实现方法在子类中
	 */
	public abstract void execute();
}
