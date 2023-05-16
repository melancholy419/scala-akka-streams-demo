import akka.stream.scaladsl.Source
import akka.stream.scaladsl.Flow
import akka.stream.scaladsl.Sink
import akka.actor.typed.ActorSystem
import akka.actor.typed.Behavior
import akka.actor.typed.javadsl.Behaviors

object NameSourceDemo extends App {

  implicit val actorSystem = ActorSystem(Behaviors.empty, "NameSourceDemo")

  val nameSource = Source(
    List("Babatunde", "Doherty", "Emiliano", "Messi", "Haag", "Jose", "Femi")
  )
  val flow = Flow[String].filter(_.length > 5)
  val take2Flow = Flow[String].take(2)
  val sink = Sink.foreach[String](println)

  val graph = nameSource.via(flow).via(take2Flow).to(sink)
  graph.run
}
