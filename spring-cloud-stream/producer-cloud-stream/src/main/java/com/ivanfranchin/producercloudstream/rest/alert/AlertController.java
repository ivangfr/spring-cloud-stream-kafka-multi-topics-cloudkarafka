package com.ivanfranchin.producercloudstream.rest.alert;

import com.ivanfranchin.producercloudstream.kafka.alert.Alert;
import com.ivanfranchin.producercloudstream.kafka.alert.AlertEventProducer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertEventProducer alertEventProducer;

    public AlertController(AlertEventProducer alertEventProducer) {
        this.alertEventProducer = alertEventProducer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<Alert> publish(@Valid @RequestBody CreateAlertRequest createAlertRequest) {
        Alert alert = new Alert(
                UUID.randomUUID().toString(), createAlertRequest.level(), createAlertRequest.message());
        alertEventProducer.send(alert);
        return Mono.just(alert);
    }
}
