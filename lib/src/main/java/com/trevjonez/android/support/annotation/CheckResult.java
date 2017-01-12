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

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

import javax.annotation.Nonnull;

/**
 * @author TrevJonez
 */
public class CheckResult {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, CheckResult.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @Nonnull
  public static AnnotationSpec suggest(String format, Object suggest) {
    return SPEC.toBuilder().addMember("suggest", format, suggest).build();
  }

  @Nonnull
  public static AnnotationSpec suggest(String suggest) {
    return SPEC.toBuilder().addMember("suggest", "$S", suggest).build();
  }
}
