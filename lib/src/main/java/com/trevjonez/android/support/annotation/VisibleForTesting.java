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
public class VisibleForTesting {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, VisibleForTesting.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @Nonnull
  public static AnnotationSpec otherwisePrivate() {
    return otherwise("PRIVATE");
  }

  @Nonnull
  public static AnnotationSpec otherwisePackagePrivate() {
    return otherwise("PACKAGE_PRIVATE");
  }

  @Nonnull
  public static AnnotationSpec otherwiseProtected() {
    return otherwise("PROTECTED");
  }

  @Nonnull
  public static AnnotationSpec otherwiseNone() {
    return otherwise("NONE");
  }

  @Nonnull
  private static AnnotationSpec otherwise(String otherwise) {
    return SPEC.toBuilder().addMember("otherwise", "$T.$L", CLASS_NAME, otherwise).build();
  }
}
