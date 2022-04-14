package com.example.serverdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerDemoApplicationTests {
    @Autowired
    TokenizerController tokenizerController;

    @Test
    void name() {
        var request = new Request();

        var request2 = request.setText("");

        assert request == request2;
    }
}
