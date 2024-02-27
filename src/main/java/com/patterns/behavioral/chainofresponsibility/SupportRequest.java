package com.patterns.behavioral.chainofresponsibility;

/**
 * Request object - Contains support ticket details
 */
public class SupportRequest {
    private String issue;
    private int priority; // 1=Low, 2=Medium, 3=High, 4=Critical

    public SupportRequest(String issue, int priority) {
        this.issue = issue;
        this.priority = priority;
    }

    public String getIssue() {
        return issue;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "SupportRequest{issue='" + issue + "', priority=" + priority + "}";
    }
}
