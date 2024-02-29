package com.swepool.workshops.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetDto {
  private String userId;
  private String tweet;
}
