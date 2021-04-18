package testScripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class MySecondGatlingTest extends Simulation {
  
  // 1. http protocol configuration
  val httpconf = http.baseUrl("https://api.demoblaze.com")
    .acceptHeader("*/*")
    .contentTypeHeader("application/json")
  
  // 2. Scenario definition 
  def getProductEntries() = {
    exec(http("Get Product Entries in home Page")
    .get("/entries")
      .check(status.is(200))
        .check(jsonPath("$.Items[0].title")is("Samsung galaxy s6"))
    )
  }
  
  val scn = scenario("get Product entries")
    .pause(5 )
    .exec(getProductEntries())
  
  //Load/simulation definition
  
  setUp(
    scn.inject(atOnceUsers(1),nothingFor(5 second), rampUsers(30) during(10 second))
      .protocols(httpconf.inferHtmlResources())
  ).assertions(global.failedRequests.percent.lte(0.1)
  ).assertions(global.requestsPerSec.lte(6))
    .assertions(global.responseTime.max.gte(1000))

}
