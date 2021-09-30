##### spring-cloud-learn-examples-v2-config-client

​		配置中心调用客户端



pom.xml

```xml
<!-- 配置中心 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```



application.properties

```properties
### config 配置
spring.cloud.config.enabled=true
## 访问的url
spring.cloud.config.uri=http://192.168.10.27:8888/
## 远程加载的文件名 默认为 application
spring.cloud.config.name=application
## 远程加载文件的定位信息  例如 xxx-dev ,prod,test 等
spring.cloud.config.profile=dev
```



调用方式：

```java
@Value("${welcome.message}")
private String message;
```

刷新方式

```java
  public static void main(String[] args) {
        try {
            CloseableHttpClient client= HttpClients.createDefault();
            HttpPost post = new HttpPost("http://192.168.10.27:18086/actuator/refresh");
            CloseableHttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```







##### 服务依赖

###### 		第一步启动：spring-cloud-learn-examples-v2-config

​		

###### 		第二步启动：spring-cloud-learn-examples-v2-config-client

​			服务启动如果正常则调用成功

