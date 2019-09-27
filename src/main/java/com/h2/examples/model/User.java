package com.h2.examples.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@JsonPropertyOrder({"id", "lastName", "userName"})
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty
  private int id;
  @JsonProperty
  private String firstName;
  @JsonProperty
  private String lastName;

  @JsonCreator
  public User(int id, String userName, String lastName) {
    this.id = id;
    this.firstName = userName;
    this.lastName = lastName;
  }

}
