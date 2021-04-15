package scala.testScripts

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://demoblaze.com")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4371.0 Safari/537.36")

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_1 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "same-origin")

	val headers_4 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "script",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "same-origin")

	val headers_6 = Map(
		"accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "image",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "same-origin")

	val headers_13 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"origin" -> "https://demoblaze.com",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "font",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")

	val headers_14 = Map(
		"accept" -> "application/json, text/javascript, */*; q=0.01",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin",
		"x-requested-with" -> "XMLHttpRequest")

	val headers_15 = Map(
		"User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_18 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"access-control-request-headers" -> "content-type",
		"access-control-request-method" -> "POST",
		"origin" -> "https://demoblaze.com",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-site")

	val headers_19 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"content-type" -> "application/json",
		"origin" -> "https://demoblaze.com",
		"sec-ch-ua" -> """Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-site")

    val uri1 = "https://api.demoblaze.com/view"
    val uri3 = "https://hls.demoblaze.com"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/prod.html?idp_=1")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/css/latostyle.css")
			.headers(headers_1),
            http("request_2")
			.get("/node_modules/bootstrap/dist/css/bootstrap.min.css")
			.headers(headers_1),
            http("request_3")
			.get("/css/latofonts.css")
			.headers(headers_1),
            http("request_4")
			.get("/node_modules/jquery/dist/jquery.min.js")
			.headers(headers_4),
            http("request_5")
			.get("/node_modules/video.js/dist/video-js.min.css")
			.headers(headers_1),
            http("request_6")
			.get("/imgs/front.jpg")
			.headers(headers_6),
            http("request_7")
			.get("/bm.png")
			.headers(headers_6),
            http("request_8")
			.get("/node_modules/videojs-contrib-hls/dist/videojs-contrib-hls.min.js")
			.headers(headers_4),
            http("request_9")
			.get("/node_modules/bootstrap/dist/js/bootstrap.min.js")
			.headers(headers_4),
            http("request_10")
			.get("/js/prod.js")
			.headers(headers_4),
            http("request_11")
			.get("/node_modules/tether/dist/js/tether.min.js")
			.headers(headers_4),
            http("request_12")
			.get("/node_modules/video.js/dist/video.min.js")
			.headers(headers_4),
            http("request_13")
			.get("/css/fonts/Lato-Regular.woff2")
			.headers(headers_13),
            http("request_14")
			.get("/config.json")
			.headers(headers_14),
            http("request_15")
			.get(uri3 + "/index.m3u8")
			.headers(headers_15),
            http("request_16")
			.get(uri3 + "/about_demo_hls_600k.m3u8")
			.headers(headers_15),
            http("request_17")
			.get(uri3 + "/about_demo_hls_600k00000.ts")
			.headers(headers_15),
            http("request_18")
			.options(uri1)
			.headers(headers_18),
            http("request_19")
			.post(uri1)
			.headers(headers_19)
			.body(RawFileBody("scala/testScripts/recordedsimulation/0019_request.json")),
            http("request_20")
			.get("/imgs/galaxy_s6.jpg")
			.headers(headers_6)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}