package com.example.demo.chat.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSoketConfig implements WebSocketMessageBrokerConfigurer{
	 @Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/topic");//구독신청(수신)
	    config.setApplicationDestinationPrefixes("/app");//소켓메시지요청(전송)
	  }

	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/chatServer");//소켓서버endpoint
	  }
//static폴더에는 컨트롤러안거치고들어갈수잇음
}
