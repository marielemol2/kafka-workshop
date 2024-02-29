package com.swepool.workshops.kafka.controller;
import com.swepool.workshops.kafka.dto.TweetDto;
import com.swepool.workshops.kafka.service.ProducerService;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@Slf4j
public class ProducerController {

  private ProducerService producerService;

  public ProducerController(ProducerService producerService) {
    this.producerService = producerService;
  }

  @PostMapping("/tweet")
  ResponseEntity<?> publishTweet(@RequestBody TweetDto dto) {
    try{
      log.info("Producing message...");
      producerService.produceMessage(dto);
      return ResponseEntity.ok("Tweet sent successfully!");
    } catch (Exception e){
      log.error("ERROR - {}", e.getMessage());
      return ResponseEntity.internalServerError().body("There has been an error");
    }
  }
}
