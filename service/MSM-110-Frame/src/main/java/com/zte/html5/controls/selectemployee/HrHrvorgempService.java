package com.zte.html5.controls.selectemployee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 服务类
 */
@Service
public class HrHrvorgempService implements IHrHrvorgempService {

	protected Log log = LogFactory.getLog(HrHrvorgempService.class);

	@Autowired
	private HrHrvorgempMapper hrHrvorgempDAO = null;

	public void setHrHrvorgempDAO(HrHrvorgempMapper hrHrvorgempDAO) {
		this.hrHrvorgempDAO = hrHrvorgempDAO;
	}

	/**
	 * 获取符合条件的实体列表,按指定属性排序
	 */
	@Cacheable(value = "KeyEmpIdListCache", key = "#seekInfo")
	public List<KeyValueSearchEmpResponse> getList(String seekInfo,
			String orderField, String order) throws Exception {

		List<KeyValueSearchEmpResponse> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seekInfo", seekInfo);
		map.put("orderField", "empidUi");

		list = hrHrvorgempDAO.getEmpIdList(map);

		return list;
	}

	/**
	 * 获取符合条件的记录数量
	 */
	@Cacheable(value = "KeyEmpIdCountCache", key = "#seekInfo")
	public long getCount(String seekInfo, String orderField, String order)
			throws Exception {
		long count = 0L;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seekInfo", seekInfo);

		count = hrHrvorgempDAO.getCount(map);

		return count;
	}

	/**
	 * 获取符合条件的记录列表,先按指定属性排序,在分页
	 */
	@Cacheable(value = "KeyEmpIdListCache", key = "#seekInfo")
	public List<KeyValueSearchEmpResponse> getPage(String seekInfo,
			String orderField, String order, Long page, Long rows)
			throws Exception {
		List<KeyValueSearchEmpResponse> list = null;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seekInfo", seekInfo);

		map.put("orderField", orderField);
		map.put("order", order);
		map.put("startRow", (page - 1) * rows);
		map.put("rowSize", rows);

		list = hrHrvorgempDAO.getEmpIdPage(map);

		return list;
	}

	@Override
	@Cacheable(value = "EmpIdMsgCache", key = "#temp.getEmpidUi()")
	public KeyValueSearchEmpResponse getEmpMsg(KeyValueSearchEmpResponse temp) {
		log.info("从数据库读取数据" + temp.getEmpidUi());
		KeyValueSearchEmpResponse resultMsg = new KeyValueSearchEmpResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empidUi", temp.getEmpidUi());
		resultMsg = hrHrvorgempDAO.getEmpMsg(map);
		return resultMsg;
	}

}