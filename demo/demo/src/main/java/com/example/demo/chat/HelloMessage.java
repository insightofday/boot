package com.example.demo.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//매개변수없는생성자(롬복)
@AllArgsConstructor
public class HelloMessage {
	String name;
}
