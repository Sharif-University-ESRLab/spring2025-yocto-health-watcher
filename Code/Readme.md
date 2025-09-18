
# Code


## Raspberry Pi UART Watcher


### Overview:

`raspberry-pi-uart-watcher` is a lightweight utility designed for Raspberry Pi systems to monitor and detect error logs originating from the UART interface. It continuously listens to UART communications and identifies any anomalies or errors, providing real-time alerts for prompt attention.

### Key Features:

* **Real-Time Error Detection:** Monitors UART traffic and identifies error logs as they occur.
* **Web Interface:** Access error logs via a simple web interface by navigating to the Raspberry Pi's IP address in a browser.
* **Easy Deployment:** Deploy the application with a single command using the provided `Makefile`.

### code description:

#### 1- `main.go` – UART Monitoring Logic

The `main.go` file is responsible for initializing and managing the UART interface on the Raspberry Pi. Key functionalities include:

* **UART Initialization**: Configures the UART interface for communication.
* **Data Capture**: Continuously reads incoming data from the UART interface.
* **Error Detection**: Analyzes the incoming data for any anomalies or errors.
* **Logging**: Records the captured data and detected errors for further analysis.

This file is essential for the core functionality of the UART watcher, ensuring that all incoming data is monitored and logged appropriately.

---

#### 2- `http.go` – Web Interface for Monitoring

The `http.go` file sets up a web server that provides a user-friendly interface for monitoring the captured UART data and logs. Key features include:

* **Web Server Initialization**: Starts an HTTP server to serve the monitoring interface.
* **Data Display**: Presents the captured data and detected errors in a readable format.
* **Real-Time Updates**: Automatically refreshes the displayed data to reflect the latest information.

This file enhances the usability of the project by allowing users to monitor UART communication through a web browser.

---

### Installation & Usage:

1. Customize network environment variables in the `Makefile`.

2. Deploy the application by running:

   ```bash
   make deploy
   ```

3. View error logs by executing:

   ```bash
   make errors
   ```

   Alternatively, open your Raspberry Pi's IP address in a web browser to access the logs.

