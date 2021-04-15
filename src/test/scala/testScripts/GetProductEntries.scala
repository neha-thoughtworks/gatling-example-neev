package testScripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class GetProductEntries extends Simulation {
  // protocol configuration
  val apiUrl = "https://api.demoblaze.com"
  val httpProtocol = http
    .baseUrl("https://www.demoblaze.com")
    .acceptHeader("*/*")
    .contentTypeHeader("application/json")

  def goToHomePage() = {
    exec(
      http("go to home page")
        .get("/")
        .check(status.is(200))
    )
  }

  def getProductentries() = {
    exec(
      http("Get product entries")
        .get(apiUrl + "/entries")
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody"))

    ).exec { session => println(session("responseBody").as[String]); session }

  }

  //Scenario definition
  val scn = scenario("Go to homepage and get product entries")
    .exec(goToHomePage())
    .pause(5)
    .exec(getProductentries())


  //Simulation Definition
  setUp(
    scn.inject(
      atOnceUsers(10),nothingFor( 5 seconds) ,rampUsersPerSec(1) to (2) during (30 seconds)).protocols(httpProtocol.inferHtmlResources()))
    .assertions(global.failedRequests.percent.is(0))

}



