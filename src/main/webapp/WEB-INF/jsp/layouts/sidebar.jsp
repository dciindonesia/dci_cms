<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<<style>
.side-wrap {
	position: fixed;
	top: 50px;
	width: 227px;
}
.accordion-group {
min-height:60px;
}

.accordion-heading {
min-height:60px;
}

.accordion-heading .accordion-toggle {
padding-top:20px;
}
</style>
<div id="wrap" class="side-wrap">
<div class="accordion" id="my-accordion">
 	<div class="accordion-group dropdown">
   		<div class="accordion-heading">
     		<a href="#collapse-1" data-toggle="collapse" 
        		data-parent="#my-accordion" class="accordion-toggle">DCI INDONESIA<i class="icon icon-chevron-down pull-right"></i></a>
   		</div>
 		<div class="accordion-body collapse in" id="collapse-1">
 			<div class="accordion-inner">
            <ul>
                <li>
                    <a href="#">History</a>
                </li>
                <li>
                    <a href="#">Service</a>
                </li>
            </ul>
            </div>
    	</div>
    </div>
    
    <div class="accordion-group dropdown">
   		<div class="accordion-heading">
     		<a href="#collapse-2" data-toggle="collapse" 
        		data-parent="#my-accordion" class="accordion-toggle">Contact Person<i class="icon icon-chevron-down pull-right"></i></a>
   		</div>
 		<div class="accordion-body collapse" id="collapse-2">
    		<div class="accordion-inner">
        				<ul>
                            <li>
                                <a href="#">Me</a>
                            </li>
                        </ul>
        	</div>
    	</div>
    </div>
    
    <div class="accordion-group">
   		<div class="accordion-heading">
     		<a href="#collapse-3" data-toggle="collapse" 
        		data-parent="#my-accordion" class="accordion-toggle">Career<i class="icon icon-chevron-down pull-right"></i></a>
   		</div>
 		<div class="accordion-body collapse" id="collapse-3">
    		<div class="accordion-inner">
        				<ul>
                            <li>
                                <a href="#">Job Information</a>
                            </li>
                            <li>Lorem ipsum dolor sit amet</li>
                        </ul>
        	</div>
    	</div>
    </div>
</div>
</div>