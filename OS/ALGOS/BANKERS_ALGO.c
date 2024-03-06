#include <stdio.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int available[MAX_RESOURCES];
int maximum[MAX_PROCESSES][MAX_RESOURCES];
int allocation[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int n, m; // n = number of processes, m = number of resources

void initialize() {
    // Initialize the available resources, maximum, allocation, and need matrices
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    printf("Enter the number of resources: ");
    scanf("%d", &m);

    printf("Enter the available resources:\n");
    for (int i = 0; i < m; i++) {
        scanf("%d", &available[i]);
    }

    printf("Enter the maximum demand of each process:\n");
    for (int i = 0; i < n; i++) {
        printf("For process %d: ", i);
        for (int j = 0; j < m; j++) {
            scanf("%d", &maximum[i][j]);
        }
    }

    printf("Enter the allocation of resources for each process:\n");
    for (int i = 0; i < n; i++) {
        printf("For process %d: ", i);
        for (int j = 0; j < m; j++) {
            scanf("%d", &allocation[i][j]);
            need[i][j] = maximum[i][j] - allocation[i][j];
        }
    }
}

int requestResources(int process, int request[]) {
    // Check if the request can be granted
    for (int i = 0; i < m; i++) {
        if (request[i] > need[process][i] || request[i] > available[i]) {
            return 0; // Request cannot be granted
        }
    }

    // Try to allocate resources
    for (int i = 0; i < m; i++) {
        available[i] -= request[i];
        allocation[process][i] += request[i];
        need[process][i] -= request[i];
    }

    // Check if the system is in a safe state
    if (isSafe()) {
        return 1; // Request granted
    } else {
        // Rollback if the system is not in a safe state
        for (int i = 0; i < m; i++) {
            available[i] += request[i];
            allocation[process][i] -= request[i];
            need[process][i] += request[i];
        }
        return 0; // Request denied
    }
}

int isSafe() {
    int work[MAX_RESOURCES];
    int finish[MAX_PROCESSES] = {0}; // Initially, no process has finished

    // Initialize work to available
    for (int i = 0; i < m; i++) {
        work[i] = available[i];
    }

    // Check if a process can finish and release resources
    for (int i = 0; i < n; i++) {
        if (!finish[i]) {
            int canFinish = 1;
            for (int j = 0; j < m; j++) {
                if (need[i][j] > work[j]) {
                    canFinish = 0;
                    break;
                }
            }

            if (canFinish) {
                // Release resources
                for (int j = 0; j < m; j++) {
                    work[j] += allocation[i][j];
                }
                finish[i] = 1;
                i = -1; // Restart the loop to check for new finishable processes
            }
        }
    }

    // If all processes finish, the system is in a safe state
    for (int i = 0; i < n; i++) {
        if (!finish[i]) {
            return 0; // Not in a safe state
        }
    }

    return 1; // Safe state
}

int main() {
    initialize();

    int process;
    int request[MAX_RESOURCES];

    printf("Enter the process making the request: ");
    scanf("%d", &process);

    printf("Enter the request for resources:\n");
    for (int i = 0; i < m; i++) {
        scanf("%d", &request[i]);
    }

    if (requestResources(process, request)) {
        printf("Request granted. System is in a safe state.\n");
    } else {
        printf("Request denied. System is not in a safe state.\n");
    }

    return 0;
}
