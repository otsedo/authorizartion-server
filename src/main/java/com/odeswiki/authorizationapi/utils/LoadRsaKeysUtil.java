package com.odeswiki.authorizationapi.utils;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.UUID;

@Slf4j
@Configuration
public class LoadRsaKeysUtil {

    public RSAKey cargarLlavesRsa(String rsaPublicKeyPath, String rsaprivateKeyPath) throws IOException {
        try {
            File publicKeyFile = new File(rsaPublicKeyPath);
            File privateKeyFile = new File(rsaprivateKeyPath);

            String publicKey = Files.readString(publicKeyFile.toPath(), Charset.defaultCharset());
            String privateKey = Files.readString(privateKeyFile.toPath(), Charset.defaultCharset());

            RSAKey pubRsaJWK = (RSAKey) RSAKey.parseFromPEMEncodedObjects(publicKey);
            RSAKey privRsaJWK = RSAKey.parseFromPEMEncodedObjects(privateKey).toRSAKey();

            return new RSAKey.Builder(pubRsaJWK).privateKey(privRsaJWK.toRSAPrivateKey()).keyID(UUID.randomUUID().toString()).build();
        } catch (IOException e) {
            log.error(e.toString());
            throw e;
        } catch (JOSEException e) {
            log.error(e.toString());
            throw new RuntimeException(e);
        }
    }
}