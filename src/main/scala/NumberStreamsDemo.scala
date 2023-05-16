import akka.stream.scaladsl.Source
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorSystem
import akka.stream.Materializer
import akka.stream.scaladsl.{Flow, Sink}

object NumberStreamsDemo extends App {

  implicit val system = ActorSystem(Behaviors.empty, "NumberStreams")

  val source = Source(1 to 100)
  val flow = Flow[Int].map(_ + 1)
  val sink = Sink.foreach(println)

  val graph = source.via(flow).to(sink)
  graph.run

}
