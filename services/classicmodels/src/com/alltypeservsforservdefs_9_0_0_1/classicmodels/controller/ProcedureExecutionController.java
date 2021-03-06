/*Generated by WaveMaker Studio*/
package com.alltypeservsforservdefs_9_0_0_1.classicmodels.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.alltypeservsforservdefs_9_0_0_1.classicmodels.service.ClassicmodelsProcedureExecutorService;
import com.alltypeservsforservdefs_9_0_0_1.classicmodels.models.procedure.*;

@RestController(value = "Classicmodels.ProcedureExecutionController")
@RequestMapping("/classicmodels/procedureExecutor")
@Api(value = "ProcedureExecutionController", description = "controller class for procedure execution")
public class ProcedureExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureExecutionController.class);

    @Autowired
    private ClassicmodelsProcedureExecutorService procedureService;

    @RequestMapping(value = "/procedure/execute/EmployeeProcVar", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "employee")
    public EmployeeProcVarResponse executeEmployeeProcVar(HttpServletRequest _request) {
        LOGGER.debug("Executing named procedure: EmployeeProcVar");
        EmployeeProcVarResponse _result = procedureService.executeEmployeeProcVar();
        LOGGER.debug("got the result for named procedure: EmployeeProcVar, result:{}", _result);
        return _result;
    }

}