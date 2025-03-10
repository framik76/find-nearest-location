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
  
  - **Task Management**: Create, update, and delete tasks.
  - **Categorization**: Organize tasks into categories for better management.
  - **Reminders**: Set deadlines and receive notifications.
  - **User Authentication**: Secure login and registration system.
  - **Responsive Design**: Works on both desktop and mobile devices.
  
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
   
  3. Start the development server:
     ```bash
     npm start
     ```
  
  ## 📘 Usage
  
  Provide examples of how to use your software:
  
  ```javascript
  const project = require("your-project");
  project.awesomeFunction();
  ```
  
  For instance, if you want to create a new task, you can do the following:
  
  ```
  const TaskManager = require('your-project');
  
  const taskManager = new TaskManager();
  taskManager.createTask('Finish report', 'Work', '2024-07-25');
  ```
  
  ## 📚 API
  
  This section documents the main functions and classes of the API. Each function is described with its parameters, return values, and examples for clarity.
  
  ### `createTask(title, category, dueDate)`
  
  Creates a new task with the specified details.
  
  | Parameter  | Type   | Description                                   |
  | ---------- | ------ | --------------------------------------------- |
  | `title`    | String | The title of the task.                        |
  | `category` | String | The category under which the task falls.      |
  | `dueDate`  | String | The due date of the task (YYYY-MM-DD format). |
  
  **Returns**: An object representing the created task.
  
  **Example**:
  
  ```javascript
  const TaskManager = require("your-project");
  
  const taskManager = new TaskManager();
  const newTask = taskManager.createTask("Finish report", "Work", "2024-07-25");
  console.log(newTask);
  ```
  
  ### `deleteTask(taskId)`
  
  Deletes the task with the specified ID.
  
  | Parameter | Type   | Description                   |
  | --------- | ------ | ----------------------------- |
  | `taskId`  | String | The ID of the task to delete. |
  
  **Returns**: A boolean indicating whether the deletion was successful.
  
  **Example**:
  
  ```javascript
  const taskId = "12345";
  const wasDeleted = taskManager.deleteTask(taskId);
  console.log(wasDeleted ? "Task deleted successfully!" : "Task not found.");
  ```
  
  ### `getTask(taskId)`
  
  Retrieves the details of a specific task.
  
  | Parameter | Type   | Description                     |
  | --------- | ------ | ------------------------------- |
  | `taskId`  | String | The ID of the task to retrieve. |
  
  **Returns**: An object containing the task details.
  
  **Example**:
  
  ```javascript
  const allTasks = taskManager.listTasks();
  console.log(allTasks);
  ```
  