package com.shinnal.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingEncoder {
	
	// MD5 를 통한 암호화
	
	public static String encode(String message) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes(); // 문자열을 byte 배열로
			
			messageDigest.update(bytes); // byte 배열을 암호화 수행
			
			byte[] digest = messageDigest.digest(); // 암호화가 완료된 byte 배열 
			
			
			// 16진수 문자열로 만들기
			String result = "";
			for(int i = 0; i < digest.length; i++) {
				
				result += Integer.toHexString(digest[i] & 0xff); // byte 연산 - 둘중에 하나가 0이면 값이 0으로 나옴
			}
			
			return result;
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			
			return null;
		}
		
	}

}
