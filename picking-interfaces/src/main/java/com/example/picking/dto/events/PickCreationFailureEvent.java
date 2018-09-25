package com.example.picking.dto.events;

import java.util.Map;

import com.example.picking.dto.requests.PickCreationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class PickCreationFailureEvent extends ExceptionEvent{
	private static String EVENT_NAME = "PickCreationFailureEvent";
	PickCreationRequestDTO pickCreationReq;
	public PickCreationFailureEvent(PickCreationRequestDTO pickCreationReq, String errorMsg, Exception exceptionObj) {
		this(pickCreationReq, null, errorMsg, exceptionObj);
	}
	public PickCreationFailureEvent(PickCreationRequestDTO pickCreationReq, Map headerMap, String errorMsg, Exception exceptionObj) {
		super(EVENT_NAME, errorMsg, exceptionObj);
		this.pickCreationReq = pickCreationReq;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", this.pickCreationReq.getBusName());
		this.addHeader("locnNbr", this.pickCreationReq.getLocnNbr());
		this.addHeader("OrderNbr", this.pickCreationReq.getOrderNbr());
		this.addHeader("company", this.pickCreationReq.getCompany());
		this.addHeader("division", this.pickCreationReq.getDivision());
		this.addHeader("busUnit", this.pickCreationReq.getBusUnit());
	}
	
}
