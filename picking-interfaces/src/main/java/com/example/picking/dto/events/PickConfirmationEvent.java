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
public class PickConfirmationEvent extends BaseEvent{
	private static String EVENT_NAME = "PickConfirmationEvent";
	PickDTO pickDTO;
	public PickConfirmationEvent(PickDTO pickDTO) {
		this(pickDTO, null);
	}
	public PickConfirmationEvent(PickDTO pickDTO, Map headerMap) {
		super(EVENT_NAME);
		this.pickDTO = pickDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", pickDTO.getBusName());
		this.addHeader("locnNbr", pickDTO.getLocnNbr());
		this.addHeader("OrderNbr", pickDTO.getOrderNbr());
		this.addHeader("company", pickDTO.getCompany());
		this.addHeader("division", pickDTO.getDivision());
		this.addHeader("busUnit", pickDTO.getBusUnit());
		this.addHeader("batchNbr", pickDTO.getBatchNbr());
	}
}
