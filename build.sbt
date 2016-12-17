name := "static-config"
organization := "com.github.krever"

version := "1.1.0"

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")


libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  "com.lihaoyi" %% "sourcecode" % "0.1.3",

  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomExtra :=
  <url>https://github.com/Krever/static-config</url>
    <licenses>
      <license>
        <name>MIT license</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:Krever/static-config.git</url>
      <connection>scm:git:git@github.com:Krever/static-config.git</connection>
    </scm>
    <developers>
      <developer>
        <id>Krever</id>
        <name>Wojciech Pituła</name>
        <url>w.pitula.me</url>
      </developer>
    </developers>