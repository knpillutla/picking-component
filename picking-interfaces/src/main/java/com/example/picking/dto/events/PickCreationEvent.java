package com.example.picking.dto.events;

public class PickCreationEvent {
	public Long id;
	public Integer locnNbr;
	public String locnBrcd;
	public String itemBrcd;
	public Integer qtyToPick;
	public String toContainer;
	public String pickType;
	public String waveNbr;
	public String orderNbr;
	public String packageNbr;
	public String busUnit;
	public String userId;
	
	public PickCreationEvent() {

	}

	public PickCreationEvent(Long id, Integer locnNbr, String locnBrcd, String itemBrcd, Integer qtyToPick,
			String toContainer, String pickType, String waveNbr, String orderNbr, String packageNbr, String busUnit,
			String userId) {
		this.id = id;
		this.locnNbr = locnNbr;
		this.locnBrcd = locnBrcd;
		this.itemBrcd = itemBrcd;
		this.qtyToPick = qtyToPick;
		this.toContainer=toContainer;
		this.pickType=pickType;
		this.waveNbr=waveNbr;
		this.orderNbr=orderNbr;
		this.packageNbr=packageNbr;
		this.busUnit=busUnit;
		this.userId=userId;
	}

	
}
