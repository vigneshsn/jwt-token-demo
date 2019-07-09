package com.vigneshsn.jwttokendemo.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

@Service
public class TokenValidatorService {
    public TokenValidatorService(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    private CertificateService certificateService;

    public String getPayload(String token) throws ParseException, JOSEException {
        JWSObject jwsObject = JWSObject.parse(token);
        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) this.certificateService.readKeyStore().getPublic());
        if(!jwsObject.verify(verifier)) {
            new RuntimeException("failed verification");
        }
        return jwsObject.getPayload().toString();
    }
}
