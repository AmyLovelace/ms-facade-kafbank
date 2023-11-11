package com.ppj.acl.adapter.controller;


import com.ppj.acl.adapter.controller.processor.Processor;
import com.ppj.acl.adapter.controller.processor.RequestProcessor;
import com.ppj.acl.application.port.in.CreateAccount;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/account")
public class AccountControllerAdapter {

    private static final String GET_ACCOUNT = "/{name}";
    private static final String GET_INTERNAL_ACCOUNT = "/internal/{name}";
    private static final String CREATE_ACCOUNT = "/create";

    private final CreateAccount createAccount;

    private final Processor processor;

    public AccountControllerAdapter (CreateAccount createAccount){

        this.createAccount = createAccount;
        this.processor = new RequestProcessor();
    }


    /*@PostMapping(CREATE_ACCOUNT)
    public RestResponse<Integer> createAccount(final HttpServletRequest httpServletRequest, @Valid @RequestBody CardRest request){
        log.info("Llamada al servicio de cracion de cuentas");
        var response = createAccount.createAccount(request.toDomain());
        log.info("respuesta del servicio de creacion de cuentas : [{}] " , response);
        return processor.processRequest(Processor.Enriched.of(httpServletRequest),
                resp -> RestResponse.<Integer>builder()
                        .data(response).id(resp.getId())
                        .status(HttpStatus.CREATED.value())
                        .resource(httpServletRequest.getRequestURI())
                        .metadata(processor.buildMetadata(resp.getReq()))
                        .build());

    }*/

}
