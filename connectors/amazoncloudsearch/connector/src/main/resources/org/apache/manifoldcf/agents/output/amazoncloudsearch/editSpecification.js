<!--
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->

<script type="text/javascript">
<!--
function checkOutputSpecification()
{
  return true;
}

function addFieldMapping()
{
  if (editjob.cloudsearch_fieldmapping_source.value == "")
  {
    alert("$Encoder.bodyEscape($ResourceBundle.getString('AmazonCloudSearchOutputConnector.NoFieldMappingSpecified'))");
    editjob.solr_fieldmapping_source.focus();
    return;
  }
  editjob.cloudsearch_fieldmapping_op.value="Add";
  postFormSetAnchor("cloudsearch_fieldmapping");
}

function deleteFieldMapping(i)
{
  // Set the operation
  eval("editjob.cloudsearch_fieldmapping_"+i+"_op.value=\"Delete\"");
  // Submit
  if (editjob.cloudsearch_fieldmapping_count.value==i)
    postFormSetAnchor("cloudsearch_fieldmapping");
  else
    postFormSetAnchor("cloudsearch_fieldmapping_"+i)
  // Undo, so we won't get two deletes next time
  eval("editjob.cloudsearch_fieldmapping_"+i+"_op.value=\"Continue\"");
}

//-->
</script>