package com.pragma.archetypespringboot.user.infrastructure.configurations.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.logging.Logger;

import static com.pragma.archetypespringboot.user.infrastructure.configurations.beans.ScannerClasses.scannerClasses;

public class BeanImportSelector implements ImportSelector {

  public String useCaseRoute = "com.pragma.archetypespringboot.user.domain.usecases";
  public String serviceRoute = "com.pragma.archetypespringboot.user.application.services.impl";
  public String adaptersRoute = "com.pragma.archetypespringboot.user.infrastructure.adapters";

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {

    String[] useCaseClasses = scannerClasses(useCaseRoute);
    String[] serviceClasses = scannerClasses(serviceRoute);
    String[] adapterClasses = scannerClasses(adaptersRoute);

    String[] totalScanner = Arrays.copyOf(useCaseClasses, useCaseClasses.length + serviceClasses.length + adapterClasses.length);
    System.arraycopy(serviceClasses, 0, totalScanner, useCaseClasses.length, serviceClasses.length);
    System.arraycopy(adapterClasses, 0, totalScanner, useCaseClasses.length + serviceClasses.length, adapterClasses.length);

    Logger.getLogger(BeanImportSelector.class.getName()).info("Imported Beans: " + StringUtils.arrayToCommaDelimitedString(totalScanner));

    return totalScanner;
  }

}
