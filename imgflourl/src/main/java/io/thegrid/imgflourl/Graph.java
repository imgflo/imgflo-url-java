package io.thegrid.imgflourl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Graph {
  public static final Integer NO_DIMENSION = null;

  public static class Passthrough extends Graph {
    public Passthrough(Integer width, Integer height) {
      super("passthrough", width, height);
    }
  }

  private final String name;
  private final Map<String, String> params;

  private Graph(String name, Integer width, Integer height) {
    this.name = name;
    this.params = new LinkedHashMap<String, String>();

    if (height != null) {
      addParam("height", height);
    }
    if (width != null) {
      addParam("width", width);
    }
  }

  public String getName() {
    return name;
  }

  public Map<String, String> getParams() {
    return params;
  }

  void addParam(String name, String value) {
    params.put(name, value);
  }

  void addParam(String name, int value) {
    addParam(name, String.valueOf(value));
  }
}
