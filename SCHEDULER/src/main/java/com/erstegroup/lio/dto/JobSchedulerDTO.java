package com.erstegroup.lio.dto;

import java.util.List;

public class JobSchedulerDTO {

	private String jobGroupName;
	private String jobName;
	private String dependentjobName;
	private String isCritical;
	private String isSkip;
	private List<String> scheduleOn;
	private String scheduleAt;
	private String inboundQueue;
	private String outboundQueue;
	private String jobGroupId;
	private String requestFor;

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDependentjobName() {
		return dependentjobName;
	}

	public void setDependentjobName(String dependentjobName) {
		this.dependentjobName = dependentjobName;
	}

	public String getIsCritical() {
		return isCritical;
	}

	public void setIsCritical(String isCritical) {
		this.isCritical = isCritical;
	}

	public String getIsSkip() {
		return isSkip;
	}

	public void setIsSkip(String isSkip) {
		this.isSkip = isSkip;
	}

	public List<String> getScheduleOn() {
		return scheduleOn;
	}

	public void setScheduleOn(List<String> scheduleOn) {
		this.scheduleOn = scheduleOn;
	}

	public String getScheduleAt() {
		return scheduleAt;
	}

	public void setScheduleAt(String scheduleAt) {
		this.scheduleAt = scheduleAt;
	}

	public String getInboundQueue() {
		return inboundQueue;
	}

	public void setInboundQueue(String inboundQueue) {
		this.inboundQueue = inboundQueue;
	}

	public String getOutboundQueue() {
		return outboundQueue;
	}

	public void setOutboundQueue(String outboundQueue) {
		this.outboundQueue = outboundQueue;
	}

	public String getJobGroupId() {
		return jobGroupId;
	}

	public void setJobGroupId(String jobGroupId) {
		this.jobGroupId = jobGroupId;
	}

	public String getRequestFor() {
		return requestFor;
	}

	public void setRequestFor(String requestFor) {
		this.requestFor = requestFor;
	}
	
}
