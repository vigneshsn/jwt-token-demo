package com.vigneshsn.jwttokendemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;

@Service
public class CertificateService {

    private String password = "Cg1@123#";
    private String alias = "cr-authentication-token";
    private String fileName = "tokenauthentication.keystore";
    private Logger log = LoggerFactory.getLogger(getClass());

    public KeyPair readKeyStore() {
        KeyStore ks = null;
        try {
            ks = KeyStore.getInstance("PKCS12");
        } catch (KeyStoreException e) {
            throw new RuntimeException("error reading certificate");
        }
        try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            ks.load(inputStream, password.toCharArray());
            Key key = ks.getKey(alias, password.toCharArray());
            if(key instanceof PrivateKey) {
                Certificate certificate = ks.getCertificate(alias);
                return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
            }
            throw new RuntimeException("Private key not found");
        } catch (Exception e) {
            e.printStackTrace();
           throw new RuntimeException("error loading keystore file");
        }
    }

}
