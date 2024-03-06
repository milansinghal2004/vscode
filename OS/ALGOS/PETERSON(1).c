#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <fcntl.h>

#define FILE_NAME "shared.txt"

int main() {
    int parent_id = 0;

    while (true) {
        // Set flag to indicate that the parent wants to enter the critical section
        flag[parent_id] = true;
        turn = 1 - parent_id;

        // While the child process is in the critical section or wants to enter the critical section, wait
        while (flag[1 - parent_id] && turn == 1 - parent_id) {}

        // Enter the critical section (write to the pipe)
        // Open the file in write mode
        int fd[2];
        if (pipe(fd) == -1) {
            perror("pipe");
            exit(1);
        }

        // Fork a child process
        pid_t pid = fork();
        if (pid == -1) {
            perror("fork");
            exit(1);
        }

        if (pid == 0) { // Child process - reader
            // Close the write end of the pipe
            close(fd[1]);

            // Read from the pipe
            char buffer[1024];
            int bytes_read = read(fd[0], buffer, sizeof(buffer));
            if (bytes_read == -1) {
                perror("read");
                exit(1);
            }

            // Print the read data
            printf("Read data: %s\n", buffer);

            // Close the read end of the pipe
            close(fd[0]);

            exit(0);
        } else { // Parent process - writer
            // Close the read end of the pipe
            close(fd[0]);

            // Write to the pipe
            char data[] = "Hello from parent!";
            int bytes_written = write(fd[1], data, sizeof(data));
            if (bytes_written == -1) {
                perror("write");
                exit(1);
            }

            // Wait for the child process to finish
            wait(NULL);

            // Close the write end of the pipe
            close(fd[1]);
        }

        // Exit the critical section
        flag[parent_id] = false;
    }

    return 0;
}
