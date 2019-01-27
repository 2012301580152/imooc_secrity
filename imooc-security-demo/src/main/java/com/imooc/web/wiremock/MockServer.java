package com.imooc.web.wiremock;

//import com.github.tomake

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @ClassName MockServer
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 21:58
 * @Version 1.0
 */
public class MockServer {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults to port 8080

    public static void main(String[] args) {
//        WireMock
        stubFor(get(urlEqualTo("/my/resource"))
                .withHeader("Accept", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

    }
}
