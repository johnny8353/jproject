package com.johnny.ui.xml.digester;

import java.util.ArrayList;
import java.util.List;


public class ViewCache {
    private List areaList             = new ArrayList();
    public List getAreaList() {
        return areaList;
    }
    public void setAreaList(List areaList) {
        this.areaList = areaList;
    }
    
    // 供Digester调用的方法
    public void addArea(Area area) {
        this.areaList.add(area);
    }
	@Override
	public String toString() {
		return "ViewCache [areaList=" + areaList + "]";
	}
    
    
}
