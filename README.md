# encryption
将依赖包代码加密，引用依赖后自动解密注入IOC

一个鸡肋的需求、但非让做出来

### 开发时
填写配置

编写需要加密的代码

在ImplEnableAutoConfiguration类中对需要加密的服务解密并注入ioc(实现自动，不写也行，在引用时调ClazzLoader)

### 打包时
首先执行 clean

保证pom.xml文件    <build> 下 <resources> 节点未被注释
  
保证resources/META-INF/spring.factories中的内容未被注释

保证ImplEnableAutoConfiguration类为被注释

### 加密时
再次执行 clean （重点、之前出现。。。算了不说了心累）

注释掉之前说的几个位置

运行SignApplicationTests里的加密方法

### 引入依赖包
引入依赖

填写配置

调用方法（ide无法反编译，看不见代码的，至少debug看不见运行过程）
