package edu.mum.cs544;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
	@Autowired
	private RabbitTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		String queue = "book";
		Book msg = new Book();
		msg.setAuthor("author");
		msg.setTitle("title");
		msg.setISBN("978-0-306-40615-7");
		msg.setPrice(2);
		template.convertAndSend(queue, msg, m -> {
			m.getMessageProperties().getHeaders().put("operation", "add"); 
			return m; 
		});
		System.out.println("Sent: " + msg +" to: " + queue);

		// delete book with id = 1
//		template.convertAndSend(queue, 1);

//		msg.setId(2);
//		msg.setAuthor("updated");
//		template.convertAndSend(queue, msg, m -> {
//			m.getMessageProperties().getHeaders().put("operation", "update");
//			return m;
//		});

	}
}
