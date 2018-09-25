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
public class PicklistCreatedEvent extends BaseEvent{
	private static String EVENT_NAME = "PicklistCreatedEvent";
	PicklistDTO picklistDTO;
	public PicklistCreatedEvent(PicklistDTO picklistDTO) {
		this(picklistDTO, null);
	}
	public PicklistCreatedEvent(PicklistDTO picklistDTO,Map headerMap) {
		super(EVENT_NAME);
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
