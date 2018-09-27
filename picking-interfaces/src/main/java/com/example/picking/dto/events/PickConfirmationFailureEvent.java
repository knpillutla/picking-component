package com.example.picking.dto.events;

import java.util.Map;

import com.example.picking.dto.requests.PickConfirmRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class PickConfirmationFailureEvent extends ExceptionEvent{
	private static String EVENT_NAME = "PickConfirmationFailureEvent";
	String orderNbr;
	Long orderId;
	Long pickListId;
	PickConfirmRequestDTO pickConfirmRequestDTO;
	public PickConfirmationFailureEvent(PickConfirmRequestDTO pickConfirmRequestDTO, String errorMsg, Exception exceptionObj) {
		this(pickConfirmRequestDTO, null, errorMsg, exceptionObj);
	}
	public PickConfirmationFailureEvent(PickConfirmRequestDTO pickConfirmRequestDTO, Map headerMap, String errorMsg, Exception exceptionObj) {
		super(EVENT_NAME,errorMsg, exceptionObj);
		this.pickConfirmRequestDTO = pickConfirmRequestDTO;
		if(headerMap != null)
			this.setHeaderMap(headerMap);
		this.addHeader("eventName", getEventName());
		this.addHeader("busName", pickConfirmRequestDTO.getBusName());
		this.addHeader("locnNbr", pickConfirmRequestDTO.getLocnNbr());
		this.addHeader("OrderNbr", pickConfirmRequestDTO.getOrderNbr());
		this.addHeader("company", pickConfirmRequestDTO.getCompany());
		this.addHeader("division", pickConfirmRequestDTO.getDivision());
		this.addHeader("busUnit", pickConfirmRequestDTO.getBusUnit());
		this.addHeader("batchNbr", pickConfirmRequestDTO.getBatchNbr());
		//this.addHeader("orderId", pickConfirmRequestDTO.getOrderId());
	}
}
