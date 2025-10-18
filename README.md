💬 Java Chat Application (Client-Server with GUI)

This project is a real-time chat application built using Java. It enables two or more users to communicate over a network using Socket Programming and features a Graphical User Interface (GUI) for an enhanced user experience.

🚀 Features

Client-Server Communication: Uses Java Sockets to establish real-time message exchange.

Graphical Interface: User-friendly GUI built with Java Swing/AWT for both client and server.

Multi-user Support: Multiple clients can connect and chat with the server.

Instant Messaging: Messages are transmitted instantly through input/output streams.

Error Handling: Built-in exception handling for network and I/O errors.

🧩 Project Structure
📂 JavaChatApp

 ├── clientchat2.java         # Client-side code

 ├── serverchat2.java         # Server-side code

 ├── gui.class                # GUI compiled class
 
 ├── gui2.class               # Alternative GUI version

 ├── gui$Rec.class            # GUI helper class
 
 ├── gui$gui1.class           # GUI helper class
 
 ├── gui2$Recv.class          # GUI message receiver class

 ├── proh.class               # Additional process/helper class

 └── README.md                # Project documentation

⚙️ How It Works

Server Setup:

Run serverchat2.java.

The server listens for incoming client connections using sockets.

Client Connection:

Run clientchat2.java.

Enter the server’s IP address and connect to the chat session.

Chat:

Both client and server can send and receive messages in real-time through the GUI.
