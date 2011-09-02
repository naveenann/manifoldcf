/* $Id$ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.manifoldcf.scriptengine.tests;

import org.apache.manifoldcf.scriptengine.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ExpressionTest extends ScriptEngineBase
{

  @Test
  public void basicIntOperations()
    throws Exception
  {
    VariableReference vr;
    
    // Binary +
    vr = evaluateExpression("1+2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),3);
    
    // Binary -
    vr = evaluateExpression("1-2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),-1);

    // Binary *
    vr = evaluateExpression("2*3");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),6);

    // Binary /
    vr = evaluateExpression("3/2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),1);

    // Unary -
    vr = evaluateExpression("-2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),-2);

    // Binary &
    vr = evaluateExpression("1&5");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),1);

    // Binary |
    vr = evaluateExpression("1|2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),3);

    // Unary !
    vr = evaluateExpression("!2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),2^2);

    // >
    vr = evaluateExpression("1>1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),false);
    vr = evaluateExpression("2>1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),true);

    // >=
    vr = evaluateExpression("0>=1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),false);
    vr = evaluateExpression("1>=1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),true);

    // <
    vr = evaluateExpression("2<2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),false);
    vr = evaluateExpression("1<2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),true);

    // <=
    vr = evaluateExpression("2<=1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),false);
    vr = evaluateExpression("1<=1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),true);

    // ==
    vr = evaluateExpression("1==2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),false);
    vr = evaluateExpression("1==1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),true);

    // !=
    vr = evaluateExpression("1!=1");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),false);
    vr = evaluateExpression("1!=2");
    assertNotNull(vr);
    assertEquals(vr.resolve().getBooleanValue(),true);

    // Attributes
    vr = evaluateExpression("2 .__int__");
    assertNotNull(vr);
    assertEquals(vr.resolve().getIntValue(),2);
    vr = evaluateExpression("2 .__string__");
    assertNotNull(vr);
    assertEquals(vr.resolve().getStringValue(),"2");
    vr = evaluateExpression("2 .__float__");
    assertNotNull(vr);
    assertEquals(vr.resolve().getDoubleValue(),2.0,0.0);
    vr = evaluateExpression("2 .__script__");
    assertNotNull(vr);
    assertEquals(vr.resolve().getStringValue(),"2");

    // Various values
    assertEquals(new VariableInt(2).getIntValue(),2);
    assertEquals(new VariableInt(2).getStringValue(),"2");
    assertEquals(new VariableInt(2).getDoubleValue(),2.0,0.0);

  }

}
