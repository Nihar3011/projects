/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.google;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 *
 * @author nihar
 */
public interface GoogleTokenVerifier {

    GoogleIdToken verify(String idToken) throws GeneralSecurityException, IOException;

    boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException;

    boolean verify(IdToken idToken);

}
