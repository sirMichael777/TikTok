# TokTik ReadMe

## Overview
TokTik is a Java-based social media platform inspired by TikTok, implementing core functionalities similar to the popular video-sharing app. Users can create accounts, post videos, view profile descriptions, list accounts, delete accounts, display posts, add new posts, load actions from files, and exit the application.

## Project Structure
The project comprises several Java classes organized as follows:
- `Account.java`: Represents user accounts, offering methods for creation, description retrieval, and comparison.
- `BinaryTree.java`: Defines a binary search tree for storing accounts, featuring methods for insertion, deletion, search, traversal, and size retrieval.
- `Menu.java`: Implements a GUI menu for user interaction, providing options for various actions.
- `Node.java`: Defines the node structure for the binary search tree.
- `Post.java`: Represents user posts, including video content, titles, and likes.
- `TokTik.java`: Contains the main method to run the application and initialize the menu.
- `TokTikTree.java`: Creates and manages a binary search tree to store user accounts.
- `Validating.java`: Provides methods for validating user inputs, such as account names, descriptions, titles, videos, and file names.

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
To run the TokTik application:
1. Compile all Java files in the project.
2. Run the `TokTik.java` file to initialize the GUI menu.
3. Follow the prompts in the menu to perform various actions.

## Important Notes
- **Account Names**: Usernames must be unique and cannot contain spaces.
- **File Loading**: Ensure the file format is correct (.txt extension) and follows the specified action format when loading actions from a file.

## Contributors
- **Michael Maseko**: Lead developer responsible for designing and implementing the TokTik application.

## Contacts
For any questions or concerns regarding this project, please contact Michael Maseko at michaelcmcmaseko@gmail.com

## Dependencies
- Java 8 or higher
- Swing (for GUI components)

## Future Improvements
- Implement user authentication and security features to enhance account protection.
- Enhance the GUI with more intuitive design and additional features inspired by TikTok's interface.
- Integrate multimedia capabilities for viewing and posting videos directly within the application.
