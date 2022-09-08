package br.com.giulianabezerra.sbjobstructuring;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job job() {
    return jobBuilderFactory
        .get("job")
        .start(step1())
        .next(step2())
        .build();
  }

  public Step step1() {
    return stepBuilderFactory
        .get("step1")
        .<Integer, Integer>chunk(5)
        .reader(reader1())
        .writer(writer())
        .build();
  }

  public Step step2() {
    return stepBuilderFactory
        .get("step2")
        .<Integer, Integer>chunk(5)
        .reader(reader2())
        .writer(writer())
        .build();
  }

  public ItemReader<Integer> reader1() {
    return new ListItemReader<>(Arrays.asList(1, 2, 3, 4, 5));
  }

  public ItemReader<Integer> reader2() {
    return new ListItemReader<>(Arrays.asList(6, 7, 8, 9, 10));
  }

  public ItemWriter<Integer> writer() {
    return System.out::println;
  }
}
