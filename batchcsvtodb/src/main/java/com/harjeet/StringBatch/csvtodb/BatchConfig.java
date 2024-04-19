package com.harjeet.StringBatch.csvtodb;

import java.util.concurrent.Flow.Processor;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	private JobRepository jobRep;
	
	@Autowired
	private PlatformTransactionManager transmanager;
	
	@Bean
	public Job job() {
		System.out.println("job started ");
		return new JobBuilder("job-1",jobRep).flow(step()).end().build();
	}
	
	@Bean
	public Step step() {
		System.out.println("step started ");
		StepBuilder stepbuilder= new StepBuilder("step-1", jobRep);
		return stepbuilder.<Product,Product>chunk(4,transmanager).reader(reader()).processor(processor()).writer(writer()).build();
	}


	
	@Bean
	public ItemReader<Product> reader(){
		System.out.println("inside reader");
		FlatFileItemReader<Product> reader=new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("product.csv"));
		//mapper and tokennizer
		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","name","description","price");
		//bean wrapper
		BeanWrapperFieldSetMapper<Product> fieldsetmapper = new BeanWrapperFieldSetMapper<>();
		fieldsetmapper.setTargetType(Product.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldsetmapper);
		System.out.println(lineMapper);
		//reader to mapper
		reader.setLineMapper(lineMapper);
		return reader;
		
	}
	
	@Bean
	public ItemProcessor<Product, Product> processor(){
		System.out.println("inside processor");
		/*return (p)->{
			p.setPrice(p.getPrice()-p.getPrice()*10/100);
			*return p;
		};
		*/
		return null;
	}
	
	@Bean
	public ItemWriter<Product> writer(){
		System.out.println("inside writer");
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(datasource);
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		writer.setSql("INSERT INTO PRODUCT(ID,NAME,DESCRIPTION,PRICE) VALUES (:id,:name,:description,:price)");
		return writer;
	}
}

