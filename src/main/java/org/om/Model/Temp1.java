package org.om.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;


//@JsonIgnoreProperties
public class Temp1 {

    @JsonProperty("RegisterName")
    String RegisterName;

    @JsonProperty("QueryName")
    String QueryName;

    @JsonProperty("RegisterID")
    Integer RegisterID;

    @JsonProperty("QueryID")
    Integer QueryID;

    @JsonProperty("PublishAsAdhocSurvey")
    Integer PublishAsAdhocSurvey;

    @JsonProperty("isPagingEnabled")
    Boolean isPagingEnabled;

    public Temp1() {
    }

    public Temp1(String registerName, String queryName, Integer registerID, Integer queryID, Integer publishAsAdhocSurvey, Boolean isPagingEnabled) {
        RegisterName = registerName;
        QueryName = queryName;
        RegisterID = registerID;
        QueryID = queryID;
        PublishAsAdhocSurvey = publishAsAdhocSurvey;
        this.isPagingEnabled = isPagingEnabled;
    }

    public String getRegisterName() {
        return RegisterName;
    }

    public void setRegisterName(String registerName) {
        RegisterName = registerName;
    }

    public String getQueryName() {
        return QueryName;
    }

    public void setQueryName(String queryName) {
        QueryName = queryName;
    }

    public Integer getRegisterID() {
        return RegisterID;
    }

    public void setRegisterID(Integer registerID) {
        RegisterID = registerID;
    }

    public Integer getQueryID() {
        return QueryID;
    }

    public void setQueryID(Integer queryID) {
        QueryID = queryID;
    }

    public Integer getPublishAsAdhocSurvey() {
        return PublishAsAdhocSurvey;
    }

    public void setPublishAsAdhocSurvey(Integer publishAsAdhocSurvey) {
        PublishAsAdhocSurvey = publishAsAdhocSurvey;
    }

    public Boolean getPagingEnabled() {
        return isPagingEnabled;
    }

    public void setPagingEnabled(Boolean pagingEnabled) {
        isPagingEnabled = pagingEnabled;
    }

    @Override
    public String toString() {
        return "Temp1{" +
                "RegisterName='" + RegisterName + '\'' +
                ", QueryName='" + QueryName + '\'' +
                ", RegisterID=" + RegisterID +
                ", QueryID=" + QueryID +
                ", PublishAsAdhocSurvey=" + PublishAsAdhocSurvey +
                ", isPagingEnabled=" + isPagingEnabled +
                '}';
    }
}
