public class EclorelaviePackageCounter {
  private final PackageManager pm;
  private static final String ECLORELAVIE_NAME_PART = "eclorelavie";
  private EclorelaviePackageCounter(PackageManager pm) {this.pm = pm;}   


  public int countEclorelaviePackages() {
    int eclorelaviePackages = 0;
    for (ApplicationInfo pinfo: pm.getInstalledApplications(GET_META_DATA)) {
      if (pInfo.packageName.contains(ECLORELAVIE_NAME_PART)) {
         eclorelavie.Packages++;
      }
    }
    return eclorelaviePackages;
  }
}
