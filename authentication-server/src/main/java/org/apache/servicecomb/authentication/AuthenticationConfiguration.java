/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.authentication;

import org.apache.servicecomb.authentication.util.CommonConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.SignerVerifier;

@Configuration
public class AuthenticationConfiguration {
  @Bean(name = CommonConstants.BEAN_AUTH_PASSWORD_ENCODER)
  public PasswordEncoder authPasswordEncoder() {
    return new Pbkdf2PasswordEncoder();
  }

  @Bean(name = {CommonConstants.BEAN_AUTH_SIGNER, CommonConstants.BEAN_AUTH_SIGNATURE_VERIFIER})
  public SignerVerifier authSignerVerifier() {
    // If using RSA, need to configure authSigner and authSignatureVerifier separately. 
    // If using MacSigner, need to protect the shared key by properly encryption.
    return new MacSigner("Please change this key.");
  }
}
