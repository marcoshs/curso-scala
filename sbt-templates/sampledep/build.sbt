//Build.sbt sample for a simple application with some library dependencies.
//Author: marcoshs
 
lazy val sample = RootProject(file("../sample"))

lazy val organizer = Project(
  id = "sampledep",
  base = file("."),
  settings = Project.defaultSettings ++ Seq(
    name := "sampledep",
    organization := "la.aquare",
    version := "0.0.1",
    scalaVersion := "2.11.7"
  )
).dependsOn(sample)

libraryDependencies += "junit" % "junit" % "4.12" % "test"							
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"		