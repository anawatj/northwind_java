package com.tao.northwindj.domains.master;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.SimpleMasterObject;

@JsonInclude(value=Include.NON_EMPTY)
public class Bank extends SimpleMasterObject{

		public Bank()
		{
			
		}
		
}
