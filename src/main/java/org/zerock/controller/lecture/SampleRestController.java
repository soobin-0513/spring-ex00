package org.zerock.controller.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
//p 358
public class SampleRestController {

	//p359
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {

		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN);

		return "안녕하세요";
	}
	
	// 책 361
		@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
		public SampleVO getSample() {

			return new SampleVO(11, "스타", "로드");
		}
		// 책 363
		@GetMapping("/getList")
		public List<SampleVO> getList() {

			List<SampleVO> list = new ArrayList<>();

			for (int i = 1; i < 10; i++) {
				list.add(new SampleVO(i, i + "First", i + "Last"));
			}

			return list;
		}

		// 책 364
		@GetMapping("/getMap")
		public Map<String, SampleVO> getMap() {

			Map<String, SampleVO> map = new HashMap<>();
			map.put("First", new SampleVO(111, "그루트", "주니어"));

			return map;
		}
		
		// 책 366

		@GetMapping("/product/{cat}/{pid}")
		public String[] getPath(
				@PathVariable("cat") String cat,
				@PathVariable("pid") Integer pid
				) {

			return new String[] {"category: " + cat, "productid: " + pid};
		}

	}