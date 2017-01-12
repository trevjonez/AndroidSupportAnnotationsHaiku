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

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;

/**
 * @author TrevJonez
 */
public class RestrictTo {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, RestrictTo.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  public static AnnotationSpec value(Scope scope) {
    return SPEC.toBuilder().addMember("value", "$T.$L", Scope.CLASS_NAME, scope.toString()).build();
  }

  public static AnnotationSpec value(Scope scope1, Scope scope2) {
    return SPEC.toBuilder().addMember("value", "{$T.$L, $T.$L}",
        Scope.CLASS_NAME, scope1.toString(),
        Scope.CLASS_NAME, scope2.toString()).build();
  }

  public static AnnotationSpec value(Scope scope1, Scope scope2, Scope scope3) {
    return SPEC.toBuilder().addMember("value", "{$T.$L, $T.$L, $T.$L}",
        Scope.CLASS_NAME, scope1.toString(),
        Scope.CLASS_NAME, scope2.toString(),
        Scope.CLASS_NAME, scope3.toString()).build();
  }

  public static AnnotationSpec value(Scope scope1, Scope scope2, Scope scope3, Scope scope4) {
    return SPEC.toBuilder().addMember("value", "{$T.$L, $T.$L, $T.$L, $T.$L}",
        Scope.CLASS_NAME, scope1.toString(),
        Scope.CLASS_NAME, scope2.toString(),
        Scope.CLASS_NAME, scope3.toString(),
        Scope.CLASS_NAME, scope4.toString()).build();
  }

  public enum Scope {
    LIBRARY,
    LIBRARY_GROUP,
    TESTS,
    SUBCLASSES;

    public static final ClassName CLASS_NAME =
        ClassName.get(Constants.PACKAGE, RestrictTo.class.getSimpleName(), Scope.class.getSimpleName());
  }
}
