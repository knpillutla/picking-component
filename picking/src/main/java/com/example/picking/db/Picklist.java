package com.example.picking.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
@Table(name="pick_list")
public class Picklist  implements Serializable{
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name="BUS_NAME")
	String busName;

	@Column(name="LOCN_NBR")
	Integer locnNbr;

	@Column(name="BUS_UNIT")
	String busUnit;

	@Column(name="COMPANY")
	String company;
	
	@Column(name="DIVISION")
	String division;

	@Column(name="QTY")
	Integer qty;

	@Column(name="PICKED_QTY")
	Integer pickedQty;

	@Column(name="STAT_CODE")
	Integer statCode;

	@Column(name="TRANSACTION_NAME")
	String transName;
	
	@Column(name="SOURCE")
	String source;

	@Column(name="HOST_NAME")
	String hostName;

	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	@Column(name="CREATED_DTTM", nullable = false, updatable = false)
	Date createdDttm;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DTTM", nullable = false)
    @LastModifiedDate
	Date updatedDttm;
	
	@Column(name="USER_ID")
	String userId;
	
	@OneToMany(mappedBy = "picklist", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	List<Pick> picks = new ArrayList<>();
}
