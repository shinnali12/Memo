package com.shinnal.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shinnal.memo.common.FileManager;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:///" + FileManager.FILE_UPLOAD_PATH + "/");
		
		// 웹 애플리케이션에서 서버의 이미지 파일을 URL을 통해 클라이언트에게 제공
		// 서버에 저장된 이미지를 FileManager에 저장된 url 통해서 불러옴
	}

}
