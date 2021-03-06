/*******************************************************************************
 * Copyright 2016-2017 Dell Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * @microservice: support-notifications
 * @author: Jim White, Dell
 * @version: 1.0.0
 *******************************************************************************/

package org.edgexfoundry.support.notifications.controller;

import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

import org.edgexfoundry.support.notifications.controller.impl.CleanupControllerImpl;
import org.edgexfoundry.support.notifications.service.CleanupService;
import org.edgexfoundry.test.category.RequiresNone;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

@Category(RequiresNone.class)
public class CleanupControllerTest {

  private static final long OLD_AGE = Long.MAX_VALUE;

  @InjectMocks
  private CleanupControllerImpl controller;

  @Mock
  private CleanupService service;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCleanupOld() {
    ResponseEntity<Void> resp = controller.cleanupOld();
    assertEquals("Request to cleanup old requests did not return healthy status",
        HttpStatus.ACCEPTED, resp.getStatusCode());
  }

  @Test
  public void testCleanup() {
    ResponseEntity<Void> resp = controller.cleanupOld(OLD_AGE);
    assertEquals("Request to cleanup old requests did not return healthy status",
        HttpStatus.ACCEPTED, resp.getStatusCode());
  }

}
