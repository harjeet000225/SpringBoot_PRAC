package com.harjeet.SpringReactive;

import static org.mockito.ArgumentMatchers.longThat;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.Flow.Subscriber;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringReactiveApplicationTests {

	@Test
	void testMono() {
	Mono<String> mono=Mono.just("data check");
	mono.log().map(data->data.toUpperCase())
	.subscribe(System.out::println);
	}
	
	
	@Test
	void testFlux() {
	Flux.just("check1","check2","check3")
	.log().map(data->data.toUpperCase())
	.subscribe(data->System.out.println(data));
	}
	
	
	@Test
	void testFlux2() throws InterruptedException {
	//Flux.just("MACKBOOK","IPHONE_2","IPHONE_1")
	Flux.fromIterable(Arrays.asList("macbook","dell","iphone"))
	//.delayElements(Duration.ofSeconds(2))
	.log()
	.map(data->data.toUpperCase())
	.subscribe(new org.reactivestreams.Subscriber<String>() {

		@Override
		public void onSubscribe(Subscription s) {
			// TODO Auto-generated method stub
			s.request(Long.MAX_VALUE);
			
		}

		@Override
		public void onNext(String t) {
			// TODO Auto-generated method stub
			System.out.println(t);
			
		}

		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onComplete() {
			// TODO Auto-generated method stub
			
		}
	});
	
	//Thread.sleep(200);
	}
}
