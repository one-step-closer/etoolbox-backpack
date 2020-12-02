/*
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exadel.aem.backpack.request.impl.models;

import com.exadel.aem.backpack.request.annotations.FieldType;
import com.exadel.aem.backpack.request.annotations.RequestMapping;
import com.exadel.aem.backpack.request.annotations.RequestParam;
import com.exadel.aem.backpack.request.annotations.Validate;
import com.exadel.aem.backpack.request.validator.impl.RequiredValidator;
import com.exadel.aem.backpack.request.validator.impl.WholeNumberValidator;

import java.util.List;

@RequestMapping
@SuppressWarnings("UnusedDeclaration") // contains directly injected fields
public class ValidateModel {

    @RequestParam
    @Validate(validator = {RequiredValidator.class},
            invalidMessages = {"String field is required"})
    private String requiredString;

    @RequestParam
    @Validate(validator = {WholeNumberValidator.class},
            invalidMessages = {"Field must be whole number!"})
    private int wholeNumber;


    @RequestParam(type = FieldType.MULTIFIELD)
    @Validate(validator = {RequiredValidator.class},
            invalidMessages = {"mutifieldProperties is required"})
    private List<NestedModel> multifieldProperties;


    public String getRequiredString() {
        return requiredString;
    }

    public int getWholeNumber() {
        return wholeNumber;
    }


    public List<NestedModel> getMultifieldProperties() {
        return multifieldProperties;
    }
}
