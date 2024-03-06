#include <stdio.h>

struct Job {
    char id;
    int deadline;
    int profit;
};

int MaxD(struct Job jobs[], int n) {
    int Deadline = 0;
    for (int i = 0; i < n; i++) {
        if (jobs[i].deadline > Deadline) {
            Deadline = jobs[i].deadline;
        }
    }
    return Deadline;
}

void jobSequencing(struct Job jobs[], int n) {
    int Deadline = MaxD(jobs, n);
    struct Job result[Deadline];

    for (int i = 0; i < Deadline; i++) {
        result[i].id = ' ';
        result[i].deadline = 0;
        result[i].profit = 0;
    }

    for (int i = 0; i < n; i++) {
        for (int j = jobs[i].deadline - 1; j >= 0; j--) {
            if (result[j].id == ' ') {
                result[j] = jobs[i];
                break;
            }
        }
    }

    int totalProfit = 0;

    printf("Job Sequence: ");
    for (int i = 0; i < Deadline; i++) {
        if (result[i].id != ' ') {
            printf("%c ", result[i].id);
            totalProfit += result[i].profit;
        }
    }

    printf("\nTotal Profit: %d\n", totalProfit);
}

int main() {
    int n;
    printf("Enter the number of jobs: ");
    scanf("%d", &n);
    struct Job jobs[n];

    for (int i = 0; i < n; i++) {
        printf("Enter job ID, deadline, and profit for job %d: ", i + 1);
        scanf(" %c %d %d", &jobs[i].id, &jobs[i].deadline, &jobs[i].profit);
    }
    jobSequencing(jobs, n);
    return 0;
}