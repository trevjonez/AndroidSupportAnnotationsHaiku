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
public class IntRangeTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(IntRange.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.IntRange");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(IntRange.SPEC.toString())
        .isEqualTo("@android.support.annotation.IntRange");
  }

  @Test
  public void builder_from() throws Exception {
    assertThat(IntRange.builder().from("$LL", 2).build().toString())
        .isEqualTo("@android.support.annotation.IntRange(from = 2L)");
  }

  @Test
  public void builder_to() throws Exception {
    assertThat(IntRange.builder().to("$LL", 2).build().toString())
        .isEqualTo("@android.support.annotation.IntRange(to = 2L)");
  }
}