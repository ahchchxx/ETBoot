package com.etboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.Base64;

public class test {
    public static void main(String[] args) {
        // Pbkdf2PasswordEncoder pwdEncoder = new Pbkdf2PasswordEncoder("", 25000, 512); // new Pbkdf2PasswordEncoder();
        // pwdEncoder.setAlgorithm(Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512);
        //
        // String pwd = pwdEncoder.encode("123456.");
        // byte[] encode = Base64.getEncoder().encode(pwd.getBytes());
        //
        // System.out.println(new String(encode));
    }
}
