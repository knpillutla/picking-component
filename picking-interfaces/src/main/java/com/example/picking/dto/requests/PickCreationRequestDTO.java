package com.example.picking.dto.requests;

import com.example.picking.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PickCreationRequestDTO  extends BaseDTO{
	String busName;
	Integer locnNbr;
	String busUnit;
	String company;
	String division;
	String locnBrcd;
	String itemBrcd;
	Integer qty;
	Integer pickedQty;
	String fromContainer;
	String toContainer;
	Long orderId;
	String orderNbr;
	String packageNbr;
	Integer orderLineNbr;
	String transName;
	String source;
	String hostName;
	String userId;
	String batchNbr;
	Long orderLineId;
}