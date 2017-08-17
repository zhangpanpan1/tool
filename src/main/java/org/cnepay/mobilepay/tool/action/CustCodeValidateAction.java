package org.cnepay.mobilepay.tool.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.cnepay.mobilepay.tool.service.CustMobileCodeService;
import org.cnepay.mobilepay.tool.views.CustMobileCodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/cust")
public class CustCodeValidateAction extends AbstractAction {
	
	@Autowired
	private CustMobileCodeService custMobileCodeService = null;

	public CustMobileCodeService getCustMobileCodeService() {
		return custMobileCodeService;
	}

	public void setMessageValidateService(CustMobileCodeService custMobileCodeService) {
		this.custMobileCodeService = custMobileCodeService;
	}

	@RequestMapping("/getCustMobileCode.action")
	public ModelAndView getCustMobileCode(@RequestParam(value="rownum",required=false,defaultValue="") String rownum){
		logger.info("加载短信验证码请求处理，该请求来自于：[" + request.getRemoteAddr() + ";" + request.getRemoteHost() + "]/user=" + request.getRemoteUser());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("custmobilevalidatecode");
		if(!StringUtils.isBlank(request.getParameter("checkbox"))){
			modelAndView.addObject("checkbox","checked=\"checked\"");
		}
		int rows = 10;
		if(NumberUtils.isNumber(rownum)){
			rows = NumberUtils.toInt(rownum, 10);
		}
		List<CustMobileCodeEntity> entitys = this.custMobileCodeService.loadMessageValidateCode(String.valueOf(rows));
		
		if(entitys == null || entitys.size() == 0){
			modelAndView.addObject("message", "未找到任何数据，请检测数据库配置或数据库数据!");
		} else {
			modelAndView.addObject("message", "本次加载数据共：" + entitys.size() + "条数；请求最大显示条数：" + rows);
			modelAndView.addObject("messageValidate", entitys);
		}
		modelAndView.addObject("rownum", rows);
		modelAndView.addObject("action", "cust/getCustMobileCode.action");
		return modelAndView;
	}
	
	
	@RequestMapping("/getSerialCode.action")
	public ModelAndView getSerialCode(@RequestParam(value="rownum",required=false,defaultValue="") String rownum){
		logger.info("加载短信验证码请求处理，该请求来自于：[" + request.getRemoteAddr() + ";" + request.getRemoteHost() + "]/user=" + request.getRemoteUser());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("custserialcode");
		if(!StringUtils.isBlank(request.getParameter("checkbox"))){
			modelAndView.addObject("checkbox","checked=\"checked\"");
		}
		int rows = 10;
		if(NumberUtils.isNumber(rownum)){
			rows = NumberUtils.toInt(rownum, 10);
		}
		
		List<String>  list  = this.custMobileCodeService.getSerialCode(String.valueOf(rows));
		modelAndView.addObject("serialcode", list);
		modelAndView.addObject("rownum", rows);
		modelAndView.addObject("action", "cust/getSerialCode.action");
		return modelAndView;
	}
	
}
