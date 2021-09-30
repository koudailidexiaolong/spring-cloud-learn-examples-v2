#### spring-cloud-learn-examples-v2-sleuth

​	日志追踪服务

配置信息

```xml
<!-- 日志跟踪服务 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```



监听方法

```java
@RequestMapping(value = "/user/{id}")
public ResponseEntity<Object> getUser(@PathVariable("id") String id) {
    logger.info("【用户模块】-查询单个用户信息 id:{}",id);
    logger.warn("【用户模块】-查询单个用户信息 id:{}",id);
    logger.error("【用户模块】-查询单个用户信息 id:{}",id);
    logger.debug("【用户模块】-查询单个用户信息 id:{}",id);
    logger.trace("【用户模块】-查询单个用户信息 id:{}",id);
    return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
}
```



日志启动结果

```text
2021-09-30 11:11:34.298  WARN [spring-cloud-learn-examples-v2-sleuth,1ddeb79a05159fbb,1ddeb79a05159fbb,true] 5692 --- [io-18083-exec-1] com.julong.action.UserAction             : 【用户模块】-查询单个用户信息 id:1
2021-09-30 11:11:34.298 ERROR [spring-cloud-learn-examples-v2-sleuth,1ddeb79a05159fbb,1ddeb79a05159fbb,true] 5692 --- [io-18083-exec-1] com.julong.action.UserAction             : 【用户模块】-查询单个用户信息 id:1
2021-09-30 11:11:36.138  INFO [spring-cloud-learn-examples-v2-sleuth,6c43cbdbeb4bcc59,6c43cbdbeb4bcc59,true] 5692 --- [io-18083-exec-3] com.julong.action.UserAction             : 【用户模块】-查询单个用户信息 id:1
2021-09-30 11:11:36.138  WARN [spring-cloud-learn-examples-v2-sleuth,6c43cbdbeb4bcc59,6c43cbdbeb4bcc59,true] 5692 --- [io-18083-exec-3] com.julong.action.UserAction             : 【用户模块】-查询单个用户信息 id:1
2021-09-30 11:11:36.138 ERROR [spring-cloud-learn-examples-v2-sleuth,6c43cbdbeb4bcc59,6c43cbdbeb4bcc59,true] 5692 --- [io-18083-exec-3] com.julong.action.UserAction             : 【用户模块】-查询单个用户信息 id:1

```

