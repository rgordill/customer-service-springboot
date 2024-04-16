package org.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import io.prometheus.client.exemplars.ExemplarConfig;

// Add the component with autowire to CustomerController to show if exemplars are enabled

@Component
public class CustomerExemplar {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public CustomerExemplar(){
    logger.info("Exemplars enabled: {}", ExemplarConfig.isExemplarsEnabled());
  }

}
