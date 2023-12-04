package com.example.questionnaire.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;


@EnableAutoConfiguration //Spring framework 中用來驅動緩存的註解
						//容器至少要有一個CacheManager的Bean
@Configuration //配置成設定檔,交由Spring Boot託管
public class CaffeineCaheConfig {
	
	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager  cacheManager  = new CaffeineCacheManager();
		cacheManager.setCaffeine(Caffeine.newBuilder()
				//設定過期時間   1.最後一次寫入或   2.訪問後固定時間
				.expireAfterAccess(600,TimeUnit.SECONDS)
				//初始緩存空間大小
				.initialCapacity(100)
				//緩存的最大筆數
				.maximumSize(500)
				
				
				);
		
		
		return cacheManager;
	}
	
	
}
