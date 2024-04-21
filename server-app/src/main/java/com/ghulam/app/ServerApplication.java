package com.ghulam.app;

import com.ghulam.app.enums.Category;
import com.ghulam.app.model.Blog;
import com.ghulam.app.model.User;
import com.ghulam.app.repository.BlogRepository;
import com.ghulam.app.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ServerApplication implements ApplicationRunner {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public ServerApplication(BlogRepository blogRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final String brief = """
                 Isaac Newton: 17th-century physicist, mathematician, and astronomer. Known for laws of motion, universal\s
                 gravitation, and calculus. Pioneering figure in scientific revolution.
                \s""";

        final String content = """
                <h1><span style="color: rgb(51, 51, 51);">Sir Isaac Newton: A Scientific Giant</span></h1>
                    <p><span style="color: rgb(102, 102, 102);">Explore the life and achievements of one of history&#39;s greatest
                            scientists.</span></p>
                    <p></p>
                    <h2><span style="color: rgb(51, 51, 51);">Early Life and Education</span></h2>
                    <p><span style="color: rgb(102, 102, 102);">Sir Isaac Newton was born on January 4, 1643, in Woolsthorpe, England.
                            Growing up on his family&#39;s farm, Newton displayed an early aptitude for mechanics and mathematics. He
                            attended Cambridge University, where he studied mathematics and natural philosophy.</span></p>
                    <p><span style="color: rgb(0, 0, 0);"><img src="https://source.unsplash.com/600x300/?book" alt="Birthplace of
                                Sir Isaac Newton" height="300" width="600"></span></p>
                    <h2></h2>
                    <h2><span style="color: rgb(51, 51, 51);">The Principia</span></h2>
                    <p><span style="color: rgb(102, 102, 102);">Newton&#39;s magnum opus, </span><em style="color: rgb(102, 102,
                            102);">Philosophiæ Naturalis Principia Mathematica</em><span style="color: rgb(102, 102, 102);">,
                            published in 1687, laid the groundwork for classical mechanics. In the Principia, Newton formulated his
                            three laws of motion and the law of universal gravitation, which explained the motion of celestial
                            bodies.</span></p>
                    <p><span style="color: rgb(102, 102, 102);">Newton&#39;s revolutionary work provided a unified framework for
                            understanding the physical world, setting the stage for centuries of scientific progress.</span></p>
                    <p><span style="color: rgb(0, 0, 0);"><img src="https://source.unsplash.com/600x300/?book" alt="Title page of
                                Philosophiæ Naturalis Principia Mathematica" height="300" width="600"></span></p>
                    <p></p>
                    <h2><span style="color: rgb(51, 51, 51);">Legacy and Impact</span></h2>
                    <p><span style="color: rgb(102, 102, 102);">Newton&#39;s contributions to science extended beyond physics. He made
                            significant advances in optics, mathematics, and astronomy, revolutionizing our understanding of light,
                            calculus, and the cosmos.</span></p>
                    <p><span style="color: rgb(102, 102, 102);">His rigorous approach to inquiry and his emphasis on empirical
                            evidence paved the way for modern scientific methodology. Newton&#39;s legacy continues to inspire
                            scientists and thinkers around the world.</span></p>
                    <ul>
                        <li><span style="color: rgb(102, 102, 102);">An </span><strong style="color: rgb(102, 102,
                                102);">innovative</strong><span style="color: rgb(102, 102, 102);"> thinker</span></li>
                        <li><span style="color: rgb(102, 102, 102);">A visionary 🌟 scientist</span></li>
                        <li><span style="color: rgb(102, 102, 102);">A pioneer of modern 🌌 cosmology</span></li>
                        <li><span style="color: rgb(102, 102, 102);">A {{trailblazer}} in mathematics</span></li>
                        <li><span style="color: rgb(102, 102, 102);">An indomitable </span><span style="background-color: rgb(241,
                                241, 241); color: rgb(241, 241, 241);">&lt;genius&gt;</span></li>
                    </ul>
                    <p><span style="color: rgb(102, 102, 102);">For more information on Sir Isaac Newton, visit </span><a
                            href="https://en.wikipedia.org/wiki/Isaac_Newton" rel="noopener noreferrer" target="_blank"
                            style="color: rgb(0, 123, 255);">Wikipedia</a><span style="color: rgb(102, 102, 102);">.</span></p>
                    <p></p>
                """;

        List<Blog> blogs = List.of(
                new Blog("The Power of Data Analytics", brief, content, "https://example.com/image1.jpg", "John Doe", Category.BUSINESS, LocalDate.now(), 37),
                new Blog("Exploring the World of Sports", brief, content, "https://example.com/image2.jpg", "Jane Smith", Category.SPORT, LocalDate.now(), 45),
                new Blog("The Latest in Technological Advancements", brief, content, "https://example.com/image3.jpg", "Alex Jones", Category.TECHNOLOGY, LocalDate.now(), 23),
                new Blog("Finance Strategies for Success", brief, content, "https://example.com/image4.jpg", "Emily Wong", Category.BUSINESS, LocalDate.now(), 56),
                new Blog("Healthy Lifestyle and Fitness Tips", brief, content, "https://example.com/image5.jpg", "Michael Smith", Category.SPORT, LocalDate.now(), 78)
        );

        List<User> users = List.of(
                new User("string", "string@gmail.com", encoder.encode("string"), brief),
                new User("John Doe", "john123@gmail.com", encoder.encode("112233"), brief),
                new User("Jane Smith", "jane123@gmail.com", encoder.encode("112233"), brief),
                new User("Alex Jones", "alex@gmail.com", encoder.encode("123456"), brief),
                new User("Emily Wong", "emily@gmail.com", encoder.encode("123456"), brief)
        );

        blogRepository.saveAll(blogs);
        userRepository.saveAll(users);
    }
}
