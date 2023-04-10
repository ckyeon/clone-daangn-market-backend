package com.thegreat.clonedaangnmarket.security;

import java.util.LinkedHashMap;
import java.util.Map;

public class KakaoOAUth2UserInfo implements CustomOAuth2UserInfo {

  private final Map<String, Object> attributes;

  public KakaoOAUth2UserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getProviderId() {
    return attributes.get("id").toString();
  }

  @Override
  public String getEmail() {
    LinkedHashMap<String, Object> kakaoAccount = (LinkedHashMap) attributes.get("kakao_account");
    return kakaoAccount.get("email").toString();
  }
}
