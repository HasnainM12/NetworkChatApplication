```markdown
# Multi-threaded Chat System

A Java chat application I built to understand networking concepts and multi-threading. It uses Socket Programming to enable real-time communication between multiple clients through a central server.

## Features

- Real-time messaging between multiple clients
- Username system with join/leave notifications
- Server handles multiple connections simultaneously
- Clean console-based interface

## Built With

- **Java**
- **Socket Programming**
- **Maven**
- **Multi-threading**

## Setup

### Build the project with Maven:
```bash
mvn clean install
```

### Run the server:
```bash
mvn exec:java -Dexec.mainClass=basicchat.App -Dexec.args=server
```

### Run a client (in a new terminal):
```bash
mvn exec:java -Dexec.mainClass=basicchat.App -Dexec.args=client
```

### Notes:
- Keep the server terminal running.
- Start a new terminal for each client.
- Enter your username when prompted.
- Type `exit` to quit the client.

## Future Plans

- Admin commands (kick/ban)
- Private messaging
- Chat rooms
- Message history
- Simple file sharing
- GUI interface
```
