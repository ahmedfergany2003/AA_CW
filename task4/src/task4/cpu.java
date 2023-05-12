package task4;
import java.util.*;
public class cpu {
    // Inner class to represent a job
    static class Job {
        int priority;
        int duration;
        String name;
        public Job(String name, int priority, int duration) {
            this.name = name;
            this.priority = priority;
            this.duration = duration;}}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Sample input - create two jobs and add them to a list
        Job job1 = new Job("Job1", 1, 10);
        Job job2 = new Job("Job2", 2, 5);
        List<Job> jobs = new ArrayList<>(Arrays.asList(job1, job2));
        // Prompt the user to choose a scheduling algorithm
        System.out.println("Choose a scheduling algorithm:");
        System.out.println("1. First Come First Served");
        System.out.println("2. Highest priority scheduling");
        System.out.println("3. Shortest Remaining Time First");

        int choice = scanner.nextInt();
        // Execute the chosen scheduling algorithm
        switch (choice) {
            case 1:
                firstComeFirstServed(jobs);
                break;
            case 2:
                highestPriorityScheduling(jobs);
                break;
            case 3:
                shortestRemainingTimeFirst(jobs);
                break;
            default:
                System.out.println("Invalid choice");
                break;}}
    // First come first served scheduling algorithm
    public static void firstComeFirstServed(List<Job> jobs) {
        int time = 0;
        while (!jobs.isEmpty()) {
            // Get the first job in the list
            Job currentJob = jobs.get(0);
            System.out.println("Time " + time + ": Running " + currentJob.name);
            currentJob.duration--;
            if (currentJob.duration == 0) {
                // If the job is done, remove it from the list
                jobs.remove(0);}
            time++;}}
    // Highest priority scheduling algorithm
    public static void highestPriorityScheduling(List<Job> jobs) {
        int time = 0;
        while (!jobs.isEmpty()) {
            // Find the job with the highest priority
            Job currentJob = jobs.get(0);
            for (Job job : jobs) {
                if (job.priority > currentJob.priority) {
                    currentJob = job;}}
            System.out.println("Time " + time + ": Running " + currentJob.name);
            currentJob.duration--;
            if (currentJob.duration == 0) {
                // If the job is done, remove it from the list
                jobs.remove(currentJob);}
            time++;}}
    // Shortest remaining time first scheduling algorithm
    public static void shortestRemainingTimeFirst(List<Job> jobs) {
        int time = 0;
        while (!jobs.isEmpty()) {
            // Find the job with the shortest remaining time
            Job currentJob = jobs.get(0);
            for (Job job : jobs) {
                if (job.duration < currentJob.duration) {
                    currentJob = job;}}
            System.out.println("Time " + time + ": Running " + currentJob.name);
            currentJob.duration--;
            if (currentJob.duration == 0) {
                // If the job is done, remove it from the list
                jobs.remove(currentJob);}
            time++;}}}