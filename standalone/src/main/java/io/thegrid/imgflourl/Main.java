package io.thegrid.imgflourl;

public class Main {
  public static void main(String[] args) {
    final String server = requireEnv("IMGFLO_SERVER");
    final String key = requireEnv("IMGFLO_KEY");
    final String secret = requireEnv("IMGFLO_SECRET");

    ImgFloUrl imgFloUrl = new ImgFloUrl(server, key, secret);
    String url = imgFloUrl.build(new Graph.Passthrough(Graph.NO_DIMENSION, Graph.NO_DIMENSION), args[0]);
    System.out.println(url);
  }

  private static String requireEnv(String name) {
    String result = System.getenv(name);
    if (result == null) {
      throw new IllegalArgumentException(String.format("%s not defined in environment", name));
    }
    return result;
  }

  private Main() {
    throw new AssertionError("No instances");
  }
}
