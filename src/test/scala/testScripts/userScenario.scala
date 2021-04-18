package testScripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class userScenario extends Simulation {
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
        .post(apiUrl + "/view")
        .body(RawFileBody("scala/testScripts/recordedsimulation/0019_request.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody"))

    ).exec { session => println(session("responseBody").as[String]); session }

  }
 def addToCart() = {
    exec(
      http("add to cart")
        .post(apiUrl + "/addtocart")
        .body(RawFileBody("scala/testScripts/recordedsimulation/addtocart.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody"))
    )

  }
  def viewCart() = {
    exec(
      http("view cart")
        .post(apiUrl + "/viewcart")
        .body(RawFileBody("scala/testScripts/recordedsimulation/addtocart.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody"))
    ).exec { session => println(session("responseBody").as[String]); session }
      

  }

  def deleteItem() = {
    exec(
      http("delete item")
        .post(apiUrl + "/deleteitem")
        .body(StringBody("""{ "id": "1dc8b822-0e37-761a-6df8-141eac3ad6ed" }""")).asJson
      .check(status.is(200))
      .check(bodyString.saveAs("responseBody"))
    )

  }

  //Scenario definition
  val scn = scenario("Go to homepage and get product entries")
    .pause(5)
    .exec(getProductentries())
    .pause(5)
    .exec(addToCart())
    .pause(5)
    .exec(viewCart())
      .pause(5)
      .exec(deleteItem())


  //Simulation Definition
  setUp(
    scn.inject(
   constantConcurrentUsers(30) during(30 second)).protocols(httpProtocol.inferHtmlResources()))
    .assertions(global.failedRequests.percent.lte(0.1))
    .assertions(global.requestsPerSec.lte(6))
    .assertions(global.responseTime.max.lte(1000))

}



