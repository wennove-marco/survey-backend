package com.survey.tool;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptPass  {
    private String pass;
    private String cryptPass;

    public CryptPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getCryptPass() throws NoSuchAlgorithmException {

        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(this.pass.getBytes(),0, this.pass.length());

        return new BigInteger(1, m.digest()).toString(16);
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
