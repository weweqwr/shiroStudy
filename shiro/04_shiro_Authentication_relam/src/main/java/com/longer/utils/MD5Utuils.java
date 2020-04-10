package com.longer.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Utuils {
//	public static void main(String[] args) {
//			String source="123456";//明文
//		//1、使用MD5加密一次
//			Md5Hash hash1=new Md5Hash(source);
//			System.out.println("使用MD5加密一次"+hash1);
//		//2、使用MD5加密两次
//			Md5Hash hash2=new Md5Hash(hash1.toString());
//			System.out.println("使用MD5加密一次"+hash2);
//		//3、使用md5加密一次并加盐
//			Md5Hash hash3=new Md5Hash(source,"武汉尚学堂");
//			System.out.println("使用md5加密一次并加盐"+hash3);
//		//4、使用使用md5加密两次次并加盐
//			Md5Hash hash4=new Md5Hash(source,"武汉尚学堂",2);
//			System.out.println("使用使用md5加密两次次并加盐"+hash4);
//			
//	}
//	
	public static void main(String[] args) {
		System.out.println(md5("123456", "zhaoliu", 1));
	}
	/**
	 * @param source 明文
	 * @param salt	盐
	 * @param hashIterations 散列次数
	 * @return
	 */
	public static String md5(Object source,Object salt,Integer hashIterations ){
		return new Md5Hash(source, salt, hashIterations).toString();
	}

}
