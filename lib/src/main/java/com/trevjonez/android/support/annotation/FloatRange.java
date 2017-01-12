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
public class FloatRange {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, FloatRange.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @Nonnull
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String fromFormat;
    private Object from;

    private String toFormat;
    private Object to;

    private String fromInclusiveFormat;
    private Object fromInclusive;

    private String toInclusiveFormat;
    private Object toInclusive;

    public Builder from(String format, Object from) {
      this.fromFormat = format;
      this.from = from;
      return this;
    }

    public Builder from(double from) {
      return from("$LD", from);
    }

    public Builder to(String format, Object to) {
      this.toFormat = format;
      this.to = to;
      return this;
    }

    public Builder to(double to) {
      return to("$LD", to);
    }

    public Builder fromInclusive(String format, Object fromInclusive) {
      this.fromInclusiveFormat = format;
      this.fromInclusive = fromInclusive;
      return this;
    }

    public Builder fromInclusive(boolean fromInclusive) {
      return fromInclusive("$L", fromInclusive);
    }

    public Builder toInclusive(String format, Object toInclusive) {
      this.toInclusiveFormat = format;
      this.toInclusive = toInclusive;
      return this;
    }

    public Builder toInclusive(boolean toInclusive) {
      return toInclusive("$L", toInclusive);
    }

    public AnnotationSpec build() {
      AnnotationSpec.Builder builder = SPEC.toBuilder();

      if (from != null) {
        builder.addMember("from", fromFormat, this.from);
      }

      if (to != null) {
        builder.addMember("to", toFormat, this.to);
      }

      if (fromInclusive != null) {
        builder.addMember("fromInclusive", fromInclusiveFormat, this.fromInclusive);
      }

      if (toInclusive != null) {
        builder.addMember("toInclusive", toInclusiveFormat, this.toInclusive);
      }

      return builder.build();
    }
  }
}
