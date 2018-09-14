package com.example.picking.dto.requests;

import lombok.Data;

@Data
public class PickCreationRequest {
	public Integer locnNbr;
	public String busUnit;
	public String locnBrcd;
	public String itemBrcd;
	public Integer totalPickQty;
	public String toContainer;
	public String pickType;
	public String waveNbr;
	public String orderNbr;
	public String packageNbr;
	public String userId;
}
