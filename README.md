# interview-tui-quote-garden-api

This repository contains a sample spring boot application, a REST API for quotes based on original API [QuoteGarden](https://github.com/pprathameshmore/QuoteGarden), in the context of the technical interview at TUI.

# Instructions to run the application #

This guide will walks you through the process running the application and mongodb server.

### What You Need

- IntelliJ IDEA
- Java 17 or later
- Gradle 8+
- MongoDB
- Download and unzip the source repository or clone it using Git

### Install and Launch MongoDB

With your project set up, you can now proceed to install and launch the MongoDB database

For other systems such as Redhat, Ubuntu, Debian, CentOS, and Windows, please refer to the instructions provided at https://docs.mongodb.org/manual/installation/.

After you have installed MongoDB, you can launch it in a console window by executing the MongoDB Compass.

Create a new database named `quote-garden-db` with a collection named `quote`

After creating and running the database, you can launch the application. The first time you run the application, it will make a request to the original API to retrieve data and populate the local database.

Congratulations! You have successfully set up a MongoDB server and run the application.


# API documentation #

The base part of the URI path for the API is `/tui/api/`

#### Search all item

```http
GET  /quotes/_all
```

- Request:
  - Body: none

- Response:
  - Success:
    - Status code: 200
    - Content-Type: application/json
    - Body example:
        ```json
        {
             [
                    {
                      "_id": "5eb17aadb69dc744b4e70d4a",
                      "quoteText": "Forty is the old age of youth, fifty is the youth of old age.",
                      "quoteAuthor": "Hosea Ballou",
                      "quoteGenre": "age",
                      "__v": 0
                    },
                    {
                      "_id": "5eb17aadb69dc744b4e70d33",
                      "quoteText": "Every man over forty is a scoundrel.",
                      "quoteAuthor": "George Bernard Shaw",
                      "quoteGenre": "age",
                      "__v": 0
                  },
                    ...
            ]
        }
    ```

#### Search a specific item by ID

```http
GET  /quotes
```

- Request:
  - Body: none
  - query params:
      - id

- Response:
  - Success:
    - Status code: 200
    - Content-Type: application/json
    - Body example:
   ```json
    {
         {
          "_id": "5eb17aadb69dc744b4e70d4a",
          "quoteText": "Forty is the old age of youth, fifty is the youth of old age.",
          "quoteAuthor": "Hosea Ballou",
          "quoteGenre": "age",
          "__v": 0
        }
    }
```
