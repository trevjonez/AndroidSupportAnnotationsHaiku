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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TrevJonez
 */
public class IntDef {
  public static final ClassName CLASS_NAME =
      ClassName.get(Constants.PACKAGE, IntDef.class.getSimpleName());

  public static final AnnotationSpec SPEC = AnnotationSpec.builder(CLASS_NAME).build();

  @Nonnull
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String valueFormat;
    private List<Object> value;

    private String flagFormat;
    private Object flag;

    public Builder value(String format, Object... value) {
      this.valueFormat = format;
      this.value = new LinkedList<Object>();
      Collections.addAll(this.value, value);
      return this;
    }

    public Builder flag(String format, Object flag) {
      this.flagFormat = format;
      this.flag = flag;
      return this;
    }

    public Builder flag(boolean flag) {
      return flag("$L", flag);
    }

    public AnnotationSpec build() {
      AnnotationSpec.Builder builder = SPEC.toBuilder();

      if (value != null) {
        builder.addMember("value", valueFormat, value.toArray());
      }

      if (flag != null) {
        builder.addMember("flag", flagFormat, flag);
      }

      return builder.build();
    }
  }
}
