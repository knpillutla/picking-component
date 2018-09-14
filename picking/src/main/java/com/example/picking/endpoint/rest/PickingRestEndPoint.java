package com.example.picking.endpoint.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.picking.dto.events.PickConfirmationFailureEvent;
import com.example.picking.dto.events.PickCreationFailureEvent;
import com.example.picking.dto.requests.PickCreationRequest;
import com.example.picking.dto.requests.PickRequest;
import com.example.picking.service.PickingService;

import io.swagger.annotations.Api;
@Controller
@RequestMapping("/picking/v1")
@Api(value="Pick Service", description="Operations pertaining to picking")
@RefreshScope
public class PickingRestEndPoint {

    @Value("${message: Picking Service - Config Server is not working..pelase check}")
    private String msg;
    
    @Autowired
	PickingService pickingService;
	Logger logger = LoggerFactory.getLogger(PickingRestEndPoint.class);
	
	@GetMapping("/")
	public ResponseEntity hello() throws Exception {
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/{locnNbr}/picks/next")
	public ResponseEntity getNextPick() throws IOException {
		try {
			return ResponseEntity.ok(pickingService.getNextPick());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error occured while getting next pick task"));
		}
	}
	
	@GetMapping("/{locnNbr}/picks/{id}")
	public ResponseEntity getByPickId(@PathVariable("locnNbr") Integer locnNbr, @PathVariable("id") Long pickId) throws IOException {
		try {
			return ResponseEntity.ok(pickingService.findById(locnNbr, pickId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ErrorRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error occured while getting next pick task"));
		}
	}

	@PostMapping("/{locnNbr}/picks/{id}")
	public ResponseEntity confirmPick(@PathVariable("locnNbr") Integer locnNbr, @PathVariable("id") Long id, @RequestBody PickRequest pickReq) throws IOException {
		try {
			return ResponseEntity.ok(pickingService.confirmPick(pickReq));
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new PickConfirmationFailureEvent(pickReq, "Error Occured while processing request:" + e.getMessage()));
		}
	}	
	
	@PutMapping("/{locnNbr}/picks")
	public ResponseEntity processPickCreationRequest(@PathVariable("locnNbr") Integer locnNbr, @RequestBody PickCreationRequest pickCreationReq) throws IOException {
		long startTime = System.currentTimeMillis();
		logger.info("Received request for : " + pickCreationReq.toString() + ": at :" + new java.util.Date());
		ResponseEntity resEntity = null;
		try {
			resEntity = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(pickingService.createPick(pickCreationReq));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resEntity = ResponseEntity.badRequest().body(new PickCreationFailureEvent(pickCreationReq, "Error Occured while processing request:" + e.getMessage()));
		}
		long endTime = System.currentTimeMillis();
		logger.info("Completed request for : " + pickCreationReq.toString() + ": at :" + new java.util.Date() + " : total time:" + (endTime-startTime)/1000.00 + " secs");
		return resEntity;
	}	
}
