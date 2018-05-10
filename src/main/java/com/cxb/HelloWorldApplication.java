package com.cxb;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
 * @author 81046
 *				SpringBoot的启动类
 */
//如果不需要这个配置 则加上即可    (exclude=MybatisAutoConfiguration.class)
@SpringBootApplication
//扫描该包下的接口  (这句话真的忘了 坑了我好久)   mybatis就是需要扫描mapper的！！！
@MapperScan("com.cxb.dao")
public class HelloWorldApplication extends WebMvcConfigurationSupport{
	/**
	 * 这里是为了使用阿里的fastjson   方式二
	 * 
	 */
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastConfig=new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastConfig);
		converters.add(fastConverter);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
	
	/**
	 * 这里是为了使用阿里的fastjson   方式一
	 * @return
	 */
	/*@Bean
	public HttpMessageConverters fastJsonConverters() {
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastConfig=new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastConfig);
		HttpMessageConverter<?> converter=fastConverter;
		return new HttpMessageConverters(converter);
	}*/
	
}
