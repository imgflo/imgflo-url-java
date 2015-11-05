[![Build Status](https://magnum.travis-ci.com/the-grid/imgflo-url-java.svg?token=9xAVMRcpBzfSYDP6cJdk&branch=master)](https://magnum.travis-ci.com/the-grid/imgflo-url-java)

# ImgFlo-URL.java

Conveniently produce authorized [imgflo](https://github.com/jonnor/imgflo) URLs on the JVM.


## Usage

```java
Graph graph = new Graph.Passthrough(100, 100);
String input = "https://example.org/image.png";

String result = imgFloUrl.build(graph, input);
```


## Installation

tbd.


## License

[MIT](LICENSE.md)
