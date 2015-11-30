package io.thegrid.imgflourl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgFloUrl {
  private static final Pattern EXTENSION_PATTERN = Pattern.compile("\\.(\\w+)$");

  private final String server;
  private final String key;
  private final String secret;

  /**
   * Creates a new ImgFloUrl instance
   *
   * @param server The base url of the ImgFlo server
   * @param key The authentication key
   * @param secret The authentication secret
   */
  public ImgFloUrl(String server, String key, String secret) {
    this.server = server.endsWith("/")
        ? server.replaceAll("/+$", "")
        : server;
    this.key = key;
    this.secret = secret;
  }

  /**
   * Builds an authenticated ImgFlo url
   * @param graph The {@link Graph} to be used for processing
   * @param source The URL of the source image
   * @return The ImgFlo url
   */
  public String build(Graph graph, String source) {
    String extension = getExtension(source);

    // ImgFlo doesn't support gif transformations
    if ("gif".equals(extension)) {
      graph = new Graph.NoOp();
    }

    String graphName = graph.getName();

    if ("tif".equals(extension) || "tiff".equals(extension)) {
      extension = "png";
    }

    if (extension != null) {
      graphName = graphName + "." + extension;
    }

    String base = server + "/graph/" + key + "/";

    String query = "?input=" + encode(source);

    Map<String, String> params = graph.getParams();
    for (String name : params.keySet()) {
      query += String.format("&%s=%s", name, params.get(name));
    }

    String token = md5(graphName + query + secret);
    return base + token + "/" + graphName + query;
  }

  private static String encode(String input) {
    try {
      return URLEncoder.encode(input, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  private static String getExtension(String input) {
    Matcher matcher = EXTENSION_PATTERN.matcher(input);
    if (matcher.find()) {
      return matcher.group(1);
    } else {
      return null;
    }
  }

  private static String md5(final String s) {
    final String md5 = "MD5";
    try {
      // Create MD5 Hash
      MessageDigest digest = java.security.MessageDigest
          .getInstance(md5);
      digest.update(s.getBytes());
      byte[] messageDigest = digest.digest();

      // Create Hex String
      StringBuilder hexString = new StringBuilder();
      for (byte aMessageDigest : messageDigest) {
        String h = Integer.toHexString(0xFF & aMessageDigest);
        while (h.length() < 2) {
          h = "0" + h;
        }
        hexString.append(h);
      }
      return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
