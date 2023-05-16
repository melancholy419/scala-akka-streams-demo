organization := "com.babatunde"
name := "akka-streams-demo"
scalaVersion := "2.13.10"

val library = new {

  val versions = new {
    val akka = "2.8.2"

  }
  val akka = new {

    val akkaStreams = "com.typesafe.akka" %% "akka-stream" % versions.akka
    val akkaStreamsTest =
      "com.typesafe.akka" %% "akka-stream-testkit" % versions.akka % Test
    val akkaTyped = "com.typesafe.akka" %% "akka-cluster-typed" % versions.akka
    val all = Seq(akkaStreams, akkaStreamsTest, akkaTyped)
  }
}

libraryDependencies ++= library.akka.all
