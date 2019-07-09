package com.vigneshsn.jwttokendemo.service;


import com.nimbusds.jose.*;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JWSTokenProvider {
    Logger log = LoggerFactory.getLogger(getClass());

    public JWSTokenProvider(TokenSigner tokenSigner) {
        this.tokenSigner = tokenSigner;
    }

    private TokenSigner tokenSigner;

//    public String createTokenHMAC() throws JOSEException {
//        SecureRandom random = new SecureRandom();
//        byte[] sharedSecret = new byte[32];
//        random.nextBytes(sharedSecret);
//        log.info(new String(sharedSecret));
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("username", "vignesh" );
//        JWSSigner jwsSigner = new MACSigner(sharedSecret);
//        JWSObject jwsObject = new JWSObject(
//                new JWSHeader(JWSAlgorithm.HS256),
//                new Payload(jsonObject)
//        );
//
//        jwsObject.sign(jwsSigner);
//        String token = jwsObject.serialize();
//        log.info("token {}", token);
//        return token;
//    }

    public String createToken(String payload) {
    log.info("create token {}", payload);

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("username", "vignesh" );
        JWSObject jwsObject = new JWSObject(
                new JWSHeader(JWSAlgorithm.RS256),
                new Payload(payload)
        );
        try {
            jwsObject.sign(tokenSigner.getTokenSigner());
        } catch (JOSEException e) {
            new RuntimeException("error while creating token");
        }
        String token = jwsObject.serialize();
        log.info("token {}", token);
        return token;
    }
}
