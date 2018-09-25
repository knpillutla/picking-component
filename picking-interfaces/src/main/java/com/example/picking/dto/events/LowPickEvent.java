package com.example.picking.dto.events;

import java.util.Map;

import com.example.picking.dto.responses.PickDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class LowPickEvent extends BaseEvent{
	private static String EVENT_NAME = "LowPickEvent";
	String busName;
	Integer locnNbr;
	String company;
	String division;
	String busUnit;
	String area;
	String zone;
	String aisle;
	String workArea;
	String workZone;
	String workAisle;
	String userId;
	public LowPickEvent(String busName, Integer locnNbr, String busUnit, String company, String division, String area, String zone, String userId) {
		this.busName = busName;
		this.locnNbr = locnNbr;
		this.busUnit = busUnit;
		this.company = company;
		this.division = division;
		this.area = area;
		this.zone = zone;
		this.userId = userId;
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", this.getBusName());
		this.addHeader("locnNbr", this.getLocnNbr());
		this.addHeader("company", this.getCompany());
		this.addHeader("division", this.getDivision());
		this.addHeader("busUnit", this.getBusUnit());
	}
	public LowPickEvent(Map headerMap) {
		super(EVENT_NAME);
		if(headerMap != null)
			this.setHeaderMap(headerMap);
	}
	
}
