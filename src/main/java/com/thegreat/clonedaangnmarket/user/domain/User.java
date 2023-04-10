package com.thegreat.clonedaangnmarket.user.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20, unique = true)
  private String providerId;

  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private OAuth2Provider provider;

  @Column(length = 40)
  private String email;

  @Column(length = 15)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(length = 15)
  private Role role;

  protected User() {

  }

  public User(String providerId, OAuth2Provider provider, String email) {
    this(providerId, provider, email, "당근", Role.ROLE_USER);
  }

  private User(String providerId, OAuth2Provider provider, String email, String name, Role role) {
    Preconditions.checkArgument(providerId != null, "providerId must be provided.");
    Preconditions.checkArgument(provider != null, "provider must be provided.");
    Preconditions.checkArgument(email != null, "email must be provided.");
    Preconditions.checkArgument(name != null, "name must be provided.");
    Preconditions.checkArgument(role != null, "role must be provided.");

    this.providerId = providerId;
    this.provider = provider;
    this.email = email;
    this.name = name;
    this.role = role;
  }
}
