package com.vigneshsn.jwttokendemo.controller;

import com.nimbusds.jose.JOSEException;
import com.vigneshsn.jwttokendemo.service.JWSTokenProvider;
import com.vigneshsn.jwttokendemo.service.TokenValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class TokenController {

    private JWSTokenProvider tokenProvider;
    Logger log = LoggerFactory.getLogger(getClass());

    public TokenController(JWSTokenProvider tokenProvider, TokenValidatorService tokenValidatorService) {
        this.tokenProvider = tokenProvider;
        this.tokenValidatorService = tokenValidatorService;
    }

    private TokenValidatorService tokenValidatorService;

    @RequestMapping(path="/token", method = RequestMethod.POST)
    public String getToken(@RequestBody  String payload) {
        log.info("payload {}", payload);
        return this.tokenProvider.createToken(payload);
    }

    @RequestMapping(path="/validate-token", method = RequestMethod.POST)
    public String getPayloadFromToken(@RequestBody  String token) throws ParseException, JOSEException {
        return this.tokenValidatorService.getPayload(token);
    }
}
