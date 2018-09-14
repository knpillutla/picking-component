package com.example.picking.dto.events;

import com.example.picking.dto.requests.PickRequest;

public class PickConfirmationFailureEvent {
	public PickRequest pickReq;
	public String errorMsg;
	
	public PickConfirmationFailureEvent(PickRequest pickReq, String errorMsg) {
		this.pickReq = pickReq;
		this.errorMsg = errorMsg;
	}

}
