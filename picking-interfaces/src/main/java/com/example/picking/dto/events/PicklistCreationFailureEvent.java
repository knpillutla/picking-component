package com.example.picking.dto.events;

import java.util.Map;

import com.example.picking.dto.responses.PicklistDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class PicklistCreationFailureEvent extends ExceptionEvent{
	private static String EVENT_NAME = "PicklistCreationFailureEvent";
	PicklistDTO picklistDTO;
	public PicklistCreationFailureEvent(PicklistDTO picklistDTO, String errorMsg, String exceptionObj) {
		this(picklistDTO, null, errorMsg, exceptionObj);
	}
	public PicklistCreationFailureEvent(PicklistDTO picklistDTO,Map headerMap,String errorMsg, String exceptionObj) {
		super(EVENT_NAME, errorMsg, exceptionObj);
		this.picklistDTO = picklistDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", picklistDTO.getBusName());
		this.addHeader("locnNbr", picklistDTO.getLocnNbr());
		this.addHeader("company", picklistDTO.getCompany());
		this.addHeader("division", picklistDTO.getDivision());
		this.addHeader("busUnit", picklistDTO.getBusUnit());
		this.addHeader("picklistNbr", picklistDTO.getId());
	}
}
