package br.com.giulianabezerra.sbjobstructuring;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

  @Bean
  public ItemWriter<Integer> writer() {
    return System.out::println;
  }
}
