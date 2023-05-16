import scala.io.Source
import java.io.File
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
object Main extends App {
  for (f <- Source.fromFile(new File("build.sbt")).getLines())
    println(f)
  println("Hello world")
}
