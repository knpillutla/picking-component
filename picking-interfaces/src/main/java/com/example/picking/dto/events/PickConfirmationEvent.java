package com.example.picking.dto.events;

public class PickConfirmationEvent {
	
	public Long id;
	public Integer locnNbr;
	public String locnBrcd;
	public String itemBrcd;
	public Integer qtyToPick;
	public Integer qtyPicked;
	public Integer totalQtyToPick;
	public Integer totalQtyPicked;
	public String toContainer;
	public String pickType;
	public String waveNbr;
	public String orderNbr;
	public String packageNbr;
	public String busUnit;
	public String userId;
	
	public PickConfirmationEvent() {

	}

	public PickConfirmationEvent(Long id, Integer locnNbr, String locnBrcd, String itemBrcd, Integer qtyToPick, Integer qtyPicked,Integer totalQtyToPick, Integer totalQtyPicked,
			String toContainer, String pickType, String waveNbr, String orderNbr, String packageNbr, String busUnit,
			String userId) {
		this.id = id;
		this.locnNbr = locnNbr;
		this.locnBrcd = locnBrcd;
		this.itemBrcd = itemBrcd;
		this.qtyToPick = qtyToPick;
		this.qtyPicked=qtyPicked;
		this.totalQtyToPick=totalQtyToPick;
		this.totalQtyPicked=totalQtyPicked;
		this.toContainer=toContainer;
		this.pickType=pickType;
		this.waveNbr=waveNbr;
		this.orderNbr=orderNbr;
		this.packageNbr=packageNbr;
		this.busUnit=busUnit;
		this.userId=userId;
	}

}
