package com.swepool.workshops.kafka.service;

import com.swepool.workshops.kafka.dto.TweetDto;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerService {

  private StreamBridge streamBridge;

  public ProducerService(StreamBridge streamBridge) {
    this.streamBridge = streamBridge;
  }

  public void produceMessage(TweetDto dto){
    final Message<TweetDto> message = MessageBuilder.withPayload(dto).setHeader(
        KafkaHeaders.KEY,dto.getUserId().getBytes(StandardCharsets.UTF_8)).build();
    streamBridge.send("incoming-out-0", message);
    log.info("Message sent! :)");
  }

  @Bean
  public Function<String, String> processorBinding(){
    return s -> s + " :: "+System.currentTimeMillis();
  }

	/*@Bean
	public Supplier<String> producerBinding(){
		return () -> "new data";
	}*/

}
