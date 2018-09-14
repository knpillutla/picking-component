package com.example.picking.db;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="picks")
public class Pick  implements Serializable{
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name="LOCN_NBR")
	Integer locnNbr;

	@Column(name="BUS_UNIT")
	String busUnit;

	@Column(name="LOCN_BRCD")
	String locnBrcd;

	@Column(name="ITEM_BRCD")
	String itemBrcd;

	@Column(name="TOTAL_PICK_QTY")
	Integer totalPickQty;

	@Column(name="TOTAL_PICKED_QTY")
	Integer totalPickedQty;

	@Column(name="FROM_CONTAINER_NBR")
	String fromContainer;

	@Column(name="TO_CONTAINER_NBR")
	String toContainer;

	@Column(name="PICK_TYPE")
	String pickType;

	@Column(name="STAT_CODE")
	Integer statCode;

	@Column(name="WAVE_NBR")
	String waveNbr;

	@Column(name="ORDER_NBR")
	String orderNbr;

	@Column(name="PACKAGE_NBR")
	String packageNbr;
	
	@Column(name="SOURCE_SERVICE")
	String sourceService;

	@Column(name="HOST_NAME")
	String hostName;

	@Column(name="CREATED_DTTM")
	Date createdDttm;
	
	@Column(name="UPDATED_DTTM")
	Date updatedDttm;
	
	@Column(name="USER_ID")
	String userId;
}
