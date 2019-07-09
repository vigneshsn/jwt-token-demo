package com.vigneshsn.jwttokendemo.service;

import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import org.springframework.stereotype.Service;

import java.security.KeyPair;

@Service
public class TokenSigner {

    private CertificateService certificateService;

    public TokenSigner(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    public JWSSigner getTokenSigner() {
        KeyPair keypair = this.certificateService.readKeyStore();
        return new RSASSASigner(keypair.getPrivate());
    }
}
