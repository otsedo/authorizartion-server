package com.odeswiki.authorizationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "`client`")
public class Client {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "client_id_issued_at")
    private Instant clientIdIssuedAt;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "client_secret_expires_at")
    private Instant clientSecretExpiresAt;
    @Column(name = "client_name")
    private String clientName;
    @Column(length = 1000, name = "client_authentication_methods")
    private String clientAuthenticationMethods;
    @Column(length = 1000, name = "authorization_grant_types")
    private String authorizationGrantTypes;
    @Column(length = 1000, name = "redirect_uris")
    private String redirectUris;
    @Column(length = 1000, name = "post_logout_redirect_uris")
    private String postLogoutRedirectUris;
    @Column(length = 1000, name = "scopes")
    private String scopes;
    @Column(length = 2000, name = "client_settings")
    private String clientSettings;
    @Column(length = 2000, name = "token_settings")
    private String tokenSettings;

}