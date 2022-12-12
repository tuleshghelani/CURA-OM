package org.om.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.TimeZone;

public class Temp2 {
    @JsonProperty("Period")
    String period;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddaHH.mm.ssz")
    @JsonProperty("Created Date")
Timestamp createdDate;

    @JsonProperty("Domain 1")
    String domain1;

    @JsonProperty("Domain 2")
    String domain2;

    @JsonProperty("Domain 3")
    String domain3;

    @JsonProperty("Domain 4")
    String domain4;

    @JsonProperty("Domain 5")
    String domain5;

    @JsonProperty("Lowest Domain")
    String lowestDomain;

    @JsonProperty("SnapShot Year")
    Integer snapShotYear;

    @JsonProperty("SnapShot Quarter")
    String snapShotQuarter;

    @JsonProperty("Domain ID")
    Integer domainID;

    @JsonProperty("Assessment ID")
    Integer assessmentID;

    @JsonProperty("Assessment_Name")
    String assessmentName;

    @JsonProperty("Action ID")
    Integer actionID;

    @JsonProperty("Entity Type ID")
    Integer entityTypeID;

    @JsonProperty("Action Name")
    String actionName;

    @JsonProperty("navurl_Action Name")
    String navurlActionName;

    @JsonProperty("Action Description")
    String actionDescription;

    @JsonProperty("Action Reference No.")
    String actionReferenceNo;

    @JsonProperty("Status for Reporting")
    String statusForReporting;

    @JsonProperty("Action Status")
    String actionStatus;

    @JsonProperty("As Action Owner I agree this action is complete and can be reported")
    String AsActionOwnerIAgreeThisActionIsCompleteAndCanBeReported;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDomain1() {
        return domain1;
    }

    public void setDomain1(String domain1) {
        this.domain1 = domain1;
    }

    public String getDomain2() {
        return domain2;
    }

    public void setDomain2(String domain2) {
        this.domain2 = domain2;
    }

    public String getDomain3() {
        return domain3;
    }

    public void setDomain3(String domain3) {
        this.domain3 = domain3;
    }

    public String getDomain4() {
        return domain4;
    }

    public void setDomain4(String domain4) {
        this.domain4 = domain4;
    }

    public String getDomain5() {
        return domain5;
    }

    public void setDomain5(String domain5) {
        this.domain5 = domain5;
    }

    public String getLowestDomain() {
        return lowestDomain;
    }

    public void setLowestDomain(String lowestDomain) {
        this.lowestDomain = lowestDomain;
    }

    public Integer getSnapShotYear() {
        return snapShotYear;
    }

    public void setSnapShotYear(Integer snapShotYear) {
        this.snapShotYear = snapShotYear;
    }

    public String getSnapShotQuarter() {
        return snapShotQuarter;
    }

    public void setSnapShotQuarter(String snapShotQuarter) {
        this.snapShotQuarter = snapShotQuarter;
    }

    public Integer getDomainID() {
        return domainID;
    }

    public void setDomainID(Integer domainID) {
        this.domainID = domainID;
    }

    public Integer getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(Integer assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public Integer getActionID() {
        return actionID;
    }

    public void setActionID(Integer actionID) {
        this.actionID = actionID;
    }

    public Integer getEntityTypeID() {
        return entityTypeID;
    }

    public void setEntityTypeID(Integer entityTypeID) {
        this.entityTypeID = entityTypeID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getNavurlActionName() {
        return navurlActionName;
    }

    public void setNavurlActionName(String navurlActionName) {
        this.navurlActionName = navurlActionName;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getActionReferenceNo() {
        return actionReferenceNo;
    }

    public void setActionReferenceNo(String actionReferenceNo) {
        this.actionReferenceNo = actionReferenceNo;
    }

    public String getStatusForReporting() {
        return statusForReporting;
    }

    public void setStatusForReporting(String statusForReporting) {
        this.statusForReporting = statusForReporting;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getAsActionOwnerIAgreeThisActionIsCompleteAndCanBeReported() {
        return AsActionOwnerIAgreeThisActionIsCompleteAndCanBeReported;
    }

    public void setAsActionOwnerIAgreeThisActionIsCompleteAndCanBeReported(String asActionOwnerIAgreeThisActionIsCompleteAndCanBeReported) {
        AsActionOwnerIAgreeThisActionIsCompleteAndCanBeReported = asActionOwnerIAgreeThisActionIsCompleteAndCanBeReported;
    }
}
