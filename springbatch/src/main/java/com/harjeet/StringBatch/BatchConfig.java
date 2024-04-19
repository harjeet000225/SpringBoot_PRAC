package com.harjeet.StringBatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
	
	@Autowired
	private JobRepository jobRep;
	
	@Autowired
	private PlatformTransactionManager transmanager;
	
	@Bean
	public Job job() {
		return new JobBuilder("job-1",jobRep).start(step()).listener(listener()).build();
		//return null;
	}
	
	@Bean
	public Step step() {
		StepBuilder stepbuilder= new StepBuilder("step-1", jobRep);
		return stepbuilder.<String,String>chunk(3,transmanager).reader(reader()).processor(processor()).writer(writer()).build();
	}

	@Bean
	public Reader reader() {
		return new Reader();
	}
	
	@Bean
	public Writer writer() {
	 return new Writer();
	}
	
	
	@Bean
	public Processor processor() {
		return new Processor();
	}
	
	@Bean
	public MyJobListener listener() {
		return new MyJobListener();
	}
}

