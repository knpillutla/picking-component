package com.example.picking.dto.responses;

import java.util.ArrayList;
import java.util.List;

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
public class PicklistDTO extends BaseDTO{
	Long id;
	String busName;
	Integer locnNbr;
	String busUnit;
	String company;
	String division;
	Integer qty;
	Integer pickedQty;
	Integer numOfOrders;
	Integer statCode;
	String transName;
	String source;
	String hostName;
	String userId;
	List<PickDTO> picks = new ArrayList<>();
}
