[![Build Status](https://travis-ci.org/the-grid/imgflo-url-java.svg?branch=master)](https://travis-ci.org/the-grid/imgflo-url-java)

# ImgFlo-URL.java

Conveniently produce authorized [imgflo](https://github.com/jonnor/imgflo) URLs on the JVM.


## Usage

```java
Graph graph = new Graph.Passthrough(100, 100);
String input = "https://example.org/image.png";

String result = imgFloUrl.build(graph, input);
```


## Installation

Find the [latest version.](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22imgflourl%22)

### Gradle

```groovy
compile 'io.thegrid.imgflourl:imgflourl:[latest-version]'
```

### Maven

```xml
<dependency>
  <groupId>io.thegrid.imgflourl</groupId>
  <artifactId>imgflourl</artifactId>
  <version>[latest version]</version>
</dependency>
```

## License

[MIT](LICENSE.md)
