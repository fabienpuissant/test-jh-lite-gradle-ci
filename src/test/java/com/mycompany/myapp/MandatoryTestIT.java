package com.mycompany.myapp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
public class MandatoryTestIT {

  //Build fail when no **IT or **CucumberTest

  @Test
  void should_be_there() {
    assertThat(true).isTrue();
  }

}
