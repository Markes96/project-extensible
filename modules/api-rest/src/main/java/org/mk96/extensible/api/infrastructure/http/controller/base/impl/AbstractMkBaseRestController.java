package org.mk96.extensible.api.infrastructure.http.controller.base.impl;

import java.time.LocalDateTime;

import org.mk96.common.type.MkException;
import org.mk96.extensible.api.domain.model.MkDomain;
import org.mk96.extensible.api.infrastructure.http.controller.base.MkBaseRestController;
import org.mk96.extensible.api.type.AbstractMkBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

public abstract class AbstractMkBaseRestController<DOM extends MkDomain>
	extends AbstractMkBean
    implements MkBaseRestController {
	
	@ExceptionHandler(MkException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MkRestError handleMkException(MkException e) {
		MkRestError error = new MkRestError();
	    error.setMessage(e.getMessage());
	    error.setTimestamp(LocalDateTime.now());
	    return error;
	}
	
	@Data
	public static class MkRestError {
		private String message;
		private LocalDateTime timestamp;
	}
	
}
