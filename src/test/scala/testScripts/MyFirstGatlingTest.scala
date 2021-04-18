package testScripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class MyFirstGatlingTest extends Simulation {
// Protocol Configuration()
  val httpConf = http
    .baseUrl("https://demoblaze.com/")
    .acceptHeader("*/*")
    .contentTypeHeader("application/json")
    
  // Scenaro definition
  val scn = scenario("demoblaze home page")
    .exec(
      http("Get Homepage").get("/")
    ).pause(5)
  //Simulation definition
  setUp(scn.inject(
    atOnceUsers(10)
  ).protocols(httpConf.inferHtmlResources())
  )
}
