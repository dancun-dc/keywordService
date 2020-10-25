package com.dancun.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dancun
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Lan implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lan;


}
