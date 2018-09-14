package com.example.picking.service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.picking.db.Pick;
import com.example.picking.db.PickingRepository;
import com.example.picking.dto.events.PickConfirmationEvent;
import com.example.picking.dto.events.PickCreationEvent;
import com.example.picking.dto.requests.PickCreationRequest;
import com.example.picking.dto.requests.PickRequest;

@Service
public class PickingServiceImpl implements PickingService {
	private static final Logger logger = LoggerFactory.getLogger(PickingServiceImpl.class);
	
	@Autowired
	PickingRepository pickDAO;
	
	/* (non-Javadoc)
	 * @see com.example.demo.PickingService#getNextPick()
	 */
	@Override
	public PickRequest getNextPick() throws Exception {
		Optional<Pick> pickTaskEntityOptional = pickDAO.findById((long) 1);
		if(pickTaskEntityOptional.isPresent()) {
			Pick pickEntity = pickTaskEntityOptional.get();
			int qtyToPick = pickEntity.getTotalPickQty()-pickEntity.getTotalPickedQty();
			PickRequest pickReqDTO = new PickRequest(pickEntity.getId(), pickEntity.getLocnNbr(), pickEntity.getLocnBrcd(), pickEntity.getItemBrcd(), 
					qtyToPick, 0, pickEntity.getToContainer(), pickEntity.getPickType(), pickEntity.getWaveNbr(), pickEntity.getOrderNbr(), pickEntity.getPackageNbr(), pickEntity.getBusUnit(),"");
			
			return pickReqDTO;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.PickingService#confirmPick(com.example.AvroPickTask)
	 */
	@Override
	public PickConfirmationEvent confirmPick(PickRequest pickRequest) throws Exception{
		logger.info("confirmPick Start, :" + pickRequest.toString());
		Pick pickEntity = pickDAO.findById(pickRequest.getLocnNbr(), pickRequest.getId());
		pickEntity.setTotalPickedQty(pickEntity.getTotalPickedQty() + pickRequest.getQtyPicked());
		pickEntity.setUserId(pickRequest.getUserId());
		Pick updatedPickObj = pickDAO.save(pickEntity);
		PickConfirmationEvent pickConfirmEvent = new PickConfirmationEvent(pickEntity.getId(), pickEntity.getLocnNbr(), pickEntity.getLocnBrcd(), pickEntity.getItemBrcd(), 
				pickRequest.getQtyToPick(), pickRequest.getQtyPicked(), pickEntity.getTotalPickQty(), pickEntity.getTotalPickedQty(), pickEntity.getToContainer(), pickEntity.getPickType(), pickEntity.getWaveNbr(), pickEntity.getOrderNbr(), pickEntity.getPackageNbr(), pickEntity.getBusUnit(),"");
		logger.info("confirmPick End, updated pick obj:" + pickRequest.toString());
		return pickConfirmEvent;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.PickingService#createNew(com.example.AvroPickTask)
	 */
	@Override
	public PickCreationEvent createPick(PickCreationRequest pickCreationReq) throws IOException {
		Pick newPick = new Pick();
		newPick.setLocnNbr(pickCreationReq.getLocnNbr());
		newPick.setBusUnit(pickCreationReq.getBusUnit());
		newPick.setLocnBrcd(pickCreationReq.getLocnBrcd());
		newPick.setItemBrcd(pickCreationReq.getItemBrcd());
		newPick.setTotalPickQty(pickCreationReq.getTotalPickQty());
		newPick.setTotalPickedQty(0);
		newPick.setWaveNbr(pickCreationReq.getWaveNbr());
		newPick.setOrderNbr(pickCreationReq.getOrderNbr());
		newPick.setPackageNbr(pickCreationReq.getPackageNbr());
		newPick.setUserId(pickCreationReq.getUserId());
		Date pickCreationDate = new Date();
		newPick.setCreatedDttm(pickCreationDate);
		newPick.setUpdatedDttm(pickCreationDate);
		
		logger.info("createPick Start, received new pick request:" + newPick.toString());
		Pick savedPickObj = pickDAO.save(newPick);
		
		PickCreationEvent pickCreationEvent = new PickCreationEvent(savedPickObj.getId(), savedPickObj.getLocnNbr(), savedPickObj.getLocnBrcd(), savedPickObj.getItemBrcd(), 
				savedPickObj.getTotalPickQty(), savedPickObj.getToContainer(), savedPickObj.getPickType(), savedPickObj.getWaveNbr(), savedPickObj.getOrderNbr(), savedPickObj.getPackageNbr(), savedPickObj.getBusUnit(),"");
		logger.info("createPick End, created new pick:" + savedPickObj.toString());
		return pickCreationEvent;
	}

	@Override
	public PickRequest findById(Integer locnNbr, Long pickId) throws Exception {
		Pick pickEntity = pickDAO.findById(locnNbr, (long) 1);
		if(pickEntity!=null) {
			int qtyToPick = pickEntity.getTotalPickQty()-pickEntity.getTotalPickedQty();
			PickRequest pickReqDTO = new PickRequest(pickEntity.getId(), pickEntity.getLocnNbr(), pickEntity.getLocnBrcd(), pickEntity.getItemBrcd(), 
					qtyToPick, 0, pickEntity.getToContainer(), pickEntity.getPickType(), pickEntity.getWaveNbr(), pickEntity.getOrderNbr(), pickEntity.getPackageNbr(), pickEntity.getBusUnit(),"");
			
			return pickReqDTO;
		}
		return null;

	}

}
