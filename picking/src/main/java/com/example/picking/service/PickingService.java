package com.example.picking.service;

import com.example.picking.dto.events.PickConfirmationEvent;
import com.example.picking.dto.events.PickCreationEvent;
import com.example.picking.dto.requests.PickCreationRequest;
import com.example.picking.dto.requests.PickRequest;

public interface PickingService {
	public PickRequest getNextPick() throws Exception;

	public PickConfirmationEvent confirmPick(PickRequest pickRequest) throws Exception;

	public PickCreationEvent createPick(PickCreationRequest pickCreationRequest) throws Exception;
	
	public PickRequest findById(Integer locnNbr, Long pickId) throws Exception;
}