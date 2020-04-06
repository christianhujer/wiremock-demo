package com.nelkinda.demo.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class DemoTest {
    private WireMockServer wireMockServer;

    @BeforeAll
    static void printJavaVersion() {
        System.err.println(System.getProperty("java.version")); // NOSONAR
    }

    @Test
    void wireMockPerformance() {
        assertTimeout(
                ofMillis(100),
                () -> {
                    wireMockServer = new WireMockServer();
                    wireMockServer.start();
                },
                "Startup time of WireMock too long"
        );
        assertTimeout(
                ofMillis(50),
                () -> wireMockServer.stop(),
                "Shutdown time of WireMock too long"
        );
    }

    @AfterEach
    void shutdownWireMock() {
        if (wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }
}
