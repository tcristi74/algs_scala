logLevel := Level.Warn
ThisBuild / useCoursier := false
addSbtPlugin("com.workday" % "syman-plugins" % "2.5.5")
addDependencyTreePlugin

def ivyResolver(name: String, resolverUrl: String): URLRepository =
  Resolver.url(name, url(resolverUrl))(Resolver.ivyStylePatterns)

resolvers := Seq(
  Resolver.url("Workday release SBT plugins", url("https://artifactory.workday.com/artifactory/workday-release"))(Patterns(
    // These patterns describe paths to published artifacts both for SBT plugins and for ordinary (non-plugin) code.
    "[orgPath]/[module](_[scalaVersion])(_[sbtVersion])/[revision]/[artifact](-[classifier]).[ext]",
    "[orgPath]/[module](_[scalaVersion])(_[sbtVersion])/[revision]/[artifact](_[scalaVersion])(_[sbtVersion])-[revision](-[classifier]).[ext]"
  )),
  ivyResolver("Workday scalasbt-cache", "https://artifactory.workday.com/artifactory/scalasbt-cache"),
  // For example, this pattern matches org.scala-sbt/sbt-duplicates-finder/scala_2.10/sbt_0.13/0.8.1/ivys/ivy.xml
  "Workday remote-repos" at "https://artifactory.workday.com/artifactory/remote-repos",
  ivyResolver("bintray-sbt-plugins", "https://dl.bintray.com/sbt/sbt-plugin-releases")
)

