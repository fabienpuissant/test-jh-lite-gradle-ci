package com.mycompany.myapp;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


@UnitTest
class FailingTest {

  @Test
  void shouldFail() {
    assertThat(true).isFalse();
  }

}
