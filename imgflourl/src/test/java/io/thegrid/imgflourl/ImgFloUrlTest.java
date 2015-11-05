package io.thegrid.imgflourl;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImgFloUrlTest {
  private ImgFloUrl imgFloUrl;

  @Before
  public void setUp() {
    imgFloUrl = new ImgFloUrl("https://imgflo.herokuapp.com", "test-key", "test-secret");
  }

  @Test
  public void shouldCreateUrl() {
    Graph graph = new Graph.Passthrough(100, 100);
    String input = "https://corner.squareup.com/images/hero.png";

    String result = imgFloUrl.build(graph, input);
    assertThat(result).isEqualTo("https://imgflo.herokuapp.com/graph/test-key/bc6b8a0606f9cd4442c40e14af98d3ea/passthrough.png?input=https%3A%2F%2Fcorner.squareup.com%2Fimages%2Fhero.png&height=100&width=100");
  }

  @Test public void shouldCreateUrlForInputWithAnotherUrl() {
    Graph graph = new Graph.Passthrough(100, Graph.NO_DIMENSION);

    String input = "https://s.gravatar.com/avatar/5d6489ce2e228503e0244878f4a82707?d=https%3A%2F%2Fpassport.thegrid.io%2Fprofile-fallback.png";
    String result = imgFloUrl.build(graph, input);
    assertThat(result).isEqualTo("https://imgflo.herokuapp.com/graph/test-key/1dd0e14cf293a3981d739c91d262fd2c/passthrough.png?input=https%3A%2F%2Fs.gravatar.com%2Favatar%2F5d6489ce2e228503e0244878f4a82707%3Fd%3Dhttps%253A%252F%252Fpassport.thegrid.io%252Fprofile-fallback.png&width=100");
  }
}
