package com.twocrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

    @PostMapping("/registerCompany")
    public ModelAndView registerCompany(@RequestParam String companyName,
                                        @RequestParam String userId,
                                        @RequestParam String password) {
        // 여기에 데이터 처리 로직을 추가합니다. 예를 들어, 데이터베이스에 저장
        // ...

        // 처리 후 리다이렉트 또는 적절한 뷰 반환
        return new ModelAndView("redirect:/somePage");
    }
}