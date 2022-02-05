package com.praveen.jasypt.example;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JasyptDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testPasswordEncryption() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword("mysecretkey"); // encryptor's private key
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		String plainText = "Password";
		String encryptedPassword = encryptor.encrypt(plainText);
		System.out.println("encryptedPassword : " + encryptedPassword);
		Assertions.assertEquals(plainText, encryptor.decrypt(encryptedPassword));
	}
}
