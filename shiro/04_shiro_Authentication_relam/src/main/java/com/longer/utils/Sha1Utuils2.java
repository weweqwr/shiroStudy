package com.longer.utils;

import org.apache.shiro.crypto.hash.Sha1Hash;

//��md5Ҳ���Խ��ܣ�ֻ���㷨��ͬ��Ҳ��md5�ɣ��ҵ����
public class Sha1Utuils2 {
	public static void main(String[] args) {
			String source="123456";//����
		//1��ʹ��Sha1����һ��
			Sha1Hash hash1=new Sha1Hash(source);
			System.out.println("ʹ��Sha1����һ��"+hash1);
		//2��ʹ��Sha1��������
			Sha1Hash hash2=new Sha1Hash(hash1.toString());
			System.out.println("ʹ��Sha1����һ��"+hash2);
		//3��ʹ��Sha1����һ�β�����
			Sha1Hash hash3=new Sha1Hash(source,"�人��ѧ��");
			System.out.println("ʹ��Sha1����һ�β�����"+hash3);
		//4��ʹ��ʹ��Sha1�������δβ�����
			Sha1Hash hash4=new Sha1Hash(source,"�人��ѧ��",2);
			System.out.println("ʹ��ʹ��Sha1�������δβ�����"+hash4);
			
	}
	
	/**
	 * @param source ����
	 * @param salt	��
	 * @param hashIterations ɢ�д���
	 * @return
	 */
	public static String Sha1(Object source,Object salt,Integer hashIterations ){
		return new Sha1Hash(source, salt, hashIterations).toString();
	}

}
