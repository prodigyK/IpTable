package com.prodigy.ipaddresses.model;


import javax.persistence.*;

@Entity
@Table(name = "log_changes_details")
public class LogChangesDetails extends BaseEntity{

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "previous_value")
    private String previousValue;

    @Column(name = "new_value")
    private String newValue;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "log_id")
    private LogChanges changes;

    public LogChangesDetails() {
    }

    public LogChangesDetails(String fieldName, String previousValue, String newValue) {
        this.fieldName = fieldName;
        this.previousValue = previousValue;
        this.newValue = newValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LogChanges getChanges() {
        return changes;
    }

    public void setChanges(LogChanges changes) {
        this.changes = changes;
    }
}
