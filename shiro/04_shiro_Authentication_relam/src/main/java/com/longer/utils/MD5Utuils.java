package com.longer.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Utuils {
//	public static void main(String[] args) {
//			String source="123456";//����
//		//1��ʹ��MD5����һ��
//			Md5Hash hash1=new Md5Hash(source);
//			System.out.println("ʹ��MD5����һ��"+hash1);
//		//2��ʹ��MD5��������
//			Md5Hash hash2=new Md5Hash(hash1.toString());
//			System.out.println("ʹ��MD5����һ��"+hash2);
//		//3��ʹ��md5����һ�β�����
//			Md5Hash hash3=new Md5Hash(source,"�人��ѧ��");
//			System.out.println("ʹ��md5����һ�β�����"+hash3);
//		//4��ʹ��ʹ��md5�������δβ�����
//			Md5Hash hash4=new Md5Hash(source,"�人��ѧ��",2);
//			System.out.println("ʹ��ʹ��md5�������δβ�����"+hash4);
//			
//	}
//	
	public static void main(String[] args) {
		System.out.println(md5("123456", "zhaoliu", 1));
	}
	/**
	 * @param source ����
	 * @param salt	��
	 * @param hashIterations ɢ�д���
	 * @return
	 */
	public static String md5(Object source,Object salt,Integer hashIterations ){
		return new Md5Hash(source, salt, hashIterations).toString();
	}

}
