package com.tao.northwindj.domains.master;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.SimpleMasterObject;
import com.tao.northwindj.domains.customers.Customers;
@JsonInclude(value=Include.NON_NULL)
public class DemoGraphics extends SimpleMasterObject {
	public DemoGraphics()
	{
		
	}

}
