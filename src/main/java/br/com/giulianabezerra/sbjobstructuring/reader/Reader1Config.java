package br.com.giulianabezerra.sbjobstructuring.reader;

import java.util.Arrays;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Reader1Config {

  @Bean
  public ItemReader<Integer> reader1() {
    return new ListItemReader<>(Arrays.asList(1, 2, 3, 4, 5));
  }
}
