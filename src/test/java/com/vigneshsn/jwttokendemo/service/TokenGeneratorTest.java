package com.vigneshsn.jwttokendemo.service;

import com.nimbusds.jose.JOSEException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;
import java.security.KeyStoreException;
import java.text.ParseException;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class TokenGeneratorTest {

    Logger log = LoggerFactory.getLogger(getClass());

//    @Test
//    public void testTokenGenerator() throws KeyStoreException, JOSEException, ParseException {
//        CertificateService cs = new CertificateService();
//        JWSTokenProvider jwsTokenProvider = new JWSTokenProvider();
//        KeyPair keyPair = cs.readKeyStore("tokenauthentication.keystore");
//        String token = jwsTokenProvider.createToken(keyPair);
//        assertNotNull(token);
//        String payload = jwsTokenProvider.getPayload(token, keyPair);
//        System.out.println(payload);
//        assertNotNull(payload);
//    }


//    @Test
//    public void testAutoclosable() throws IOException {
//        class CustomReader extends InputStreamReader{
//
//            public CustomReader(InputStream in) {
//                super(in);
//            }
//
//            @Override
//            public void close() {
//                log.info("closed called custom reader");
//            }
//        }
//
//        try(InputStream is = new InputStream() {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//
//            @Override
//            public void close() throws IOException {
//                log.info("closed called");
//                super.close();
//            }
//        }; Reader fileReader = new CustomReader(is)) {
//            Assert.assertNotNull(is);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
