package com.nodemules.data.api.generator.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@Data
public class GeneratorResponse<T> implements Serializable {

  private static final long serialVersionUID = 7865339023613276543L;

  private int entitiesGenerated;
  private T sampleEntity;
  private Set<Long> entityIds;

}
