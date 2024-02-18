# TokTik ReadMe

## Overview
TokTik is a Java-based social media platform inspired by TikTok, implementing core functionalities similar to the popular video-sharing app. Users can create accounts, post videos, view profile descriptions, list accounts, delete accounts, display posts, add new posts, load actions from files, and exit the application.

## Project Structure
The project comprises several Java classes organized as follows:
- **Account**: Represents user accounts, offering methods for creation, description retrieval, and comparison.
- **BinaryTree**: Defines a binary search tree for storing accounts, featuring methods for insertion, deletion, search, traversal, and size retrieval.
- **Menu**: Implements a graphical user interface (GUI) menu for user interaction, providing options for various actions.
- **Node**: Defines the node structure for the binary search tree.
- **Post**: Represents user posts, including video content, titles, and likes.
- **TokTik**: Contains the main method to run the application and initialize the menu.
- **TokTikTree**: Creates and manages a binary search tree to store user accounts.
- **Validating**: Provides methods for validating user inputs, such as account names, descriptions, titles, videos, and file names.

## Functionality
TokTik offers functionalities reminiscent of TikTok:
- **Account Management**: Users can create and delete accounts, each with a unique username and description.
- **Video Posting**: Users can post videos with titles and manage the number of likes on their posts.
- **Profile Viewing**: Users can view their own or other users' profile descriptions.
- **Account Listing**: All existing accounts can be listed for easy browsing.
- **Post Displaying**: Users can view all posts associated with a specific account.
- **Action Loading**: Actions can be loaded from a file for batch processing.
- **GUI Interface**: Interaction with the application is facilitated through a graphical user interface.

## Usage
### Linux Environment
To run the TokTik application on a Linux environment:
1. **Build the Project**: Open a terminal in the project directory and execute `make` to compile all Java files.
2. **Run the Application**: Execute `make run` to run the application. This will initialize the GUI menu for user interaction.

### Windows Environment
For Windows users, the traditional method for running Java applications can be used:
1. **Compile**: Open a command prompt in the project directory and compile the Java files using `javac`:
   ```
   javac TokTik.java
   ```
2. **Run the Application**: Execute the compiled `TokTik.class` file as the main class:
   ```
   java TokTik
   ```

## Developer Contact
For any inquiries or feedback regarding TokTik, please contact the developer at michaelcmcmaseko@gmail.com.
