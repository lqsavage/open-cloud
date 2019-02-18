package com.github.lyd.msg.producer.configuration;

import com.github.lyd.msg.client.model.sms.SmsSender;
import com.github.lyd.msg.producer.service.AliyunSmsSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author woodev
 */
@Configuration
@EnableConfigurationProperties({AliyunSmsProperties.class})
@Slf4j
public class SmsAutoConfiguration {

	@Bean
	@ConditionalOnClass({ AliyunSmsSender.class })
	public SmsSender smsSender(AliyunSmsProperties aliyunSmsProperties) {
        AliyunSmsSender sender = new AliyunSmsSender();
		BeanUtils.copyProperties(aliyunSmsProperties, sender);
		return sender;
	}

}