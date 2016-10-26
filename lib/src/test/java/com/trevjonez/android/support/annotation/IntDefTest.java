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
public class IntDefTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(IntDef.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.IntDef");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(IntDef.SPEC.toString())
        .isEqualTo("@android.support.annotation.IntDef");
  }

  @Test
  public void builder_value() throws Exception {
    assertThat(IntDef.builder().value("{$L, $L}", 1, 2).build().toString())
        .isEqualTo("@android.support.annotation.IntDef({1, 2})");
  }

  @Test
  public void builder_flag() throws Exception {
    assertThat(IntDef.builder().flag("$L", true).build().toString())
        .isEqualTo("@android.support.annotation.IntDef(flag = true)");
  }
}