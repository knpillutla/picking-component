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
public class PickCreatedEvent extends BaseEvent{
	private static String EVENT_NAME = "PickCreatedEvent";
	PickDTO pickDTO;
	public PickCreatedEvent(PickDTO PickDTO) {
		this(PickDTO, null);
	}
	public PickCreatedEvent(PickDTO PickDTO, Map headerMap) {
		super(EVENT_NAME);
		this.pickDTO = PickDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", this.pickDTO.getBusName());
		this.addHeader("locnNbr", this.pickDTO.getLocnNbr());
		this.addHeader("OrderNbr", this.pickDTO.getOrderNbr());
		this.addHeader("company", this.pickDTO.getCompany());
		this.addHeader("division", this.pickDTO.getDivision());
		this.addHeader("busUnit", this.pickDTO.getBusUnit());
	}
	
}
