##### spring-cloud-learn-examples-v2-sleuth-zipkin

​		服务日志跟踪管理服务



```xml
<!-- 日志跟踪服务 -->
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
    <version>2.11.7</version>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-server</artifactId>
    <version>2.11.7</version>
</dependency>
```



```properties
## 配置此项解决打开zipkin页面报错问题
management.metrics.web.server.auto-time-requests=false
```









依赖服务

##### 第一步启动：spring-cloud-learn-examples-v2-sleuth-zipkin

​			http://192.168.10.27:18080/zipkin/
