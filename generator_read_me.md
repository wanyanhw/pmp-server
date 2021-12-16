# Mybatis-plus-generator 使用手册
### pom.xml 依赖包
    
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-generator</artifactId>
        <version>3.4.1</version>
    </dependency>
    
### 项目结构
> 新旧版本存在不兼容的问题，按需求挑选相应版本的生成器，暂时将不需要的生成器注释掉
###### 基础生成器抽象类
> `com.zk.commons.mapper.generator.plus.AbstractMainGenerator`
>    
    /**
     * 代码执行器，实现方法在子类中
     */
    public abstract void execute();
###### 新版本生成器 version-3.5.1 及之后
> `com.zk.commons.mapper.generator.plus.executor.GeneratorExecutorLatest`

    继承 com.zk.commons.mapper.generator.plus.AbstractMainGenerator 抽象类，实现 execute() 方法，以版本 3.5.1 及之后的方式，实现生成代码逻辑
###### 旧版本生成器 version-3.5.1 之前版本
> `com.zk.commons.mapper.generator.plus.executor.GeneratorExecutorOriginal`

    继承 com.zk.commons.mapper.generator.plus.AbstractMainGenerator 抽象类，实现 execute() 方法，以版本 3.5.1 之前的方式，实现生成代码逻辑

### 操作流程
> 以下操作流程以 mybatis-plus-generator 版本小于 3.5.1 为例，3.5.1及以上版本操作方式相同
    
    1、new 方式创建响应生成器对象，new GeneratorExecutorOriginal()
    2、调用 dataSource() 方法，创建数据源连接
    3、调用 includeTable() 方法，添加要生成的数据表名称
    4、调用 basePath() 方法，设置文件生成位置，此处应设置为绝对路径
    5、调用 parentPackagePath() 方法，设置文件生成的父级包名；生成的代码文件都在此父级包下
    6、调用 mapperXmlPath() 方法，设置 Mapper.xml 文件所在的目录，此处应设置为绝对路径
    4、调用 execute() 方法，执行生成代码逻辑
> 经过以上操作步骤，会生成 controller、 service、service.impl、entity、mapper 包及相应文件；若需禁用生成 controller 或其他相应包，
> 可通过调用 disable*() 系列方法，具体方法功能参考代码注释

### 快速使用
    public static void main(String[] args) {
        AbstractMainGenerator generator = new GeneratorExecutorOriginal();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pmp?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&allowMultiQueries=true";
        String username = "root";
        String password = "Zkong_1234";
        generator.dataSource(driver, url, username, password)
                .includeTable("person_info")
                .openDir(false)
                .fileOverride(true)
                .enableEntityLombok(true)
                .basePath("E:\\space\\idea\\lcd\\entry\\src\\main\\java\\")
                .parentPackagePath("com.zk")
                .mapperXmlPath("E:\\space\\idea\\lcd\\entry\\src\\main\\resources\\com\\zk\\mapper")
                .execute();
    }