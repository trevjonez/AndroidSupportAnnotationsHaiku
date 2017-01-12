/*
 * Copyright (c) 2017. Trevor Jones
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trevjonez.android.support.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author TrevJonez
 */
@RunWith(JUnit4.class)
public class RestrictToTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(RestrictTo.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.RestrictTo");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(RestrictTo.SPEC.toString())
        .isEqualTo("@android.support.annotation.RestrictTo");
  }

  @Test
  public void value1() throws Exception {
    assertThat(RestrictTo.value(RestrictTo.Scope.LIBRARY).toString())
        .isEqualTo("@android.support.annotation.RestrictTo(android.support.annotation.RestrictTo.Scope.LIBRARY)");
  }

  @Test
  public void value2() throws Exception {
    assertThat(RestrictTo.value(RestrictTo.Scope.LIBRARY,
        RestrictTo.Scope.LIBRARY_GROUP).toString())
        .isEqualTo("@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY," +
            " android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})");
  }

  @Test
  public void value3() throws Exception {
    assertThat(RestrictTo.value(RestrictTo.Scope.LIBRARY,
        RestrictTo.Scope.LIBRARY_GROUP,
        RestrictTo.Scope.TESTS).toString())
        .isEqualTo("@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY," +
            " android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP," +
            " android.support.annotation.RestrictTo.Scope.TESTS})");
  }

  @Test
  public void value4() throws Exception {
    assertThat(RestrictTo.value(RestrictTo.Scope.LIBRARY,
        RestrictTo.Scope.LIBRARY_GROUP,
        RestrictTo.Scope.TESTS,
        RestrictTo.Scope.SUBCLASSES).toString())
        .isEqualTo("@android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY," +
            " android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP," +
            " android.support.annotation.RestrictTo.Scope.TESTS," +
            " android.support.annotation.RestrictTo.Scope.SUBCLASSES})");
  }
}