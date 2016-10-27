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
public class SizeTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(Size.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.Size");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(Size.SPEC.toString())
        .isEqualTo("@android.support.annotation.Size");
  }

  @Test
  public void builder_value() throws Exception {
    assertThat(Size.builder().value("$L", 36).build().toString())
        .isEqualTo("@android.support.annotation.Size(36)");
  }

  @Test
  public void builder_value_long() throws Exception {
    assertThat(Size.builder().value(36).build().toString())
        .isEqualTo("@android.support.annotation.Size(36)");
  }

  @Test
  public void builder_min() throws Exception {
    assertThat(Size.builder().min("$L", 36).build().toString())
        .isEqualTo("@android.support.annotation.Size(min = 36)");
  }

  @Test
  public void builder_min_long() throws Exception {
    assertThat(Size.builder().min(36).build().toString())
        .isEqualTo("@android.support.annotation.Size(min = 36)");
  }

  @Test
  public void builder_max() throws Exception {
    assertThat(Size.builder().max("$L", 36).build().toString())
        .isEqualTo("@android.support.annotation.Size(max = 36)");
  }

  @Test
  public void builder_max_long() throws Exception {
    assertThat(Size.builder().max(36).build().toString())
        .isEqualTo("@android.support.annotation.Size(max = 36)");
  }

  @Test
  public void builder_multiple() throws Exception {
    assertThat(Size.builder().multiple("$L", 2).build().toString())
        .isEqualTo("@android.support.annotation.Size(multiple = 2)");
  }

  @Test
  public void builder_multiple_long() throws Exception {
    assertThat(Size.builder().multiple(2).build().toString())
        .isEqualTo("@android.support.annotation.Size(multiple = 2)");
  }
}