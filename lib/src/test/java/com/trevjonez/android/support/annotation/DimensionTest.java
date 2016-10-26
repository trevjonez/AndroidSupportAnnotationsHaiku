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
public class DimensionTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(Dimension.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.Dimension");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(Dimension.SPEC.toString())
        .isEqualTo("@android.support.annotation.Dimension");
  }

  @Test
  public void DP() throws Exception {
    assertThat(Dimension.DP.toString())
        .isEqualTo("@android.support.annotation.Dimension(unit = android.support.annotation.Dimension.DP)");
  }

  @Test
  public void PX() throws Exception {
    assertThat(Dimension.PX.toString())
        .isEqualTo("@android.support.annotation.Dimension(unit = android.support.annotation.Dimension.PX)");
  }

  @Test
  public void SP() throws Exception {
    assertThat(Dimension.SP.toString())
        .isEqualTo("@android.support.annotation.Dimension(unit = android.support.annotation.Dimension.SP)");
  }

  @RunWith(JUnit4.class)
  public static class UnitTest {
    @Test
    public void classNameOutput() throws Exception {
      assertThat(Dimension.Unit.CLASS_NAME.toString())
          .isEqualTo("android.support.annotation.Dimension.Unit");
    }

    @Test
    public void specOutput() throws Exception {
      assertThat(Dimension.Unit.SPEC.toString())
          .isEqualTo("@android.support.annotation.Dimension.Unit");
    }
  }
}