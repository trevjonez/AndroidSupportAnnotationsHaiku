Android Support Annotations Haiku
======
So you decided to write an annotation processors using [square/javapoet](https://github.com/square/javapoet) to generate some boilerplate away.
Next thing you knew, your code base was littered with `ClassName.get("android.support.annotation", "NonNull")` and friends.
I've been there and got tired of declaring similar constants, so I made this little book of poems.
   
Installation
------
In your `build.gradle` file add the jitpack repository. 
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Declare the dependency
```groovy
compile 'com.github.trevjonez:AndroidSupportAnnotationsHaiku:24.2.1.1'
```

The version of the library will track against the version of the support library where
the final number is the version of this library for that release of the support library.

Usage
------
Just use it:
```java
MethodSpec.builder("someMethod")
          .addAnnotation(NonNull.SPEC)
          ...
          .build();
```

Annotations that have arguments can be customized via static factory methods that either
do all the work, or create a builder class you can use. It really is just a thin layer
on java poet so all the same rules apply. 

There are some repetitive unit tests you can look at to get an idea of how I intended it to work.

Obligatory Haiku
------

```
Sick of `ClassName.get`?
Support annotations lib...
I made this for you.
```

License
------
    Copyright 2016 Trevor Jones

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
