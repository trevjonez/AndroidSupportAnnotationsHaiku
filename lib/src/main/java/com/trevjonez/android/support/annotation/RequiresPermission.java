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
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TrevJonez
 */
public class RequiresPermission {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, RequiresPermission.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @NotNull
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String valueFormat;
    Object value;

    String allOfFormat;
    List<Object> allOf;

    String anyOfFormat;
    List<Object> anyOf;

    String conditionalFormat;
    Object conditional;

    public Builder value(String format, Object value) {
      this.valueFormat = format;
      this.value = value;
      return this;
    }

    public Builder allOf(String format, Object... allOf) {
      this.allOfFormat = format;
      this.allOf = new LinkedList<>();
      Collections.addAll(this.allOf, allOf);
      return this;
    }

    public Builder anyOf(String format, Object... anyOf) {
      this.anyOfFormat = format;
      this.anyOf = new LinkedList<>();
      Collections.addAll(this.anyOf, anyOf);
      return this;
    }

    public Builder conditional(String format, Object conditional) {
      this.conditionalFormat = format;
      this.conditional = conditional;
      return this;
    }

    public AnnotationSpec build() {
      AnnotationSpec.Builder builder = SPEC.toBuilder();

      if (value != null) {
        builder.addMember("value", valueFormat, value);
      }

      if (allOf != null && allOf.size() > 0) {
        builder.addMember("allOf", allOfFormat, allOf.toArray());
      }

      if (anyOf != null && anyOf.size() > 0) {
        builder.addMember("anyOf", anyOfFormat, anyOf.toArray());
      }

      if (conditional != null) {
        builder.addMember("conditional", conditionalFormat, conditional);
      }

      return builder.build();
    }
  }

  public static class Read {
    public static final ClassName CLASS_NAME =
        ClassName.get(Constants.PACKAGE, RequiresPermission.class.getSimpleName(),
            Read.class.getSimpleName());

    public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

    @NotNull
    public static AnnotationSpec value(String format, Object value) {
      return SPEC.toBuilder().addMember("value", format, value).build();
    }
  }

  public static class Write {
    public static final ClassName CLASS_NAME =
        ClassName.get(Constants.PACKAGE, RequiresPermission.class.getSimpleName(),
            Write.class.getSimpleName());

    public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

    @NotNull
    public static AnnotationSpec value(String format, Object value) {
      return SPEC.toBuilder().addMember("value", format, value).build();
    }
  }
}
