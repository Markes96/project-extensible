package org.mk96.extensible.api.infrastucture.http.controller.requitement.type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.mk96.extensible.api.domain.model.MkDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class DomainObject extends MkDomain {

	private boolean bol;

	private byte byt;
	private short shor;
	private int in;
	private long lon;

	private float flo;
	private double doub;

	private char cha;
	private String stri;

	private LocalDate date;
	private LocalDateTime dateTime;

}
