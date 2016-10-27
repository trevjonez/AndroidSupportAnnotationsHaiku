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

import com.squareup.javapoet.ClassName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author TrevJonez
 */
@RunWith(JUnit4.class)
public class CheckResultTest {
  @Test
  public void classNameOutput() throws Exception {
    assertThat(CheckResult.CLASS_NAME.toString())
        .isEqualTo("android.support.annotation.CheckResult");
  }

  @Test
  public void specOutput() throws Exception {
    assertThat(CheckResult.SPEC.toString())
        .isEqualTo("@android.support.annotation.CheckResult");
  }

  @Test
  public void suggest_string() throws Exception {
    assertThat(CheckResult.suggest("$S", "Use the other thing").toString())
        .isEqualTo("@android.support.annotation.CheckResult(suggest = \"Use the other thing\")");
  }

  @Test
  public void suggest_string_default_format() throws Exception {
    assertThat(CheckResult.suggest("Use the other thing").toString())
        .isEqualTo("@android.support.annotation.CheckResult(suggest = \"Use the other thing\")");
  }

  @Test
  public void suggest_other() throws Exception {
    assertThat(CheckResult.suggest("$T.CONSTANT", ClassName.get("some.package", "SomeType")).toString())
        .isEqualTo("@android.support.annotation.CheckResult(suggest = some.package.SomeType.CONSTANT)");
  }
}