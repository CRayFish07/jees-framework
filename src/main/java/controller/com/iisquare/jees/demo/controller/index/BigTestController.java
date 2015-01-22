package com.iisquare.jees.demo.controller.index;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.iisquare.jees.core.component.CoreController;
import com.iisquare.jees.demo.domain.BigTest;
import com.iisquare.jees.demo.service.BigTestService;
import com.iisquare.jees.framework.util.ValidateUtil;

/**
 * 示例程序
 * @author Ouyang <iisquare@163.com>
 *
 */
@Controller
@Scope("prototype")
public class BigTestController extends CoreController {
	
	@Autowired
	public BigTestService bigBigTestService;

	/* 数据库操作示例 - 添加 */
	public String modelCAction() throws Exception {
		long time = System.currentTimeMillis();
		BigTest bigBigTest = new BigTest();
		bigBigTest.setTitle("标题" + time);
		bigBigTest.setContent("内容");
		bigBigTest.setStatus(0);
		bigBigTest.setCreateTime(time);
		bigBigTest.setUpdateTime(time);
		long id = bigBigTestService.insert(bigBigTest);
		assign("insertId", id);
		assign("object", bigBigTest);
		return displayJSON();
	}
	
	/* 数据库操作示例 - 修改 */
	public String modelUAction() throws Exception {
		long time = System.currentTimeMillis();
		Long id = ValidateUtil.filterLong(get("id"), true, 0L, null, null);
		BigTest bigBigTest = bigBigTestService.getById(id);
		if(null == bigBigTest) {
			return displayMessage(500, "对象不存在", null);
		}
		bigBigTest.setContent("内容" + time);
		bigBigTest.setUpdateTime(time);
		int result = bigBigTestService.update(bigBigTest);
		assign("result", result);
		assign("object", bigBigTest);
		return displayJSON();
	}
	
	/* 数据库操作示例 - 读取 */
	public String modelRAction() throws Exception {
		int page = ValidateUtil.filterInteger(get("page"), true, 0, null, null);
		int pageSize = 15;
		long count = bigBigTestService.getCount();
		List<Map<String, Object>> list = bigBigTestService.getPage("*", "update_time desc", page, pageSize);
		assign("page", page);
		assign("pageSize", pageSize);
		assign("count", count);
		assign("list", list);
		return displayJSON();
	}
	
	/* 数据库操作示例 - 删除 */
	public String modelDAction() throws Exception {
		Long id = ValidateUtil.filterLong(get("id"), true, 0L, null, null);
		int result = bigBigTestService.deleteByIds(id);
		assign("deleteId", id);
		assign("result", result);
		return displayJSON();
	}
}
