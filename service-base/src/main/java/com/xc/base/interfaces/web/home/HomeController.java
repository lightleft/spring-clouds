package com.xc.base.interfaces.web.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xc.common.global.web.base.BaseController;
import com.xc.common.global.web.res.ResultVO;

@RestController
public class HomeController extends BaseController {

	@GetMapping("")
	public ResultVO home() {
		return result("this home");
	}
}
