<div align="center">
    
  # find-nearest-location
  
  <img src="https://api.dicebear.com/9.x/icons/svg?seed=Midnight&backgroundColor[]&icon=lightbulb" height="100" alt="avatar" />
  
  [Overview](#🎯-overview) •
  [Features](#✨-features) •
  [Getting Started](#🚀-getting-started) •
  [Usage](#📘-usage) •
  [API](#📚-api)
  
  </div>
  
  ---
  
  ## 🎯 Overview
  
  A Springboot service that exposes api to add a location to redis and to get the nearest locations in a radious 
  
  ## ✨ Features
  
  - **Add location**: add a location with geographic coordinates.
  - **Get nearest locations**: Get the nearest locations in a radious ok km.
  
  ## 🚀 Getting Started
  
  To get a local copy up and running, follow these steps:
  
  ### Prerequisites
  
  Ensure you have the following installed:
  
  - Java
  - Maven
  - Git
  - Redis
  
  ### Installation
  
  1. Clone the repository:
  
     ```bash
     git clone https://github.com/framik76/find-nearest-location.git
     cd find-nearest-location
     ```
  
  2. Install Redis:
     Redis server

      ```
      docker run -d --name redis-stack-server -p 6379:6379 redis/redis-stack-server:latest
      ```

      Redis cli: su linux ubuntu tramite il comando

      ```
      sudo apt install redis-tools
      ```
   
  3. Create the package of the development server:
     ```bash
     mvn clean package
     ```
3. Run the development server:
   ```bash
   java -jar target/find-nearest-location-0.0.1-SNAPSHOT.jar
   ```
  
  ## 📘 Usage
  
   
  ## 📚 API
  
  This section documents the main functions and classes of the API. Each function is described with its parameters, return values, and examples for clarity.
  
  ### `POST /v1/api/locations`
  
Add a location
 
Request:
```bash
{
  "locationName": "Milano - via Vitruvio",
  "latitude": 45,98349324,
  "longitude": 9,8432234324
}
   ```
### `GET /v1/api/locations/nearest`

Get the nearest locations within a radious in km 

Request:
```bash
/v1/api/locations/nearest?latitude=45,32143&longitude=9,843424&km=10
   ```
     
