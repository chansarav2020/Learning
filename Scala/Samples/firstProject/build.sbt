libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
scalaVersion := "2.12.1"
enablePlugins(JavaAppPackaging)
lazy val fizzbuzz = project
  .settings(scalaVersion := "2.12.1")
  .settings(libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test")
dependsOn(fizzbuzz)
name := "firstproject"
version := "0.2"
libraryDependencies += "org.jsoup" % "jsoup" % "1.10.1"
