package com.swepool.workshops.kafka.service;

import com.swepool.workshops.kafka.dto.TweetDto;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

  @Bean
  public Consumer<TweetDto> consumerBinding(){
    return tweet -> log.info("New tweet from {}: {}", tweet.getUserId(), tweet.getTweet());
  }

}
