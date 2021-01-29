import sbt.Keys.organization

Global / onChangedBuildSource := ReloadOnSourceChanges

val commonSettings = Seq(
  name    := "deps-hell",
  organization := "org.alexr",
  scalaVersion := "2.13.4",
  scalacOptions ++= Seq(
    "-deprecation",
    "-Xfatal-warnings",
  ),
)

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "pprint"                   % "0.6.0",
  "com.lihaoyi"       %% "fansi"                    % "0.2.9",
  "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.3",
  "org.scalatest"     %% "scalatest-funspec"        % "3.2.3",
)

val a1 = (project in file("lib_a_v1"))
  .settings(commonSettings)
  .settings(
    name := "lib_a",
    version := "1.0",
  )

val a2 = (project in file("lib_a_v2"))
  .settings(commonSettings)
  .settings(
    name := "lib_a",
    version := "2.0"
  )

val a3 = (project in file("lib_a_v3"))
  .settings(commonSettings)
  .settings(
    name := "lib_a",
    version := "3.0"
  )

val b = (project in file("lib_b"))
  .settings(commonSettings)
  .settings(
    name := "lib_b",
    version := "1.0",
    libraryDependencies ++= Seq(
      "org.alexr" %% "lib_a" % "1.0",
    ),
  )

val c = (project in file("lib_c"))
  .settings(commonSettings)
  .settings(
    name := "lib_c",
    version := "1.0",
    libraryDependencies ++= Seq(
      "org.alexr" %% "lib_a" % "2.0",
    ),
  )

val app1 = (project in file("app1"))
  .settings(commonSettings)
  .settings(
    name:= "megaApp",
    conflictManager := ConflictManager.strict,
    libraryDependencies ++= Seq(
//      "org.alexr" %% "lib_a" % "2.0",
      "org.alexr" %% "lib_b" % "1.0" % Compile,
      "org.alexr" %% "lib_c" % "1.0" % Compile,
    ),
  )
