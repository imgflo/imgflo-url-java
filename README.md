[![Build Status](https://travis-ci.org/the-grid/imgflo-url-java.svg?branch=master)](https://travis-ci.org/the-grid/imgflo-url-java)

# ImgFlo-URL.java

Conveniently produce authorized [imgflo](https://github.com/jonnor/imgflo) URLs on the JVM.


## Usage

### Library

```java
Graph graph = new Graph.Passthrough(100, 100);
String input = "https://example.org/image.png";

String result = imgFloUrl.build(graph, input);
```

### Standalone

*Experimental, only supports passthrough graph without parameters*

```
$ git clone https://github.com/the-grid/imgflo-url-java.git
$ cd imgflo-url-java
$ export IMGFLO_SERVER=https://example.org
$ export IMGFLO_KEY=example-key
$ export IMGFLO_SECRET=example-secret
$ ./gradlew :standalone:jar
$ java -jar standalone/build/libs/standalone.jar "http://example.org/my-image.jpg"
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
