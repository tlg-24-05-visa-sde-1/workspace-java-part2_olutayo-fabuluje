/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

    // prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * TODO: given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String,String> inputMap) throws IllegalArgumentException {
        // return value
        Employee emp = null;

        // FIRST, extract the 'indicator' from the Map, i.e., "HE" or "SE"
        String type = inputMap.get("type");

        if ("HE".equals(type)) {
            // create new HourlyEmployee and assign to return variable 'emp'

        }
        else if ("SE".equals(type)) {
            // create new SalariedEmployee and assign to return variable 'emp'
            String name = inputMap.get("name");
            Date hireDate = Date.valueOf(inputMap.get("hireDate"));
            Double salary = Double.valueOf(inputMap.get("salary"));
            emp = new SalariedEmployee(name, hireDate, salary);

        }
        else
            throw new IllegalArgumentException("Invalid type: " + type + ". " + "Valid types are HE and SE.");

        return emp;
    }
}