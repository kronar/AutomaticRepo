public class PackageCountingTest {

  List<ApplicationInfo> preparedApplications = new ArrayList<>();

  @Before
  public void setup() {
  String[] packageNames = new String[] {"com.eclrelavie.app1", "com.eclrelavie.app2", "com.google.app"};

    for (String name: packageNames) {
      ApplicationInfo dummy = new ApplicationInfo();
      dummy.packageName = name;
      preparedApplications.add(dummy);
    }
  }

  @Test
  public void packageCountingTest() {
    PackageManager mockedPM = Mockito.mock(PackageManager.class);
    when(mockedPM.getInstalledApplications(GET_META_DATA))
        .thenReturn(preparedApplications);

    EclorelaviePackageCounter counter = new EclorelaviePackageCounter(mockedPM);
    assertThat(counter.countEclorelaviePackages()).isEqual(2);

    verify(mockedPM).getInstalledApplications(GET_META_DATA);
  }
}
  
