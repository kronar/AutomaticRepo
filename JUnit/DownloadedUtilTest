package com.eclorelavie.downloaded;
import org.junit.Test;
import static org.junit.Assert.*;


public class DownloadedUtilTest {
  @Test
  public void fileSuccessfullyDownloaded() throws TimeoutException {
    final int status = ImageAPI.download("test.jpg")
    assertThat(status).isEqualTo(ImageAPI.OK);
    assertThatFileExists("test.jpg");
  }

  @Test
  public void noFileDownloadedOnError() throws TimeoutException {
    final int status = ImageAPI.download("missing-file.jpg")
    assertThat(status).isEqualTo(ImageAPI.ERROR);
    assertThatNoFileDownloaded("test.jpg");
  }
 

