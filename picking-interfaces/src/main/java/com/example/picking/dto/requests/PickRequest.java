package com.example.picking.dto.requests;

import lombok.Data;

@Data
public class PickRequest {
	private Long id;
	private Integer locnNbr;
	private String locnBrcd;
	private String itemBrcd;
	private Integer qtyToPick;
	private Integer qtyPicked;
	private String toContainer;
	private String pickType;
	private String waveNbr;
	private String orderNbr;
	private String packageNbr;
	private String busUnit;
	private String userId;

	public PickRequest() {

	}

	public PickRequest(Long id, Integer locnNbr, String locnBrcd, String itemBrcd, Integer qtyToPick, Integer qtyPicked,
			String toContainer, String pickType, String waveNbr, String orderNbr, String packageNbr, String busUnit,
			String userId) {
		this.id = id;
		this.locnNbr = locnNbr;
		this.locnBrcd = locnBrcd;
		this.itemBrcd = itemBrcd;
		this.qtyToPick = qtyToPick;
		this.qtyPicked=qtyPicked;
		this.toContainer=toContainer;
		this.pickType=pickType;
		this.waveNbr=waveNbr;
		this.orderNbr=orderNbr;
		this.packageNbr=packageNbr;
		this.busUnit=busUnit;
		this.userId=userId;
	}

}
