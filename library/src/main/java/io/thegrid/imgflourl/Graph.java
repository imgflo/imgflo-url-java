package io.thegrid.imgflourl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Specification for the graph to be used for processing an image
 */
public abstract class Graph {
  public static final Integer NO_DIMENSION = null;

  /**
   * Graph that does nothing at all.
   */
  public static class NoOp extends Graph {
    public NoOp() {
      super("noop");
    }
  }

  private static abstract class WidthHeightGraph extends Graph {
    private WidthHeightGraph(String name, Integer width, Integer height) {
      super(name);

      if (height != null) {
        addParam("height", height);
      }
      if (width != null) {
        addParam("width", width);
      }
    }
  }

  /**
   * Simple graph that does nothing but resizing.
   */
  public static class Passthrough extends WidthHeightGraph {
    /**
     * Creates a new Passthrough graph configuration
     *
     * @param width  Target width of the image or {@link #NO_DIMENSION} for keeping the aspect ratio
     * @param height Target height of the image or {@link #NO_DIMENSION} for keeping the aspect ratio
     */
    public Passthrough(Integer width, Integer height) {
      super("passthrough", width, height);
    }
  }

  public static class GradientMap extends WidthHeightGraph {
    public GradientMap(Integer width, Integer height,
                       double stop1, double stop2, double stop3,
                       String color1, String color2, String color3, boolean srgb) {
      super("gradientmap", width, height);

      addParam("stop1", stop1);
      addParam("stop2", stop2);
      addParam("stop3", stop3);

      addParam("color1", color1);
      addParam("color2", color2);
      addParam("color3", color3);

      addParam("srgb", srgb ? "True" : "False");
    }
  }

  private final String name;
  private final Map<String, String> params;

  private Graph(String name) {
    this.name = name;
    this.params = new LinkedHashMap<String, String>();
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

  void addParam(String name, double value) {
    addParam(name, String.valueOf(value));
  }
}
