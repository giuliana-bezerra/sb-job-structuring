package br.com.giulianabezerra.sbjobstructuring;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step1Config {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step step1(@Qualifier("reader1") ItemReader<Integer> reader1, ItemWriter<Integer> writer) {
    return stepBuilderFactory
        .get("step1")
        .<Integer, Integer>chunk(5)
        .reader(reader1)
        .writer(writer)
        .build();
  }
}
