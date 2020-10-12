# springboot Demo
1.springboot整合通用mapper插件、XML以及注解方式，实现查询分页等

2.自定义日志输出

3.多配置环境切换，maven打包动态指定配置环境

4.接口(无论异常)统一格式输出

 ## 搭建步骤
 1. 执行document/db下的sql脚本，建立数据库(支持mysql5.7以上)
 2. 执行test目录下的测试单元
 
 ## 根据不同环境进行打包
例如 测试环境：
mvn clean package -Ptest -Dmaven.test.skip=true
