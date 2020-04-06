package com.nelkinda.demo.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.err; // NOSONAR

class DemoTest {
    @Test
    void wireMockPerformance() {
        final long start = currentTimeMillis();
        final WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        final long stop = currentTimeMillis();
        wireMockServer.stop();
        final long end = currentTimeMillis();
        err.format("Time to start: %d%n", stop - start);
        err.format("Time to stop: %d%n", end - stop);
    }
}
