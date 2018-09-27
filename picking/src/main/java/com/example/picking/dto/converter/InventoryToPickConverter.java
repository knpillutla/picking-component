package com.example.picking.dto.converter;

import org.springframework.stereotype.Component;

import com.example.inventory.dto.events.InventoryAllocatedEvent;
import com.example.picking.dto.requests.PickCreationRequestDTO;

@Component
public class InventoryToPickConverter {
	public static PickCreationRequestDTO createPickCreationRequest(InventoryAllocatedEvent invnAllocatedEvent) {
		PickCreationRequestDTO pickReq = new PickCreationRequestDTO();
		pickReq.setBusName(invnAllocatedEvent.getBusName());
		pickReq.setLocnNbr(invnAllocatedEvent.getLocnNbr());
		pickReq.setBusUnit(invnAllocatedEvent.getBusUnit());
		pickReq.setItemBrcd(invnAllocatedEvent.getItemBrcd());
		pickReq.setLocnBrcd(invnAllocatedEvent.getLocnBrcd());
		pickReq.setOrderNbr(invnAllocatedEvent.getOrderNbr());
		pickReq.setOrderLineNbr(invnAllocatedEvent.getOrderLineNbr());
		pickReq.setQty(invnAllocatedEvent.getQty());
		pickReq.setPickedQty(0);
		pickReq.setBatchNbr(invnAllocatedEvent.getBatchNbr());
		pickReq.setOrderId(invnAllocatedEvent.getOrderId());
		//pickReq.setCompany(invnAllocatedEvent);
		//pickReq.setDivision(division);
		pickReq.setUserId(invnAllocatedEvent.getUserId());
		
		return pickReq;
	}
}
