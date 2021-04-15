package testScripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class MyFirstTest extends Simulation{
  // protocol configuration
  val httpProtocol = http
    .baseUrl("https://www.demoblaze.com")
    .acceptHeader("*/*")
    .contentTypeHeader("application/json")
  
  //Scenario definition
  val scn = scenario("Go to homepage")
    .exec(http("Homepage")
      .get("/")
      .check(status.is(200))

    )
  //Simulation Definition
  setUp(
    scn.inject(
      atOnceUsers(100)).protocols(httpProtocol.inferHtmlResources()))
    .assertions(global.failedRequests.percent.is(0 ))

}



