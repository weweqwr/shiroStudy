package com.longer.utils;

import org.apache.shiro.crypto.hash.Sha1Hash;

//用md5也可以解密，只是算法不同，也是md5吧，我的理解
public class Sha1Utuils2 {
	public static void main(String[] args) {
			String source="123456";//明文
		//1、使用Sha1加密一次
			Sha1Hash hash1=new Sha1Hash(source);
			System.out.println("使用Sha1加密一次"+hash1);
		//2、使用Sha1加密两次
			Sha1Hash hash2=new Sha1Hash(hash1.toString());
			System.out.println("使用Sha1加密一次"+hash2);
		//3、使用Sha1加密一次并加盐
			Sha1Hash hash3=new Sha1Hash(source,"武汉尚学堂");
			System.out.println("使用Sha1加密一次并加盐"+hash3);
		//4、使用使用Sha1加密两次次并加盐
			Sha1Hash hash4=new Sha1Hash(source,"武汉尚学堂",2);
			System.out.println("使用使用Sha1加密两次次并加盐"+hash4);
			
	}
	
	/**
	 * @param source 明文
	 * @param salt	盐
	 * @param hashIterations 散列次数
	 * @return
	 */
	public static String Sha1(Object source,Object salt,Integer hashIterations ){
		return new Sha1Hash(source, salt, hashIterations).toString();
	}

}
