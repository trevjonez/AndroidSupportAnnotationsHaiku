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

/**
 * @author TrevJonez
 */
public class Size {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, Size.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @NotNull
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String valueFormat;
    Object value;

    String minFormat;
    Object min;

    String maxFormat;
    Object max;

    String multipleFormat;
    Object multiple;

    public Builder value(String format, Object value) {
      this.valueFormat = format;
      this.value = value;
      return this;
    }

    public Builder min(String format, Object min) {
      this.minFormat = format;
      this.min = min;
      return this;
    }

    public Builder max(String format, Object max) {
      this.maxFormat = format;
      this.max = max;
      return this;
    }

    public Builder multiple(String format, Object multiple) {
      this.multipleFormat = format;
      this.multiple = multiple;
      return this;
    }

    public AnnotationSpec build() {
      AnnotationSpec.Builder builder = SPEC.toBuilder();

      if (value != null) {
        builder.addMember("value", valueFormat, value);
      }

      if (min != null) {
        builder.addMember("min", minFormat, min);
      }

      if (max != null) {
        builder.addMember("max", maxFormat, max);
      }

      if (multiple != null) {
        builder.addMember("multiple", multipleFormat, multiple);
      }

      return builder.build();
    }
  }
}
