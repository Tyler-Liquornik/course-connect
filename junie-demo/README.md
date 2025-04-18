# Smart Demo App

A polished, full-stack demo that showcases intelligent features in a simple user interface using Spring Web and Spring AI.

## Features

- **Text Summarizer**: AI-powered text summarization
- **Sentiment Analyzer**: AI-powered sentiment analysis
- **Persistence**: Stores analysis history in an in-memory H2 database
- **Web UI**: Modern, responsive interface built with React, TypeScript, Tailwind CSS, and shadcn-ui
- **API Documentation**: Auto-generated OpenAPI documentation

## Technologies Used

- Spring Boot 3.4.4
- Spring Web
- Spring AI (OpenAI integration)
- Spring Data JPA
- H2 Database
- React 18
- Next.js 14
- TypeScript
- Tailwind CSS
- shadcn-ui (Radix UI components)
- SpringDoc OpenAPI

## Getting Started

### Prerequisites

- Java 21 or higher
- Gradle
- Node.js 20 or higher (for React frontend)
- npm 10 or higher (for React frontend)

### Setup

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/smart-demo-app.git
   cd smart-demo-app
   ```

2. Set your OpenAI API key as an environment variable:
   ```
   # Windows
   set SPRING_AI_OPENAI_API_KEY=your-api-key-here

   # Linux/macOS
   export SPRING_AI_OPENAI_API_KEY=your-api-key-here
   ```

3. Build and run the application:
   ```
   # This will build both the Spring Boot backend and React frontend
   gradle bootRun
   ```

   For development of the React frontend separately:
   ```
   # Navigate to the frontend directory
   cd src/main/frontend

   # Install dependencies
   npm install

   # Start the development server
   npm run dev
   ```

4. Open your browser and navigate to:
   ```
   http://localhost:8080
   ```

## API Endpoints

### Text Summarizer

- **URL**: `/api/summarize`
- **Method**: POST
- **Request Body**:
  ```json
  {
    "text": "Text to summarize..."
  }
  ```
- **Response**:
  ```json
  {
    "summary": "Summarized text..."
  }
  ```

### Sentiment Analyzer

- **URL**: `/api/sentiment`
- **Method**: GET
- **Query Parameter**: `text`
- **Response**:
  ```json
  {
    "sentiment": "POSITIVE",
    "score": 0.82
  }
  ```

### Analysis History

- **URL**: `/api/history`
- **Method**: GET
- **Response**: List of recent analyses

## Frontend Architecture

The frontend is built with:

- **React 18**: A JavaScript library for building user interfaces
- **Next.js 14**: A React framework with server-side rendering capabilities
- **TypeScript**: A typed superset of JavaScript
- **Tailwind CSS**: A utility-first CSS framework
- **shadcn-ui**: A collection of reusable UI components built with Radix UI and Tailwind CSS

The frontend is organized as follows:

- `src/main/frontend/`: Root directory for the React application
  - `app/`: Next.js app directory
    - `page.tsx`: Main page component
    - `layout.tsx`: Root layout component
    - `globals.css`: Global styles
  - `components/`: UI components
    - `ui/`: shadcn-ui components
  - `lib/`: Utility functions

During the build process, the React application is built and the output is copied to the `src/main/resources/static` directory, which is then served by Spring Boot.

## Documentation

API documentation is available at:
```
http://localhost:8080/swagger-ui.html
```

## Database

The application uses an in-memory H2 database. The H2 console is available at:
```
http://localhost:8080/h2-console
```

Connection details:
- JDBC URL: `jdbc:h2:mem:demodb`
- Username: `sa`
- Password: (empty)

## Docker Support

A Dockerfile is included for containerization. The Docker build process will automatically build the React frontend as part of the Spring Boot application:

```
# Build the Docker image
docker build -t smart-demo-app .

# Run the Docker container
docker run -p 8080:8080 -e SPRING_AI_OPENAI_API_KEY=your-api-key-here smart-demo-app
```

Note: The Docker build process uses Gradle to build both the Spring Boot backend and the React frontend.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
