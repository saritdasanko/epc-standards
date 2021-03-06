/*
 * Copyright 2018-present, Nike, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the Apache-2.0 license found in
 * the LICENSE file in the root directory of this source tree.
 *
 */
package com.nike.epc.model.gdti;

import com.nike.epc.model.*;
import com.nike.epc.TestValues;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GdtiTest {
  private final String CP = TestValues.random();
  private final String DT = TestValues.random();
  private final String SN = TestValues.random();

  @Test
  void epcSchema() {
    final EpcScheme s =
        EpcScheme.gdti(
            Gdti.builder().withCompanyPrefix(CP).withDocumentType(DT).withSerialNumber(SN).build());
    assertTrue(s.isGdti());

    final Gdti g = s.gdti().get();
    assertEquals(CP, g.companyPrefix());
    assertEquals(DT, g.documentType());
    assertEquals(SN, g.serialNumber());
  }
}
