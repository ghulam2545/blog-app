package com.ghulam.app;

import com.ghulam.app.enums.Category;
import com.ghulam.app.model.Blog;
import com.ghulam.app.repository.BlogRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ServerApplication implements ApplicationRunner {

	private final BlogRepository blogRepository;

	public ServerApplication(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		final String brief = """
				Blob stands for Binary Large Object, which is a type of data that stores binary data. BLOBs can be complex files\s
				like images or videos, and can be up to 2,147,483,647 characters long...
				""";

		final String content = """
				<h1>Familiar. Fully-featured. Mobile optimized.</h1>
				<p>With an open source Core, uncomplicated low-code plug-in structure and additional Premium add-ons, TinyMCE scales with your app as you grow. That&rsquo;s why it&rsquo;s the WYSIWYG editor-of-choice for 1.5M+ developers when they need to build and ship products faster.</p>
				<p><img style="float: right;" role="presentation" src="images/illustrations/spot/tiny/illustration-spot-tiny-images.svg" alt="TinyMCE demo image" width="316">Use TinyMCE as:</p>
				<ul>
				<li>A <strong>basic</strong> editor</li>
				<li>An advanced 📝 editor</li>
				<li>An AI-powered 🪄✨ editor</li>
				<li>A {{template-based}} editor</li>
				<li>A totally <span class="highlight"><code>&lt;customized&gt;</code></span> editor</li>
				</ul>
				<h2>Play with this demo to see how it works</h2>
				""";


		List<Blog> blogs = List.of(
				new Blog(null, "The Power of Data Analytics", brief, content,  "https://example.com/image1.jpg", "John Doe", Category.BUSINESS, LocalDate.now(), 37),
				new Blog(null, "Exploring the World of Sports", brief, content,  "https://example.com/image2.jpg", "Jane Smith", Category.SPORT, LocalDate.now(), 45),
				new Blog(null, "The Latest in Technological Advancements", brief, content,  "https://example.com/image3.jpg", "Alex Jones", Category.TECHNOLOGY, LocalDate.now(), 23),
				new Blog(null, "Finance Strategies for Success", brief, content,  "https://example.com/image4.jpg", "Emily Wong", Category.BUSINESS, LocalDate.now(), 56),
				new Blog(null, "Healthy Lifestyle and Fitness Tips", brief, content,  "https://example.com/image5.jpg", "Michael Smith", Category.SPORT, LocalDate.now(), 78)
		);

		blogRepository.saveAll(blogs);
	}
}
