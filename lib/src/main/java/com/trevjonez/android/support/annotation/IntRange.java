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
public class IntRange {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, IntRange.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @NotNull
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String fromFormat;
    Object from;

    String toFormat;
    Object to;

    public Builder from(String format, Object from) {
      this.fromFormat = format;
      this.from = from;
      return this;
    }

    public Builder from(long from) {
      return from("$LL", from);
    }

    public Builder to(String format, Object to) {
      this.toFormat = format;
      this.to = to;
      return this;
    }

    public Builder to(long to) {
      return to("$LL", to);
    }

    public AnnotationSpec build() {
      AnnotationSpec.Builder builder = SPEC.toBuilder();

      if (from != null) {
        builder.addMember("from", fromFormat, from);
      }

      if (to != null) {
        builder.addMember("to", toFormat, to);
      }

      return builder.build();
    }
  }
}
