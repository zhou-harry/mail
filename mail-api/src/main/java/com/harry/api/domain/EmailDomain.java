package com.harry.api.domain;

import java.util.List;
import java.util.Map;

public class EmailDomain {

    private String fromID;
    private String from;
    private List<String> to;
    private String subject;
    private String serviceID;
    private Map<String,Object> variables;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    @Override
    public String toString() {
        return "EmailDomain{" +
                "fromID='" + fromID + '\'' +
                ", from='" + from + '\'' +
                ", to=" + to +
                ", subject='" + subject + '\'' +
                ", serviceID='" + serviceID + '\'' +
                ", variables=" + variables +
                '}';
    }
}
