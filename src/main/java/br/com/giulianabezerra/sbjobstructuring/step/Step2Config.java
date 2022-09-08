package br.com.giulianabezerra.sbjobstructuring.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step2Config {
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step step2(@Qualifier("reader2") ItemReader<Integer> reader2, ItemWriter<Integer> writer) {
    return stepBuilderFactory
        .get("step2")
        .<Integer, Integer>chunk(5)
        .reader(reader2)
        .writer(writer)
        .build();
  }
}
