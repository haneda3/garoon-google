/*
* garoon-google
* Copyright (c) 2015 Cybozu
*
* Licensed under the MIT License
*/
package com.cybozu.garoon3.schedule;

import java.util.ArrayList;
import java.util.List;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;

import com.cybozu.garoon3.common.APIType;
import com.cybozu.garoon3.common.Action;
/**
 * 予定IDを指定して予定を取得します。
 * 
 * @author $api_author Garoon Team@Cybozu$
 * @version $api_version ver 1.0.0$
 */
public class ScheduleGetEventsById implements Action {

	private List<Integer> ids = new ArrayList<Integer>();
	
	/**
	 * 取得する予定IDを追加します。
	 * @param id
	 */
	public void addID( int id ) {
		this.ids.add( id );
	}
	
	@Override
	public APIType getAPIType() {
		return APIType.SCHEDULE;
	}

	@Override
	public String getActionName() {
		return "ScheduleGetEventsById";
	}

	@Override
	public OMElement getParameters() {
        OMFactory omFactory = OMAbstractFactory.getOMFactory();
        OMElement parameters = omFactory.createOMElement("parameters", null);
        
        for( Integer id : ids )
        {
	        OMElement eventNode = omFactory.createOMElement("event_id", null);
	        eventNode.setText( String.valueOf(id) );
	        parameters.addChild( eventNode );
        }
		
		return parameters;
	}
}
