package com.example.picking.dto.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.picking.db.Pick;
import com.example.picking.dto.requests.PickCreationRequestDTO;
import com.example.picking.dto.responses.PickDTO;

@Component
public class EntityDTOConverter {

	public static PickDTO getPickDTO(Pick pickEntity) {
		if(pickEntity == null)
			return null;
		Long pickListId = -1L;
		if(pickEntity.getPicklist()!=null) {
			pickListId = pickEntity.getPicklist().getId();
		}
		PickDTO pickDTO = new PickDTO(pickEntity.getId(), pickListId, pickEntity.getBusName(),
				pickEntity.getLocnNbr(), pickEntity.getBusUnit(), pickEntity.getCompany(), pickEntity.getDivision(),
				pickEntity.getLocnBrcd(), pickEntity.getItemBrcd(), pickEntity.getQty(), pickEntity.getPickedQty(),
				pickEntity.getFromContainer(), pickEntity.getToContainer(), pickEntity.getStatCode(),
				pickEntity.getOrderId(), pickEntity.getOrderNbr(), pickEntity.getPackageNbr(),
				pickEntity.getOrderLineNbr(), pickEntity.getTransName(), pickEntity.getSource(),
				pickEntity.getHostName(), pickEntity.getUserId());
		return pickDTO;
	}

	public static Pick getPickEntity(PickCreationRequestDTO pickCreationReqDTO) {
		Pick newPickEntity = new Pick();
		newPickEntity.setBusName(pickCreationReqDTO.getBusName());
		 newPickEntity.setLocnNbr(pickCreationReqDTO.getLocnNbr());
		newPickEntity.setLocnBrcd(pickCreationReqDTO.getLocnBrcd());
		newPickEntity.setItemBrcd(pickCreationReqDTO.getItemBrcd());
		 newPickEntity.setQty(pickCreationReqDTO.getQty());
		 newPickEntity.setOrderId(pickCreationReqDTO.getOrderId());
		 newPickEntity.setOrderNbr(pickCreationReqDTO.getOrderNbr());
		newPickEntity.setOrderLineNbr(pickCreationReqDTO.getOrderLineNbr());
		 newPickEntity.setBusUnit(pickCreationReqDTO.getBusUnit());
		Date newDate = new Date();
		newPickEntity.setCreatedDttm(newDate);
		newPickEntity.setUpdatedDttm(newDate);
		newPickEntity.setCompany(pickCreationReqDTO.getCompany());
		newPickEntity.setDivision(pickCreationReqDTO.getDivision());
		newPickEntity.setFromContainer(pickCreationReqDTO.getFromContainer());
		newPickEntity.setToContainer(pickCreationReqDTO.getToContainer());
		newPickEntity.setPickedQty(0);
		return newPickEntity;
	}
}
