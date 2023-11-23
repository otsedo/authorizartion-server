package com.odeswiki.authorizationapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class AuthorizationConsentId implements Serializable {
    private String registeredClientId;
    private String principalName;
}
