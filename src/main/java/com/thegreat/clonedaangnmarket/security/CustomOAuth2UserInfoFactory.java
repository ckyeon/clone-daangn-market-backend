package com.thegreat.clonedaangnmarket.security;

import com.thegreat.clonedaangnmarket.user.domain.OAuth2Provider;
import java.util.Map;

public class CustomOAuth2UserInfoFactory {

  public static CustomOAuth2UserInfo create(OAuth2Provider oAuth2Provider,
    Map<String, Object> attributes) {
    return switch (oAuth2Provider) {
      case KAKAO -> new KakaoOAUth2UserInfo(attributes);
    };
  }
}
