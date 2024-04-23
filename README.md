# blog-app
Welcome to Blog App, a fullstack web-based application designed for creating, managing, and sharing blogs. This README provides a comprehensive overview of the project structure, features, technologies used, setup instructions and more.

### Features
Blog App offers a comprehensive set of features for a seamless blogging experience:

- **Home Page:** Visually appealing landing page showcasing recently added blogs.
- **Add Blogs:** Intuitive interface for effortless blog creation with a rich-text editor.
- **View All Blogs:** Browse list of available blogs for easy exploration.
- **View Single Blog:** Detailed view of each blog post with author details, publication date, and tags.
- **User Profile:** Dedicated section to manage account details and profile picture.
- **JWT Authentication:** Secure signup and login using JSON Web Tokens (JWT) for protected access.
- **WYSIWYG Editor:** Integrated editor for formatting text, adding images, and embedding media.
- **Search Functionality:** Advanced search capabilities for finding blogs by topics.
- **Swagger-UI Integration:** Interactive API documentation for easy exploration and testing.

### Project Structure
The project is organized into two main directories:

- **server-app:** Contains the backend code written in Java using Spring Boot, Security framework.
- **client-app:** Houses the frontend code implemented in Angular with Bootstrap for styling.

### Tech Stack
- Java
- Spring Boot
- Spring Security
- Angular
- Bootstrap

### Getting Started
To get started with Blog App, follow these simple steps:

- Clone the repository to your local machine.
- Navigate to the server-app directory and follow the setup instructions provided in the README file to run the backend server.
- Navigate to the client-app directory and follow the setup instructions provided in the README file to run the frontend application.
- Access the application through your preferred web browser and start exploring the exciting features of Blog App.

### Building and Running the Project
To build and run the project locally, follow these steps:

**Backend (server-app)**
```
./mvnw clean install
./mvnw spring-boot:run
```

**Frontend (client-app)**
```
npm install
ng serve
```

### Todos
The project is continuously evolving, with planned enhancements aimed at further enhancing the user experience:

- **Media File Handling:** Implement functionality to upload and manage images, videos, and other media files seamlessly.
- **Comments and Likes Section:** Enhance user engagement by adding features to interact with blogs through comments and likes.
- **User Dashboard:** Develop a personalized dashboard for users to manage their blogs, comments, settings, and subscriptions efficiently.
- **Performance Optimization:** Continuously optimize the application for better speed, responsiveness, and scalability, ensuring a smooth user experience under varying load conditions.
