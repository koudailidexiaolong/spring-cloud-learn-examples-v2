#### spring-cloud-learn-examples-v2-actuator
服务监控服务

spring boot 2.0以上 做了调整
默认只开启 info 、health 两个接口
##### 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator

application.properties

```properties
spring.application.name=spring-cloud-learn-examples-v2-test
## 服务端口
server.port=18080


#management.server.port=19090
## 2.0 默认只启用了 info, health 两个端口 如果需要启用全部 需要配置如下 访问方式也做了改变 /actuator
management.endpoints.web.exposure.include=*
## 过滤 http web访问路径 配置后 网页端不显示
management.endpoints.web.exposure.exclude=env


## 是否启用热启动配置
spring.devtools.restart.enabled=true

## 日志
logging.config=classpath:log4j2-spring.xml
#logging.level.root=INFO
#logging.level.org.springframework.web=DEBUG
#logging.level.org.hibernate=ERROR
## 服务信息
info.app.encoding=@project.build.sourceEncoding@
info.app.java.source=@java.version@
info.app.java.target=@java.version@
info.app.artifactId=@artifactId@
info.app.groupId=@groupId@
info.app.version=@version@
info.app.description=@description@
info.app.packaging=@packaging@
info.app.parent.groupId=@parent.groupId@
info.app.parent.artifactId=@parent.artifactId@
info.app.parent.version=@parent.version@
info.app.applicaton.name=${spring.application.name}

```



默认方法：

| 方法名                                 | 请求方式 | 描述                 |
| -------------------------------------- | -------- | -------------------- |
| /actuator                              | GET      | 监控主要方法         |
| /actuator/mappings                     | GET      | 映射路径信息         |
| /actuator/httptrace                    | GET      |                      |
| /actuator/scheduledtasks               | GET      |                      |
| /actuator/metrics                      | GET      | 系统指标             |
| /actuator/metrics/{requiredMetricName} | GET      |                      |
| /actuator/threaddump                   | GET      |                      |
| /actuator/loggers/{name}               | GET      |                      |
| /actuator/loggers/{name}               | POST     |                      |
| /actuator/loggers                      | GET      |                      |
| /actuator/info                         | GET      | 自定义系统信息       |
| /actuator/configprops                  | GET      | 配置的属性信息       |
| /actuator/conditions                   | GET      |                      |
| /actuator/health                       | GET      | 心跳检测健康指标     |
| /actuator/beans                        | GET      | 应用上下文创建的bean |
| /actuator/auditevents                  | GET      |                      |



访问开放的url:

```json
{
  "_links": {
    "self": {
      "href": "http://192.168.10.27:18080/actuator",
      "templated": false
    },
    "auditevents": {
      "href": "http://192.168.10.27:18080/actuator/auditevents",
      "templated": false
    },
    "beans": {
      "href": "http://192.168.10.27:18080/actuator/beans",
      "templated": false
    },
    "health": {
      "href": "http://192.168.10.27:18080/actuator/health",
      "templated": false
    },
    "conditions": {
      "href": "http://192.168.10.27:18080/actuator/conditions",
      "templated": false
    },
    "configprops": {
      "href": "http://192.168.10.27:18080/actuator/configprops",
      "templated": false
    },
    "info": {
      "href": "http://192.168.10.27:18080/actuator/info",
      "templated": false
    },
    "loggers": {
      "href": "http://192.168.10.27:18080/actuator/loggers",
      "templated": false
    },
    "loggers-name": {
      "href": "http://192.168.10.27:18080/actuator/loggers/{name}",
      "templated": true
    },
    "heapdump": {
      "href": "http://192.168.10.27:18080/actuator/heapdump",
      "templated": false
    },
    "threaddump": {
      "href": "http://192.168.10.27:18080/actuator/threaddump",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://192.168.10.27:18080/actuator/metrics/{requiredMetricName}",
      "templated": true
    },
    "metrics": {
      "href": "http://192.168.10.27:18080/actuator/metrics",
      "templated": false
    },
    "scheduledtasks": {
      "href": "http://192.168.10.27:18080/actuator/scheduledtasks",
      "templated": false
    },
    "httptrace": {
      "href": "http://192.168.10.27:18080/actuator/httptrace",
      "templated": false
    },
    "mappings": {
      "href": "http://192.168.10.27:18080/actuator/mappings",
      "templated": false
    }
  }
}
```

