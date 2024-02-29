package com.swepool.workshops.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TweetDto {
  private String userId;
  private String tweet;
}
