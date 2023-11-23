package com.odeswiki.authorizationapi.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.odeswiki.authorizationapi.utils.LoadRsaKeysUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JWKSourceConfig {

    private final LoadRsaKeysUtil loadRsaKeysUtil;
    @Value("${rsa.public.key.path}")
    private String rsaPublicKeyPath;
    @Value("${rsa.private.key.path}")
    private String rsaPrivateKeyPath;

    @Bean
    public JWKSource<SecurityContext> jwkSource() throws IOException {
        RSAKey rsaKey = loadRsaKeysUtil.cargarLlavesRsa(rsaPublicKeyPath, rsaPrivateKeyPath);
        JWKSet jwkSet = new JWKSet(rsaKey);
        return new ImmutableJWKSet<>(jwkSet);
    }
}