package com.example.picking.dto.events;

import com.example.picking.dto.requests.PickCreationRequest;
import com.example.picking.dto.requests.PickRequest;

public class PickCreationFailureEvent {
	public PickCreationRequest pickReq;
	public String errorMsg;
	
	public PickCreationFailureEvent(PickCreationRequest pickReq, String errorMsg) {
		this.pickReq = pickReq;
		this.errorMsg = errorMsg;
	}

}
