package com.eclorelavie.installationpackages;
import org.junit.Test;
import static org.junit.Assert.*;


public class InstallAllPackUtilTest {
  @Test
  public void packageInstallationSucceeds() throws TimeoutException {
    Srting[] names = new String[]{"com.eclorelavie.app1","com.eclorelavie.app2",
    "com.google.app"};

    installAllPackages(names);

    assertThat(names, everyItem(is(installedPackage)));
  }

  
