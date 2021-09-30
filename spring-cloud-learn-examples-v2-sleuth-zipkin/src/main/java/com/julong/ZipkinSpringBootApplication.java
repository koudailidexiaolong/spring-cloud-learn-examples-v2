package com.julong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;


/**
 * 日志跟踪服务web管理启动类
 * @author julong
 * @date 2021年9月26日 上午1:11:54
 * @desc 配置log4j2 日志跟踪生效需要在日志中增加配置信息  [%X{X-B3-ParentSpanId},%X{X-B3-TraceId},%X{X-B3-SpanId},%X{X-Span-Export}] 
 * 详情请看：{@link org.springframework.cloud.sleuth.log.Slf4jCurrentTraceContext} 中的静态属性
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinSpringBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("spring.devtools.restart.enabled", "false");//禁用热启动	
		SpringApplication.run(ZipkinSpringBootApplication.class, args);
	}

}
