package com.example.app.member;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsService {
	//coolsms 내용 전달
//	private static final String API_KEY = "NCSVWFZICQJRC5TU";
//	private static final String API_SECRET = "HETXSGCLAZ0XVI9FWVE6TODE4OWST6B7";
//	private static final String FROM_NUMBER = "번호";
	
	   private static final String API_KEY = "NCSPNNVBVPVPRTVX";
	   private static final String API_SECRET = "LSISNFQLHSZJU90NCZRQ2VA7HBK7ASZN";
	   private static final String FROM_NUMBER = "01075812581";
	
	public String sendVerificationSms(String to) throws CoolsmsException{
		System.out.println("smsService ==========" + to);
		Message coolsms = new Message(API_KEY, API_SECRET);
		String verificationCode = generateVerificationCode();
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", to);
		params.put("from", FROM_NUMBER);
		params.put("type", verificationCode);
		params.put("text", "인증번호는 [" + verificationCode + "] 입니다.");
		
		JSONObject obj = (JSONObject) coolsms.send(params);
		System.out.println("문자발송완료");
		System.out.println(obj.toString());
		return verificationCode;
		
	}
	
	private String generateVerificationCode() {
		Random random = new Random();
		StringBuilder code = new StringBuilder();
		for (int i=0; i<6; i++) {
			code.append(random.nextInt(10));
		}
		return code.toString();
	}
}
