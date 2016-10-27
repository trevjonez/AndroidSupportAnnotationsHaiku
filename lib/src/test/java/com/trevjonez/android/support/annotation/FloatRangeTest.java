/*
 * Copyright (c) 2016. Trevor Jones
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
public class FloatRangeTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(FloatRange.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.FloatRange");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(FloatRange.SPEC.toString())
        .isEqualTo("@android.support.annotation.FloatRange");
  }

  @Test
  public void builder_from() throws Exception {
    assertThat(FloatRange.builder().from("$LD", 0.1D).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(from = 0.1D)");
  }

  @Test
  public void builder_from_double() throws Exception {
    assertThat(FloatRange.builder().from(0.1D).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(from = 0.1D)");
  }

  @Test
  public void builder_to() throws Exception {
    assertThat(FloatRange.builder().to("$LD", 0.1D).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(to = 0.1D)");
  }

  @Test
  public void builder_to_double() throws Exception {
    assertThat(FloatRange.builder().to(0.1D).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(to = 0.1D)");
  }

  @Test
  public void builder_fromInclusive() throws Exception {
    assertThat(FloatRange.builder().fromInclusive("$L", false).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(fromInclusive = false)");
  }

  @Test
  public void builder_fromInclusive_boolean() throws Exception {
    assertThat(FloatRange.builder().fromInclusive(false).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(fromInclusive = false)");
  }

  @Test
  public void builder_toInclusive() throws Exception {
    assertThat(FloatRange.builder().toInclusive("$L", true).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(toInclusive = true)");
  }

  @Test
  public void builder_toInclusive_boolean() throws Exception {
    assertThat(FloatRange.builder().toInclusive(true).build().toString())
        .isEqualTo("@android.support.annotation.FloatRange(toInclusive = true)");
  }
}