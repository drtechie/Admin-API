/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.admin.controller.pharmacologicalcategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.admin.data.pharmacologicalcategory.M_Pharmacologicalcategory;
import com.iemr.admin.service.pharmacologicalcategory.PharmacologicalcategoryInter;
import com.iemr.admin.utils.mapper.InputMapper;
import com.iemr.admin.utils.response.OutputResponse;

@RestController
public class PharmacologicalcategoryController {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private PharmacologicalcategoryInter pharmacologicalcategoryInter;
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/createPharmacologicalcategory" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String createPharmacologicalcategory(@RequestBody String createPharmacologicalcategory) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Pharmacologicalcategory[] Pharmacologicalcategory = InputMapper.gson().fromJson(createPharmacologicalcategory,
					M_Pharmacologicalcategory[].class);
			List<M_Pharmacologicalcategory> createPharmacologicaldata = Arrays.asList(Pharmacologicalcategory);
			
			ArrayList<M_Pharmacologicalcategory> saveData=pharmacologicalcategoryInter.createPharmacologicalcategory(createPharmacologicaldata);
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/getPharmacologicalcategory" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String getPharmacologicalcategory(@RequestBody String createPharmacologicalcategory) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Pharmacologicalcategory Pharmacologicalcategory = InputMapper.gson().fromJson(createPharmacologicalcategory,
					M_Pharmacologicalcategory.class);
			//List<M_Pharmacologicalcategory> getPharmacologicaldata = Arrays.asList(Pharmacologicalcategory);
			
			ArrayList<M_Pharmacologicalcategory> saveData=pharmacologicalcategoryInter.getPharmacologicalcategory(Pharmacologicalcategory.getProviderServiceMapID());
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/editPharmacologicalcategory" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String editPharmacologicalcategory(@RequestBody String editPharmacologicalcategory) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Pharmacologicalcategory Pharmacologicalcategory = InputMapper.gson().fromJson(editPharmacologicalcategory,
					M_Pharmacologicalcategory.class);
			//List<M_Pharmacologicalcategory> getPharmacologicaldata = Arrays.asList(Pharmacologicalcategory);
			
			M_Pharmacologicalcategory saveData=pharmacologicalcategoryInter.editPharmacologicalcategory(Pharmacologicalcategory.getPharmCategoryID());
			
//			saveData.setPharmCategoryName(Pharmacologicalcategory.getPharmCategoryName());
			saveData.setPharmCategoryDesc(Pharmacologicalcategory.getPharmCategoryDesc());
//			saveData.setPharmCategoryCode(Pharmacologicalcategory.getPharmCategoryCode());
//			saveData.setStatus(Pharmacologicalcategory.getStatus());
			saveData.setModifiedBy(Pharmacologicalcategory.getModifiedBy());
			M_Pharmacologicalcategory saveEditedData=pharmacologicalcategoryInter.saveEditedPharData(saveData);
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/deletePharmacologicalcategory" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String deletePharmacologicalcategory(@RequestBody String deletePharmacologicalcategory) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Pharmacologicalcategory Pharmacologicalcategory = InputMapper.gson().fromJson(deletePharmacologicalcategory,
					M_Pharmacologicalcategory.class);
			//List<M_Pharmacologicalcategory> getPharmacologicaldata = Arrays.asList(Pharmacologicalcategory);
			
			M_Pharmacologicalcategory saveData=pharmacologicalcategoryInter.editPharmacologicalcategory(Pharmacologicalcategory.getPharmCategoryID());
			
			saveData.setDeleted(Pharmacologicalcategory.getDeleted());
		
			M_Pharmacologicalcategory saveEditedData=pharmacologicalcategoryInter.saveEditedPharData(saveData);
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	@CrossOrigin()
	@RequestMapping(value =  "/checkPharmacologicalcategoryCode" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String checkPharmacologicalcategoryCode(@RequestBody String deletePharmacologicalcategory) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Pharmacologicalcategory Pharmacologicalcategory = InputMapper.gson().fromJson(deletePharmacologicalcategory,
					M_Pharmacologicalcategory.class);
			//List<M_Pharmacologicalcategory> getPharmacologicaldata = Arrays.asList(Pharmacologicalcategory);
			
			Boolean saveData=pharmacologicalcategoryInter.checkPharmacologicalcategoryCode(Pharmacologicalcategory);
		
			response.setResponse(saveData.toString());

		} catch (Exception e) {
			
			logger.error("Unexpected error:" , e);
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	

}
