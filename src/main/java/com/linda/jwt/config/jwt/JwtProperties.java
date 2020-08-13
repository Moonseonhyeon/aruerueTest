package com.linda.jwt.config.jwt;

public interface JwtProperties {
	String SECRET = "펭귄악어"; //우리 서버만 알고 있는 비밀값
	int EXPIRATION_TIME = 21600000; //86400000 //1일 43200000  //12시간  21600000//6시간
	String TOKEN_PREFIX = "Bearer "; //꼭 이렇게 한칸 띄워야 한다.
	String HEADER_STRING= "Authorization";

}
